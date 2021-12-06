pipeline {
    agent {label 'ec2'}

    environment {
        dockerhubcredentials = 'dockerhubcredentials'
    }

    stages {
        stage('Build') {
            steps {
               sh 'mvn clean'
            }
        }

        stage('Unit test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('integration test') {
            steps {
                sh 'mvn integration-test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true package'
            }
        }

        stage('Build and Push Docker image') {
            steps {
                script {
                    dockerImage = docker.build 'miteshanand/nagp-assignment-devops.jar:v1'
                    docker.withRegistry('', dockerhubcredentials) {
                        dockerImage.push("v2")
                    }
                }
            }
        }
    }
}