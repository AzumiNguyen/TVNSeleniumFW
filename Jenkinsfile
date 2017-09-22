pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dbrower.name=firefox clean test'
                allure commandline: 'allure', includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
            }

            post {
                success {
                   slackSend channel: '#auto',color:'good',message:"Finished ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}/allure|Open>)"
                }
            }
        }
    }
}