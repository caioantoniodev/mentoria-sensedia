package edu.mentorship.cooperative.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@ConfigurationProperties(prefix="cooperative-api.configurations.kafka.producer")
public class KafkaProperties {
    @NotBlank(message="bootstrapServerHost is required.")
    private String bootstrapServerHost;
    @NotBlank(message="topic is required.")
    private String topic;
}
