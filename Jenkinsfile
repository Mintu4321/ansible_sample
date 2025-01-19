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



pipeline {
    agent any
      
    stages {
        stage('Docker login') {
            steps {
              script {
               def credentialsId = "docker_login"
               def loginResult =  dockerLogin(String credentialsId)
               if (loginResult == null) {
                        error("Docker login failed. Stopping the pipeline.")
                    } else {
                        echo "Docker login result: ${loginResult}"
                    }
              }
            }
        }
    }
}
