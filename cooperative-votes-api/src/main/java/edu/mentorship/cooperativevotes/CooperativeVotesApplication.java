package edu.mentorship.cooperativevotes;

import edu.mentorship.cooperativevotes.structure.config.properties.KafkaProperties;
import edu.mentorship.cooperativevotes.structure.config.properties.RedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {KafkaProperties.class, RedisProperties.class})
public class CooperativeVotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperativeVotesApplication.class, args);
	}

}
