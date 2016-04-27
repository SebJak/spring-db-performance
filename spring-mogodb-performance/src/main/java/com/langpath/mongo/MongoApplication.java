package com.langpath.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Sebastian on 2016-04-27.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MongoApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(MongoApplication.class);
    }
}
