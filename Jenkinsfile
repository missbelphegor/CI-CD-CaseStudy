
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Code downloaded from GitHub'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn -B clean verify'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t ci-cd-demo:1.0.0 .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat 'kubectl config current-context'
                bat 'kubectl get nodes'

                bat '''
                    if exist "k8s\\deployment.yaml" (
                        kubectl apply -f k8s
                    ) else (
                        kubectl apply -f deployment.yaml
                        if errorlevel 1 exit /b 1
                        kubectl apply -f service.yaml
                        if errorlevel 1 exit /b 1
                    )
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                bat 'kubectl rollout status deployment/ci-cd-demo --timeout=180s'
                bat 'kubectl get pods'
                bat 'kubectl get services'
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the Console Output.'
        }
    }
}
