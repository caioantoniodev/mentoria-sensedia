package edu.mentorship.cooperative;

import edu.mentorship.cooperative.structure.config.properties.KafkaProperties;
import edu.mentorship.cooperative.structure.config.properties.RedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {KafkaProperties.class, RedisProperties.class})
public class CooperativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperativeApplication.class, args);
	}

}
