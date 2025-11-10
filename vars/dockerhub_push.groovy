// Shared library function to push a Docker image to Docker Hub
def call(String imageName = "my_application", String tag = "latest", String credentialsId = "dockerhubcredentials") {
    echo "Pushing Docker image ${imageName}:${tag} to Docker Hub..."
    
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker tag ${imageName}:${tag} \$DOCKER_USER/${imageName}:${tag}
            docker push \$DOCKER_USER/${imageName}:${tag}
            docker logout
        """
    }
    
    echo "Docker image ${imageName}:${tag} pushed successfully."
}
