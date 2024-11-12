pipeline {
    agent any

    tools {
        maven 'maven_3_9_9'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/2504pratik/MediCore.git']]])
            }
        }
        stage('Build Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Build Docker images') {
            steps {
                script {
                    // Build Docker image for patient-service
                    sh 'docker build -t medicore/patient-service -f patient-service/Dockerfile .'

                    // Build Docker image for doctor-service
                    sh 'docker build -t medicore/doctor-service -f doctor-service/Dockerfile .'

                    // Build Docker image for medical-store-service
                    sh 'docker build -t medicore/medical-store-service -f medical-store-service/Dockerfile .'

                    // Build Docker image for another-service
                    sh 'docker build -t medicore/auth-service -f auth-service/Dockerfile .'
                }
            }
        }
    }
}