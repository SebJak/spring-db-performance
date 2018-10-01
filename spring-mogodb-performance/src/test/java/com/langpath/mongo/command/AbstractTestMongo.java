package com.langpath.mongo.command;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 12.10.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(MongoApplication.class)
@ActiveProfiles(value = "test")
public abstract class AbstractTestMongo {
//    private static MongodExecutable mongodExecutable;

    @BeforeClass
    public static void setUp() {
//        try {
//            MongodStarter starter = MongodStarter.getDefaultInstance();
//            String bindIp = "localhost";
//            int port = 27017;
//            IMongodConfig mongodConfig = new MongodConfigBuilder()
//                    .version(Version.Main.PRODUCTION)
//                    .net(new Net(bindIp, port, Network.localhostIsIPv6()))
//                    .build();
//
//            mongodExecutable = starter.prepare(mongodConfig);
//            MongodProcess mongod = mongodExecutable.start();
//            mongod.stop();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @AfterClass
    public static void tearDown(){
//        mongodExecutable.stop();
    }

}
