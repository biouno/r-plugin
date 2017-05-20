package org.biouno.r;

import hudson.EnvVars;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.TaskListener;
import org.jenkinsci.plugins.durabletask.BourneShellScript;
import org.jenkinsci.plugins.durabletask.Controller;
import org.jenkinsci.plugins.durabletask.DurableTask;
import org.jenkinsci.plugins.workflow.steps.durable_task.DurableTaskStep;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Step for workflow/pipeline compatibility.
 */
public class RStep extends DurableTaskStep {

    private static final String R_EXECUTABLE = "Rscript";
    private static final String FILE_PREFIX = "jenkins";
    private static final String FILE_EXTENSION = ".R";

    private final String command;

    @DataBoundConstructor
    public RStep(String command) {
        this.command = checkNotNull(command, Messages.R_NullCommandError());
    }

    /**
     * Returns the set R command to execute
     *
     * @return the R command to execute
     */
    public String getCommand() {
        return command;
    }

    @Override
    protected DurableTask task() {
        return new RScript(command);
    }

    @Extension
    public static final class DescriptorImpl extends DurableTaskStepDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.R_DisplayName();
        }

        @Override
        public String getFunctionName() {
            return Messages.R_FunctionName();
        }
    }

    static final class RScript extends DurableTask {

        private String command;
        private boolean captureOutput = false;

        public RScript(String command) {
            this.command = command;
        }

        @Override
        public Controller launch(EnvVars env, FilePath workspace, Launcher launcher, TaskListener listener)
                throws IOException, InterruptedException {
            String shellScript = getShellScriptExecutingRScript(workspace, command);
            BourneShellScript bourneShellScript = new BourneShellScript(shellScript);

            if (captureOutput) {
                bourneShellScript.captureOutput();
            }
            return bourneShellScript.launch(env, workspace, launcher, listener);
        }

        private static String getShellScriptExecutingRScript(FilePath ws, String command) {
            try {
                FilePath rScript = ws.createTextTempFile(FILE_PREFIX, FILE_EXTENSION, command, true);
                return R_EXECUTABLE + " " + rScript.getRemote();
            } catch (IOException e) {
                throw new IllegalStateException(Messages.R_FileCreationError(), e);
            } catch (InterruptedException e) {
                throw new IllegalStateException(Messages.R_FileCreationError(), e);
            }
        }

        @Override
        public void captureOutput() throws UnsupportedOperationException {
            captureOutput = true;
        }
    }
}
