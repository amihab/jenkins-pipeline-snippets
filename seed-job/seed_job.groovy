//create folder
folder(folderName){}

//create pipeline Job based on parameters
pipelineJob("${folderName}/${jobName}-1") {
    definition {
        cps {
            sandbox()
            script("""
                echo "Job: ${jobName} - started"
                echo "Warning: about to sleep 10 seconds"
                sleep 10
                echo "Job: ${jobName} - finished"
            """.stripIndent())
        }
    }
}


def createPipelineJob(job, params) {
    pipelineJob("${job}") {
        definition {
            cps {
                sandbox()
                script("""
                    echo "Job: ${job} - started"
                    echo "Warning: about to sleep 10 seconds"
                    sleep 10
                    echo "Job: ${job} - finished"
                """.stripIndent())
            }
            parameters {
                params.each {param ->
                    switch (param.Type) {
                        case 'string':
                            stringParam(param.Name, param.Default, param.Desc)
                            break
                        case 'boolean':
                            booleanParam(param.Name, param.Default, param.Desc)
                            break
                        case 'choice':
                            choiceParam(param.Name, param.Default, param.Desc)
                            break     
                    }   
                } 
            }
        }
    }
}

//create additional jobs based on map
def jobsList = [
    "${folderName}/${jobName}-2",
    "${folderName}/${jobName}-3",
    "${folderName}/${jobName}-4",
]

def jobParams = [
    [Type: 'string', Name: 'COUNTRY', Default: 'Israel', Desc: 'Input Country name'],
    [Type: 'choice', Name: 'CITY', Default: ['Jerusalem', 'TelAviv', 'Raanana'], Desc: 'Select City Name'],
    [Type: 'boolean', Name: 'IS_CLEAN', Default: true, Desc: 'Is City clean'],
]

jobsList.each{job ->
    createPipelineJob(job, jobParams)  
}
