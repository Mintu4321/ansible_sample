pipeline {
    agent { 
        label 'docker-agent'
        
    }

    stages {
        stage('Hello') {
            steps {
                sh 'ansible-playbook playbook.yml'
            }
        }
    }
}
