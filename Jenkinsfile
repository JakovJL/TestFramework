pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven39'
    }

    environment {
        HEADLESS = 'true'
        BROWSER  = 'chrome'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat "mvn clean test -Dheadless=%HEADLESS% -Dbrowser=%BROWSER%"
            }
        }
    }

    post {
        always {
            allure includeProperties: false,
                   jdk: 'JDK25',
                   results: [[path: 'target/allure-results']]
        }
    }
}