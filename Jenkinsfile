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
    agent {
        label 'azure'
        
    }
      
    stages {
        stage('Docker login') {
            steps {
              script {
               def credentialsId = "docker_login"
               def myScript = load 'dockerLogin.groovy'
               def loginResult =  myScript.dockerLogin(credentialsId)
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
