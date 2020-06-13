A simple plug-in to invoke [R](http://www.r-project.org/) interpreter
and execute an R script.

## Description

With this script you can execute [R](http://www.r-project.org/) scripts as part of your build. This plug-in was created
for use in [BioUno](https://biouno.org/) (sponsored by [TupiLabs](https://tupilabs.com/)) project, and released to
Jenkins as well.

![](https://wiki.jenkins.io/download/attachments/63143951/rjenkins.png?version=1&modificationDate=1342933467000&api=v2)

You can also use environment variables, tokens created by other plug-ins
or parameters via 

```groovy
paste('Date:', Sys.getenv('BUILD_ID'))
```

This will print something similar to *Date: 2014-02-17_15-48-59*

# Using and Integrating the R-Plugin with Jenkins

Additional instructions can be found on the [BioUno project site](https://biouno.org/tutorials/r-plugin/)

## Sponsors

- [BioUno](https://biouno.org/)
- [TupiLabs](https://tupilabs.com/)

<img src="https://wiki.jenkins.io/download/attachments/63143951/logo1.png?version=1&modificationDate=1342933658000&api=v2" width="300px" />

For commercial support, please get contact us via [@tupilabs](https://twitter.com/tupilabs)

## Change Log

### Release 0.6 (June, 14, 2020)

- [JENKINS-62677](https://issues.jenkins-ci.org/browse/JENKINS-62677):
move docs to GitHub
- [JENKINS-62676](https://issues.jenkins-ci.org/browse/JENKINS-62676):
update Jenkins parent and pom/build

### Release 0.5 (May, 20, 2017)

- [pull request #5](https://github.com/jenkinsci/r-plugin/pull/5):
Implement captureOutput()
- [pull request #6](https://github.com/jenkinsci/r-plugin/pull/6):
[WIP] Create R script file in workspace  

### Release 0.4 (Jan, 13, 2017)

- [pull request #1](https://github.com/jenkinsci/r-plugin/pull/1):
Make plugin compatible to Jenkins Pipeline plugin
- [pull request #3](https://github.com/jenkinsci/r-plugin/pull/3): Revert "Make
plugin compatible to Jenkins Pipeline plugin"
- [pull request #4](https://github.com/jenkinsci/r-plugin/pull/4):
Add Jenkins Pipeline compatibility

### Release 0.3 (Jul, 27, 2016)

- [pull request #2](https://github.com/jenkinsci/r-plugin/pull/2):
Use codemirror styles for textarea input (i.e. syntax highlighting).
(thanks to @kadrach)

### Release 0.2 (Jul, 22, 2012)

- Fixing plug-in name in pom.xml and creating Wiki page.

### Release 0.1 (Jul, 10, 2012)

- Initial release.

## Roadmap

- Use Jenkins built-in editor with syntax highlighting (check if it
    supports R)
