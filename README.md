# Jenkins Pipeline - Snippets

### What’s Jenkins Pipeline?

Jenkins Pipeline (or simply "Pipeline" with a capital "P") is a suite of plugins which supports implementing and integrating continuous delivery pipelines into Jenkins.

A continuous delivery (CD) pipeline is an automated expression of your process for getting software from version control right through to your users and customers. 
Every change to your software (committed in source control) goes through a complex process on its way to being released. 
This process involves building the software in a reliable and repeatable manner, as well as progressing the built software (called a "build") through multiple stages of testing and deployment.

The definition of a Jenkins Pipeline is written into a text file (called a **Jenkinsfile**) which in turn can be committed to a project’s source control repository.
This is the foundation of "Pipeline-as-code"; treating the CD pipeline a part of the application to be versioned and reviewed like any other code.

**Main site:** https://jenkins.io/doc/book/pipeline

**Workflow Steps:** https://jenkins.io/doc/pipeline/steps/workflow-basic-steps

```groovy
def nodeName = 'generic'

node(nodeName) {
	stage('welcome') {
		echo "Jenkins Pipeline Greets DevOps community"
	}	
}
```

### About this repository

This repository includes some basic introduction for the Jenkins Pipeline DSL language.

The examples are **_very light_** but yet ease the learning curve for others.
