package edu.mentorship.votes;

import edu.mentorship.votes.structure.config.properties.KafkaConfigProperties;
import edu.mentorship.votes.structure.config.properties.MongoConfigProperties;
import edu.mentorship.votes.structure.config.properties.RedisConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
        KafkaConfigProperties.class,
        RedisConfigProperties.class,
        MongoConfigProperties.class
})
public class VotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotesApplication.class, args);
    }

}
