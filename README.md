\# End-to-End CI/CD Pipeline for a Web Application



\## 1. Project Overview



This project demonstrates a CI/CD pipeline for a Spring Boot web application using Git, GitHub, Maven, Jenkins, Docker, and Kubernetes.



\## 2. Objectives



\- Manage source code using Git and GitHub.

\- Build the application using Maven.

\- Automate build stages using Jenkins.

\- Package the application into a Docker image.

\- Deploy and run the application using Kubernetes.

\- Verify application availability through web endpoints.



\## 3. Technologies Used



\- Java and Spring Boot

\- Maven

\- Git and GitHub

\- Jenkins

\- Docker

\- Kubernetes and Minikube

\- Windows PowerShell



\## 4. Application Endpoints



Home page: `http://localhost:8081/`



Health check: `http://localhost:8081/health`



These local URLs require Kubernetes port forwarding to be running.



\## 5. Implementation



1\. Created a Spring Boot web application.

2\. Managed the project using Git and GitHub.

3\. Built the application using Maven.

4\. Configured a Jenkins pipeline for checkout, build, test command, and Docker image creation.

5\. Created a Docker image for the application.

6\. Created Kubernetes Deployment and Service manifests.

7\. Deployed the application to Minikube and verified the running pod and application endpoints.



\## 6. Results



The Kubernetes node was verified as Ready, the application deployment showed one available replica, and the application pod was Running. The home page and health-check endpoint were accessible using port forwarding.



The Jenkins pipeline successfully built the application and Docker image. The test stage ran, but automated test coverage still needs to be added if no test cases are present.



\## 7. Future Enhancements



\- Add application unit tests.

\- Automate Kubernetes deployment through Jenkins.

\- Configure a container registry for image publishing.

\- Add monitoring and production deployment configuration.



\## 8. Conclusion



The project demonstrates the main stages of a CI/CD workflow, from source-code management and application building to containerization and Kubernetes deployment. Further automation of the Kubernetes deployment stage will improve the end-to-end pipeline.

