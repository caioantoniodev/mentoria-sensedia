package edu.mentorship.cooperativevotes.structure.config.bean;

import edu.mentorship.cooperativevotes.structure.config.properties.MongoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@RequiredArgsConstructor
public class MongoTransactionalBean extends AbstractMongoClientConfiguration {

    private final MongoProperties mongoProperties;

    @Bean(name = "MONGO_TRANSACTION_MANAGER")
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected String getDatabaseName() {
        return mongoProperties.getDatabase();
    }
}
