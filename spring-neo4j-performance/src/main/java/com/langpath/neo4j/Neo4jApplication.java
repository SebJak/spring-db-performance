package com.langpath.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Sebastian on 2016-03-14.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Neo4jApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Neo4jApplication.class);
    }
}
