// A simple shared library function to checkout a Git repo
def call(String repoUrl, String branchName = "main") {
    echo "Checking out code from ${repoUrl} (branch: ${branchName})..."
    
    // Jenkins pipeline step to clone the repo
    git url: repoUrl, branch: branchName
    echo 'Checkout stage finished.'
    echo "Code cloned successfully."
}
