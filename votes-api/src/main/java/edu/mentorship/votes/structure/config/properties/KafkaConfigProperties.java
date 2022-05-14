package edu.mentorship.votes.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties(prefix="votes-api.configurations.kafka.producer")
public class KafkaConfigProperties {
    @NotBlank(message="bootstrap server Kafka is required.")
    private String bootstrapServerHost;
    @NotBlank(message="kafka topic is required.")
    private String topic;
}
