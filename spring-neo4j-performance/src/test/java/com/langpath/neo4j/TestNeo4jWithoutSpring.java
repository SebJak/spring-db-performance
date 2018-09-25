package com.langpath.neo4j;

import org.junit.Test;
import org.neo4j.driver.v1.*;
import org.slf4j.*;
import org.slf4j.Logger;

/**
 * Created by seba on 28.09.16.
 */
public class TestNeo4jWithoutSpring {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TestNeo4jWithoutSpring.class);

    @Test
    public void testSaveTime() {
        logger.info("Test save time");
        long start = System.currentTimeMillis();
        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "welcome1" ) );
        Session session = driver.session();
        for(int i =0; i<100; i++)
            session.run( "CREATE (a:Person {id:"+i+",name:'Arthur', title:'King'})" );
        session.close();
        driver.close();

        long end = System.currentTimeMillis() - start;
        logger.info("Save time is: " + end);

    }

    @Test
    public void testSaveWithTransactionTime() {
        logger.info("Test save time");
        long start = System.currentTimeMillis();
        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "welcome1" ) );
        Session session = driver.session();

        try(Transaction tx = session.beginTransaction()) {
            for (int i = 0; i < 100; i++)
                tx.run("CREATE (a:Person {id:" + i + ",name:'Arthur', title:'King'})");

            tx.success();
        }
        session.close();
        driver.close();

        long end = System.currentTimeMillis() - start;
        logger.info("Save time is: " + end);
    }
}
