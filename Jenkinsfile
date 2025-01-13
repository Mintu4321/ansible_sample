// pipeline {
//     agent {        
//         label 'docker-agent'
//      }
//     environment {
//         DOCKER_SOCKET = '/var/run/docker.sock'
//         PATH = "${env.PATH}:/opt/homebrew/bin"
//     }
    
//     stages {
//         stage('Hello') {
//             steps {
//                 sh 'ansible-playbook playbook.yml'
//             }
//         }
//         stage('docker check') {
//             steps {
//                 sh 'docker ps -a'
//             }
//         }
//     }
// }

pipeline {
    agent {
        docker {
            image '7002370412/jenkins-jenkins:latest'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker'
        }
    }
    stages {
        stage('Test Docker') {
            steps {
                sh 'docker version'
            }
        }
    }
}
