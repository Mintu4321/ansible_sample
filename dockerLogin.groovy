def login(String credentialsId) {
    try {
        // Fetch credentials securely
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'username', passwordVariable: 'password')]) {
            // Execute docker login
            echo "username: ${username}"
            set -x
            def result = sh(script: 'docker login -u "${username}" -p "${password}"', returnStdout: true).trim()
            set +x
            echo "Docker login is successful"
            return result
        }
    } catch (Exception e) {
        echo "Error occurred: ${e.message}"
        
    }
}
return this
