/*
 * The MIT License
 *
 * Copyright (c) <2012> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.biouno.r;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.FilePath;
import hudson.model.Descriptor;
import hudson.tasks.Builder;
import hudson.tasks.CommandInterpreter;

/**
 * Invokes the R interpreter and invokes the R script entered on the Jenkins 
 * build configuration.
 * 
 * It is expected that the R interpreter is available on the system PATH.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class R extends CommandInterpreter {

	@DataBoundConstructor
	public R(String command) {
		super(command);
	}

	@Override
	public String[] buildCommandLine(FilePath script) {
		return new String[]{"Rscript", script.getRemote()};
	}

	@Override
	protected String getContents() {
		return command;
	}

	@Override
	protected String getFileExtension() {
		return ".R";
	}
	
	@Extension
	public static class DescriptorImpl extends Descriptor<Builder> {
		/* (non-Javadoc)
		 * @see hudson.model.Descriptor#getDisplayName()
		 */
		@Override
		public String getDisplayName() {
			return Messages.R_DisplayName();
		}
		
	}

}
