package com.langpath.mongo.commands.word;

import com.langpath.mongo.MongoApplication;
import com.mongodb.DB;
import com.mongodb.client.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.runtime.Mongod;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by root on 12.10.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MongoApplication.class)
@ActiveProfiles(value = "test")
public abstract class AbstractTestMongo {
    private static MongodExecutable mongodExecutable;

    @BeforeClass
    public static void setUp() {
        try {
            MongodStarter starter = MongodStarter.getDefaultInstance();
            String bindIp = "localhost";
            int port = 27017;
            IMongodConfig mongodConfig = new MongodConfigBuilder()
                    .version(Version.Main.PRODUCTION)
                    .net(new Net(bindIp, port, Network.localhostIsIPv6()))
                    .build();

            mongodExecutable = starter.prepare(mongodConfig);
            MongodProcess mongod = mongodExecutable.start();
            mongod.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown(){
        mongodExecutable.stop();
    }

}
