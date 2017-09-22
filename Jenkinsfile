pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
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