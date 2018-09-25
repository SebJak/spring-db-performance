package com.langpath.neo4j;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 12.10.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Neo4jApplication.class)
@ActiveProfiles(value = "test")
public abstract class AbstractTestClass {
}
