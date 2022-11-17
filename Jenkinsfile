pipeline {
    agent any
// custom environment variable
    environment{
        NEW_VERSION='1.3.0' 
        SHOW_NEXT='true'  
    }
 //parameters in Jenkins File
    parameters{
        string(name:'DEPLOY_STRING',defaultValue:'Deployed successfully',description:'')
        choice(name:'VERSION',choices:['1.1.0','1.2.0','1.3.0'],description:'')
        booleanParam(name:'executeTests',defaultValue:true,description:'')
        text(name:'DEPLOY_TEXT',defaultValue:'Never\nGive\nUp',description:'')
    }
    stages {
    	stage('Something'){
    		when {
				expression{
					env.SHOW_NEXT.toBoolean() == true
				}				
			}
			steps{
				echo 'Something is working'
			}
    	}
        stage('Build') {
            steps {
                echo "Building.. with build version ${NEW_VERSION}"
                bat 'mvn -B -DskipTests clean package'
                //check OS version
                script{
	                if(isUnix()) {
	                	echo 'Unix'
	                }else{
	                	echo 'Windows'
	                }
                }
            }
        }
        stage('Test') {
            when{
                expression{
                    params.executeTests       
                }
            }
            steps {
                echo 'Testing..only master branch'
                bat 'mvn test'
                echo "Testing using version ${params.VERSION}"
            } 
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying....${BRANCH_NAME}"
                echo "${params.DEPLOY_STRING}"
            }
        }
    }
    post {
        always {
                echo 'I will always execute this...'
                echo "${params.DEPLOY_TEXT}"
        }
    }
}
