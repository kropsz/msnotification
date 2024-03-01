package com.compassuol.sp.challenge.msnotification.database;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;

@SpringBootTest
public class MongoDbConnectionTest {

    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void mongoDbConnectionTest() {
        assertThat(mongoClient).isNotNull();
        assertThat(mongoTemplate).isNotNull();
        assertThat(mongoTemplate.getDb().getName()).isEqualTo("db_address");
    }
}
