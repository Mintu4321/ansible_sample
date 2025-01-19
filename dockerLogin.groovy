def login(String credentialsId) {
    try {
        // Fetch credentials securely
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'username', passwordVariable: 'password')]) {
            // Execute docker login
           
            
            sh '''#!/bin/bash
                echo "username: ${username}"
                docker login -u "$DOCKER_USERNAME" --password-stdin
            '''
            echo "Docker login is successful"
            
        }
    } catch (Exception e) {
        echo "Error occurred: ${e.message}"
        
    }
}
return this
