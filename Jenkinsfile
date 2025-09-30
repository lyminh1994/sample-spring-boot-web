pipeline {
    agent none
    stages {
        stage('Clean') {
            agent { label 'raspberry-pi-agent' }
            steps {
                sh './mvnw clean'
            }
        }
        stage('Test') {
            agent { label 'raspberry-pi-agent' }
            steps {
                sh './mvnw test'
            }
        }
        stage('Build') {
            agent { label 'raspberry-pi-agent' }
            steps {
                sh './mvnw package'
            }
        }
    }
}
