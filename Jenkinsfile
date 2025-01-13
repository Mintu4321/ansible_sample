pipeline {
    agent {
        label 'docker-agent'  // Make sure the agent label matches the correct agent node
    }
    environment {
        // Set the path for the Docker socket to be accessible
        DOCKER_SOCKET = '/var/run/docker.sock'
        PATH = "${env.PATH}:/usr/bin/docker" // Ensure the docker binary is in the PATH
    }
    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    // Run Docker commands from within the pipeline
                    sh 'docker --host=unix://${env.DOCKER_SOCKET} images'
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    // Run a Docker container from an image (just as an example)
                    sh 'docker --host=unix://${env.DOCKER_SOCKET} run hello-world'
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
