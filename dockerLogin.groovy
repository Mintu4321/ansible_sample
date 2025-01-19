def login(String credentialsId) {
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
        return None
    }
}
return this
