pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage ('Test') {
            parallel{
                stage('firefox'){
                 slackSend channel: '#auto', color: 'good', message: 'Start Test On Firefox'
                 sh 'mvn -Dbrower.name=firefox clean test'
                }
                stage('chrome'){
                 slackSend channel: '#auto', color: 'good', message: 'Start Test On Firefox'
                 sh 'mvn -Dbrower.name=chrome clean test'
                }
                stage('safari'){
                 slackSend channel: '#auto', color: 'good', message: 'Start Test On Firefox'
                 sh 'mvn -Dbrower.name=safari clean test'
                }
            }
        }
        stage('Reporting'){
          steps{
                 allure commandline: 'allure', includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
               }
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