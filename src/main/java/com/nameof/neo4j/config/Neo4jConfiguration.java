package com.nameof.neo4j.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.nameof.neo4j.neo4j", transactionManagerRef = "neo4jTransactionManager")
public class Neo4jConfiguration {
    @Value("${spring.data.neo4j.uri}")
    private String uri;
    @Value("${spring.data.neo4j.username}")
    private String username;
    @Value("${spring.data.neo4j.password}")
    private String password;


    @Bean
    public org.neo4j.ogm.config.Configuration configuration(){
        return new org.neo4j.ogm.config.Configuration.Builder().uri(uri)
                .credentials(username, password).build();
    }

    @Bean
    public SessionFactory sessionFactory(){
        return new SessionFactory(configuration(), "com.nameof.neo4j.neo4j");
    }

    @Bean
    public Neo4jTransactionManager neo4jTransactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }

}
