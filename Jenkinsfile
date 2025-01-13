pipeline {
    agent {        
        label 'docker-agent'
     }
    environment {
        DOCKER_SOCKET = '/var/run/docker.sock'
        PATH = "${env.PATH}:/usr/bin/docker"
    }
    
    stages {
        stage('Hello') {
            steps {
                sh 'ansible-playbook playbook.yml'
            }
        }
        stage('docker check') {
            steps {
                script {
                    // Ensure Docker socket is mounted properly (in case of running in a container)
                    sh "docker --host=unix://${env.DOCKER_SOCKET} images"
                }
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
