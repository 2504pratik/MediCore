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
                dir('patient-service') {
                    sh 'mvn clean install'
                }

                dir('doctor-service') {
                    sh 'mvn clean install'
                }

                dir('medical-store-service') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    // Make sure the JAR file exists before proceeding with Docker build
                    sh 'ls -l patient-service/target/patient-service-1.0-SNAPSHOT.jar'
                    sh 'ls -l doctor-service/target/doctor-service-1.0-SNAPSHOT.jar'
                    sh 'ls -l medical-store-service/target/medical-store-service-1.0-SNAPSHOT.jar'

                    // Build the Docker image inside the patient-service directory
                    dir('patient-service') {
                        sh 'docker build -t pratik2504/patient-service .'
                    }

                    dir('doctor-service') {
                        sh 'docker build -t pratik2504/doctor-service .'
                    }

                    dir('medical-store-service') {
                        sh 'docker build -t pratik2504/medical-store-service .'
                    }
                }
            }
        }

        stage('Push Docker image to DockerHub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pass', variable: 'dockerhub_pass')]) {
                        sh 'docker login -u pratik2504 -p ${dockerhub_pass}'
                    }

                    sh 'docker push pratik2504/patient-service'
                    sh 'docker push pratik2504/doctor-service'
                    sh 'docker push pratik2504/medical-store-service'
                }
            }
        }
    }
}