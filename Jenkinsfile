pipeline {
    agent {
        label 'raspberry-pi-agent'
    }
    stages {
        stage('Build') { 
            steps {
                sh './mvnw clean package' 
            }
        }
    }
}
