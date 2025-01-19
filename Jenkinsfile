//  pipeline {
//     agent { label 'docker-agent' }
//     environment {
//         DOCKER_SOCKET = '/var/run/docker.sock'
//         PATH = "${env.PATH}:/usr/bin/docker"
//     }
//     stages {
//         stage('Hello') {
//             steps {
//                 sh '''
//                     echo "Shell: $SHELL"
//                     echo "DOCKER_SOCKET: $DOCKER_SOCKET"
//                     ansible-playbook playbook.yml
//                 '''
//             }
//         }
//         stage('docker check') {
//             steps {
//                 sh '''
//                     echo "Using Docker socket: $DOCKER_SOCKET"
//                     docker --host=unix://${env.DOCKER_SOCKET} images
//                 '''
//             }
//         }
//     }
// }


def dockerLogin(String credentialsId) {
    try {
        // Fetch credentials securely
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'username', passwordVariable: 'password')]) {
            // Execute docker login
            def result = sh(script: "docker login -u ${username} -p ${password}", returnStdout: true).trim()
            echo "Docker login is successful"
            return result
        }
    } catch (Exception e) {
        echo "Error occurred: ${e.message}"
    }
}

pipeline {
    agent {
        label 'azure'
    }

    stages {
        stage('Login to Docker') {
            steps {
                script {
                    // Now call the dockerLogin function after it has been defined
                    dockerLogin('docker_login')
                }
            }
        }
    }
}

