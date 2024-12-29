[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/r.svg)](https://plugins.jenkins.io/r)
[![GitHub release](https://img.shields.io/github/release/jenkinsci/r-plugin.svg?label=changelog)](https://github.com/jenkinsci/r-plugin/releases/latest)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/r.svg?color=blue)](https://plugins.jenkins.io/r)

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

## Roadmap

- Use Jenkins built-in editor with syntax highlighting (check if it
    supports R)
