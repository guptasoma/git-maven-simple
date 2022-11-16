pipeline {
    agent any
// custom environment variable
    environment{
        NEW_VERSION='1.3.0'   
    }
 //parameters in Jenkins File
    parameters{
        string(name:'Java Jenkins Example',defaultValue:'',description:'')
        choice(name:'VERSION',choices:['1.1.0','1.2.0','1.3.0'],description:'')
        booleanParam(name:'executeTests',defaultValue:true,description:'')
    }
    stages {
        stage('Build') {
            steps {
                echo "Building.. with build version ${NEW_VERSION}"
            }
        }
        stage('Test') {
            when{
                expression{
                    params.executeTests       
                }
            }
            steps {
                echo 'Testing..only dev branch'
                echo "Testing using version ${params.VERSION}"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
