package com.langpath.mongo.aggregation;

import com.langpath.mongo.MongoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
//@DataMongoTest
public class DashboardServiceTest {

    @Autowired DashboardService dashboardService;
    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void setUp() {
        List<Item> items = new ArrayList<>();

        items.add(Item.builder()
                .system("TEST_01")
                .time("2018-09")
                .build());
        items.add(Item.builder()
                .system("TEST_02")
                .time("2018-09")
                .build());
        items.add(Item.builder()
                .system("TEST_01")
                .time("2018-10")
                .build());
        items.add(Item.builder()
                .system("TEST_02")
                .time("2018-11")
                .build());

        mongoTemplate.insertAll(items);
    }

    @Test
    public void shouldGenerateDashboard() {
        dashboardService.getDashboardData();
    }
}