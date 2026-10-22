pipeline {
    agent any

    environment {
        IMAGE_NAME = 'ci-cd-demo:1.0.0'
        KUBE_API = 'https://192.168.49.2:8443'
        KUBE_CA = '/var/jenkins_home/.kube/minikube-certs/ca.crt'
        KUBE_CERT = '/var/jenkins_home/.kube/minikube-certs/client.crt'
        KUBE_KEY = '/var/jenkins_home/.kube/minikube-certs/client.key'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ci-cd-demo:1.0.0 .'
            }
        }

        stage('Import Image into Minikube') {
            steps {
                sh '''
                    set -e
                    docker save "$IMAGE_NAME" | docker exec -i minikube ctr --namespace k8s.io images import -
                    docker exec minikube ctr --namespace k8s.io images list | grep 'ci-cd-demo:1.0.0'
                '''
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                    set -e
                    kubectl \
                      --server="$KUBE_API" \
                      --certificate-authority="$KUBE_CA" \
                      --client-certificate="$KUBE_CERT" \
                      --client-key="$KUBE_KEY" \
                      apply -f k8s/deployment.yaml -f k8s/service.yaml
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                sh '''
                    set -e

                    kubectl \
                      --server="$KUBE_API" \
                      --certificate-authority="$KUBE_CA" \
                      --client-certificate="$KUBE_CERT" \
                      --client-key="$KUBE_KEY" \
                      rollout restart deployment/ci-cd-demo

                    kubectl \
                      --server="$KUBE_API" \
                      --certificate-authority="$KUBE_CA" \
                      --client-certificate="$KUBE_CERT" \
                      --client-key="$KUBE_KEY" \
                      rollout status deployment/ci-cd-demo --timeout=120s

                    kubectl \
                      --server="$KUBE_API" \
                      --certificate-authority="$KUBE_CA" \
                      --client-certificate="$KUBE_CERT" \
                      --client-key="$KUBE_KEY" \
                      get pods,services
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD pipeline completed: build, Docker image import, and Kubernetes deployment succeeded.'
        }
        failure {
            echo 'Pipeline failed. Check the Console Output for the failing stage.'
        }
    }
}



