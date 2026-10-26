pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Starting CI/CD Case Study'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t ci-cd-demo:1.0.0 .'
            }
        }

        stage('Verify Docker Image') {
            steps {
                bat 'docker images ci-cd-demo'
            }
        }
    }

    post {
        success {
            echo 'Build, tests, and Docker image creation completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the Console Output for the failing stage.'
        }
    }
}