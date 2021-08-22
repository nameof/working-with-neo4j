package com.nameof.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class Neo4jApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Neo4jApplication.class);
        app.run(args);
    }
}
