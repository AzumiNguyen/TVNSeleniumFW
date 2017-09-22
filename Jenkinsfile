pipeline{
    node {
        def mvnHome
        stage('Preparation') { // for display purposes
          git 'https://github.com/cuhavp/TVNSeleniumFW.git'
          mvnHome = tool 'M3'
        }
        stage('Run Selenium Test') {
          slackSend channel: '#auto',color:'#581845',message:"started ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
          parallel(
              "Chrome"  : {
                  slackSend channel: '#auto', color: 'good', message: 'Start Test On Chrome'
                  sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dbrower.name=chrome clean test"
              },
              "Firefox" : {
                  slackSend channel: '#auto', color: 'good', message: 'Start Test On Firefox'
                  sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dbrower.name=firefox clean test"
              },
              "Safari"  : {
                  slackSend channel: '#auto', color: 'good', message: 'Start Test On Safari'
                  sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dbrower.name=safari clean test"

              }
              )
        }
        stage('Results') {
          allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
          slackSend channel: '#auto',color:'#581845',message:"Finished ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}/allure|Open>)"
        }
    }
}