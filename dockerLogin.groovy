def login(String credentialsId) {
    try {
        // Fetch credentials securely
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'username', passwordVariable: 'password')]) {
            // Execute docker login
            def result = sh(script: """
                #! /bin/bash
                echo ${password} | docker login -u '7002370412' --password-stdin
            """, returnStdout: true).trim()

            echo "Docker login is successful"
            return result
        }
    } catch (Exception e) {
        echo "Error occurred: ${e.message}"
        return null
    }
}
return this
