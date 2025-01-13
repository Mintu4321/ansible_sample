pipeline {
    agent { 
        label 'docker-agent'  
        args '-v /var/run/docker.sock:/var/run/docker.sock' 
    }
    environment {
        DOCKER_SOCKET = '/var/run/docker.sock'
    }
    
    stages {
        stage('Hello') {
            steps {
                sh 'ansible-playbook playbook.yml'
            }
        }
        stage('docker check') {
            steps {
                sh 'docker ps -a'
            }
        }
    }
}
