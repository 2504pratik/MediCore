node {
    // Define services with their paths and ports
    def services = [
        [name: "patient-service", port: 8081, path: "/patient-service"],
        [name: "doctor-service", port: 8082, path: "/doctor-service"],
        [name: "store-service", port: 8083, path: "/medical-store-service"]
    ]

    def repoUrl = "https://github.com/2504pratik/MediCore.git" // Update with your repository URL
    def credentialsId = "medicore" // Replace with your Jenkins GitHub credentials ID

    try {
        stage('Clone Repo') {
            // Clone the whole repo once
            git url: repoUrl,
                credentialsId: credentialsId,
                branch: 'main'
        }

        for (service in services) {
            stage("Build Docker Image - ${service.name}") {
                dir(service.path) {
                    dockerImage = docker.build("${service.name}:${env.BUILD_NUMBER}", ".")
                }
            }

            stage("Deploy Docker Container - ${service.name}") {
                def dockerImageTag = "${service.name}:${env.BUILD_NUMBER}"

                echo "Deploying Docker Image Tag: ${dockerImageTag}"

                // Stop and remove any running container for this service
                sh "docker stop ${service.name} || true && docker rm ${service.name} || true"

                // Run the container on its designated port
                sh "docker run --name ${service.name} -d -p ${service.port}:${service.port} ${dockerImageTag}"
            }
        }
    } catch (e) {
        currentBuild.result = "FAILED"
        throw e
    } finally {
        // Optional notifications if enabled
        // notifyBuild(currentBuild.result)
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    buildStatus = buildStatus ?: 'SUCCESSFUL'
    def now = new Date()
    def subject = "${buildStatus} - Microservices Deployment - ${env.JOB_NAME} Build #${env.BUILD_NUMBER}"
    def details = """<p>${buildStatus} JOB for ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}</p>
        <p>Time: ${now}</p>
        <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""
}