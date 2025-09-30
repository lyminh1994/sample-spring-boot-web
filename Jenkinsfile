pipeline {
    agent none
    stages {
        stage('Build') {
            agent { label 'raspberry-pi-agent' }
            steps {
                sh './mvnw clean package' 
            }
        }
        stage('Test') {
            agent { label 'raspberry-pi-agent' }
            steps {
                bat './mvnw test'
            }
        }
    }
}
