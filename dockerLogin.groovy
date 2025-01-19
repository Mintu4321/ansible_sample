
def dockerLogin(String credentialsId) {
    try {
       withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'username', passwordVariable: 'password')]) {
        def result = sh(script: "docker login -u ${username} -p ${password}")
        echo "docker login is successful"
        return result
       }
        }
    catch (Exception e) {
        echo "Error occurred as: ${e.message}"



    }

}

