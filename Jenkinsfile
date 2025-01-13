pipeline {
    agent { 
        label 'docker-agent'       
    }
    environment {
        DOCKER_SOCKET = '/var/run/docker.sock'
        PATH = "${env.PATH}:/opt/homebrew/bin"
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
