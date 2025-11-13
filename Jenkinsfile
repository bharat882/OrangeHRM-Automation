pipeline {
    agent any
    tools {
        maven 'Maven-3.9'     // matches the name you set under Manage Jenkins → Tools
        jdk 'JDK17'           // same as your configured JDK
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    credentialsId: '<YOUR_CREDENTIAL_ID>',
                    url: 'https://github.com/bharat882/OrangeHRM-Automation'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }
}
