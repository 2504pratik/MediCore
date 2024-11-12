pipeline {
    agent any

    tools {
        maven 'maven_3_9_9'  // Ensure 'maven_3_5_0' is correctly set up in Jenkins
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

        stage('Build Docker image') {
            steps {
                script{
                    sh 'docker build -t medicore/patient-service .'
                }
            }
        }
    }
}