pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage ('Build') {
                parallel(
                        'firefox': {
                                    slackSend channel: '#auto', color: 'good', message: 'Start Test On Firefox'
                                    sh 'mvn -Dbrower.name=firefox clean test'
                                 },
                        'chrome': {
                                    slackSend channel: '#auto', color: 'good', message: 'Start Test On Chrome'
                                    sh 'mvn -Dbrower.name=chrome clean test'
                                 },
                        'safari': {
                                    slackSend channel: '#auto', color: 'good', message: 'Start Test On Chrome'
                                    sh 'mvn -Dbrower.name=safari clean test'
                                 }
                        )
                allure commandline: 'allure', includeProperties: false, jdk: '', results: [[path: '**/allure-results']]


            post {
                success {
                   slackSend channel: '#auto',color:'good',message:"Finished ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}/allure|Open>)"
                }
                failure {
                   slackSend channel: '#auto',color:'bad',message:"Finished ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}/allure|Open>)"
                }
            }
        }
    }
}