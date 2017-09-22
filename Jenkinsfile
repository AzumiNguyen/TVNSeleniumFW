pipeline{
    agent any
    stages {
        stage 'Preparation'
        node{
          checkout scm
        }
        stage 'Run Selenium Test'
        node{
          slackSend channel: '#auto',color:'#581845',message:"started ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
          parallel(
              "Chrome"  : {
                  def mvnHome = tool 'M3'
                  slackSend channel: '#auto', color: 'good', message: 'Start Test On Chrome'
                  sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dbrower.name=chrome clean test"
              },
              "Firefox" : {
                  def mvnHome = tool 'M3'
                  slackSend channel: '#auto', color: 'good', message: 'Start Test On Firefox'
                  sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dbrower.name=firefox clean test"
              },
              "Safari"  : {
                  def mvnHome = tool 'M3'
                  slackSend channel: '#auto', color: 'good', message: 'Start Test On Safari'
                  sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dbrower.name=safari clean test"

              },failFast: true
              )
        }
        stage 'Results'
        node{
          allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
          slackSend channel: '#auto',color:'#581845',message:"Finished ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}/allure|Open>)"
        }
    }
}