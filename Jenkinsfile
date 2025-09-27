pipeline {
    agent {
        agent-1
    }
    stages {
        stage('Build') { 
            steps {
                sh './mvnw clean package' 
            }
        }
    }
}
