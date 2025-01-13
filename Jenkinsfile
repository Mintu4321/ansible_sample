pipeline {
    agent { 
        label 'docker-agent'       
    docker {
            image '7002370412/jenkins-jenkins:latest'  // Docker image for the ephemeral agent
            args '-v /var/run/docker.sock:/var/run/docker.sock'  // Mount Docker socket
        }
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
