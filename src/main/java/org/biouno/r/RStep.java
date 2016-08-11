package org.biouno.r;

import hudson.Extension;
import hudson.FilePath;
import org.jenkinsci.plugins.durabletask.BourneShellScript;
import org.jenkinsci.plugins.durabletask.DurableTask;
import org.jenkinsci.plugins.workflow.steps.StepContextParameter;
import org.jenkinsci.plugins.workflow.steps.durable_task.DurableTaskStep;
import org.jenkinsci.plugins.workflow.steps.durable_task.DurableTaskStep.DurableTaskStepDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public class RStep extends DurableTaskStep {

    private static final String R_EXECUTABLE = "Rscript";
    private static final String FILE_PREFIX = "jenkins";
    private static final String FILE_EXTENSION = ".R";

    @StepContextParameter private FilePath ws;

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
        
        String shellScript = getShellScriptExecutingRScript();
        return new BourneShellScript(shellScript);
    }

    private String getShellScriptExecutingRScript() {
        try {
            FilePath rScript = ws.createTextTempFile(FILE_PREFIX, FILE_EXTENSION, command, false);
            return R_EXECUTABLE + " " + rScript.getRemote();
        } catch (IOException e) {
            throw new IllegalStateException(Messages.R_FileCreationError(), e);
        } catch (InterruptedException e) {
            throw new IllegalStateException(Messages.R_FileCreationError(), e);
        }
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

}
