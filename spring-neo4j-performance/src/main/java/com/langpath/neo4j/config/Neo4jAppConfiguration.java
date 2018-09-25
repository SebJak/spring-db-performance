package com.langpath.neo4j.config;

import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * Created by Sebastian on 2016-04-10.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.langpath.neo4j.repositories")
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@ComponentScan(basePackages = "com.langpath.neo4j")
public class Neo4jAppConfiguration extends Neo4jConfiguration {

    @Resource
    private Environment env;

    private static final Logger logger = LoggerFactory.getLogger(Neo4jAppConfiguration.class);

    @Bean
    public Neo4jServer neo4jServer() {
        logger.info("Initialize neo4j Server.");
        final String url = env.getRequiredProperty("neo4j.server.url");
        final String user = env.getRequiredProperty("neo4j.server.user");
        final String pass = env.getRequiredProperty("neo4j.server.pass");
        Neo4jServer server = new RemoteServer(url,user,pass);
        return server;
    }


    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        logger.info("Session factory.");
        return new SessionFactory("com.langpath.neo4j");
    }
}
