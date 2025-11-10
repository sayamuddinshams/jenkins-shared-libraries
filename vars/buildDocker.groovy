// A simple shared library function to build a Docker image
def call(String imageName = "my_application", String tag = "latest") {
    echo "Building Docker image: ${imageName}:${tag}..."
    
    // Run Docker build command
    sh "docker build -t ${imageName}:${tag} ."
    
    echo "Docker image ${imageName}:${tag} built successfully."
}
