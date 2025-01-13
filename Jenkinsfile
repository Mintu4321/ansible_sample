 pipeline {
    agent { label 'docker-agent' }
    environment {
        DOCKER_SOCKET = '/var/run/docker.sock'
        PATH = "${env.PATH}:/usr/bin/docker"
    }
    stages {
        stage('Hello') {
            steps {
                sh '''
                    echo "Shell: $SHELL"
                    echo "DOCKER_SOCKET: $DOCKER_SOCKET"
                    ansible-playbook playbook.yml
                '''
            }
        }
        stage('docker check') {
            steps {
                sh '''
                    echo "Using Docker socket: $DOCKER_SOCKET"
                    docker --host=unix://${env.DOCKER_SOCKET} images
                '''
            }
        }
    }
}



// pipeline {
//     agent {
//         docker {
//             image '7002370412/jenkins-agent:latest'
//             args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'
//         }
//     }
//     stages {
//         stage('Test Docker') {
//             steps {
//                 sh 'docker version'
//             }
//         }
//     }
// }
