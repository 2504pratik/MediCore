pipeline {
    agent any

    environment {
        // Define environment variables to use across stages
        GIT_REPO_URL = 'https://github.com/2504pratik/MediCore.git'
        DOCKER_COMPOSE_FILE = 'docker-compose.yml'
        DOCKER_CREDENTIALS = 'medicore'  // Replace with Jenkins credentials ID
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Check out code from GitHub
                git credentialsId: "${DOCKER_CREDENTIALS}", url: "${GIT_REPO_URL}"
            }
        }

        stage('Build and Push Docker Images') {
            steps {
                script {
                    // Navigate to each service directory, build Docker images, and push (optional)
                    def services = ['patient-service', 'doctor-service', 'medical-store-service', 'auth-service']
                    for (service in services) {
                        dir(service) {
                            sh """
                                docker build -t ${service}:latest .
                            """
                        }
                    }
                }
            }
        }

        stage('Start Services with Docker Compose') {
            steps {
                script {
                    // Run the services using Docker Compose
                    sh "docker-compose -f ${DOCKER_COMPOSE_FILE} up -d"
                }
            }
        }

        stage('Post-Build Cleanup') {
            steps {
                script {
                    // Optional: clean up unused Docker images or containers after running tests
                    sh "docker image prune -f"
                }
            }
        }
    }

    post {
        always {
            // Bring down the Docker Compose services after pipeline completion
            sh "docker-compose -f ${DOCKER_COMPOSE_FILE} down"
        }
        cleanup {
            // Cleanup workspace
            cleanWs()
        }
    }
}