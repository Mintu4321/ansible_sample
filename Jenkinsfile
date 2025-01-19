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
    environment {
        DOCKER_SOCKET = '/var/run/docker.sock'
        PATH = "${env.PATH}:/usr/bin/docker"
    }
    stages {
        stage('Login to Docker') {
            steps {
                script {
                    def credentials = load 'ansible_sample/dockerLogin.groovy'
                    // Now call the dockerLogin function after it has been defined
                    credentials.dockerLogin('docker_login')
                }
            }
        }
    }
}

