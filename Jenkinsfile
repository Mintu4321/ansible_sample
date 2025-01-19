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
        environment {
        DOCKER_SOCKET = '/var/run/docker.sock'
        PATH = "${env.PATH}:/usr/bin/docker"
    }
    stages {
        stage('Docker Login') {
            steps {
                script {
                    // Load the dockerLogin.groovy script
                    def dockerLogin = load 'dockerLogin.groovy'
                    
                    // Call the login function and pass the credentialsId
                    def loginResult = dockerLogin.login('docker_login')

                    // Check the result (optional, based on your logic)
                    if (loginResult == null) {
                        error "Docker login failed!"
                    } else {
                        echo "Docker login was successful!"
                    }
                }
            }
        }
    }
}
