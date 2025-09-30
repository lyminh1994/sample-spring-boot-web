pipeline {
    agent { label 'raspberry-pi-agent' }
    stages {
        stage('Clean') {
            steps {
                sh './mvnw clean'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw package'
            }
        }
    }
}
