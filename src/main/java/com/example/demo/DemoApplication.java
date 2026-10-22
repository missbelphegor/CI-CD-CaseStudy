
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello! CI/CD Pipeline is Working Successfully!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is Healthy";
    }

    // Add the /about endpoint here
    @GetMapping("/about")
    public String about() {
        return "This web application demonstrates Git, Maven, Jenkins, Docker and Kubernetes.";
    }
}
