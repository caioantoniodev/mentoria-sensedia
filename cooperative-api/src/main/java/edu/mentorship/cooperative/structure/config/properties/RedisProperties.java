package edu.mentorship.cooperative.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@ConfigurationProperties(prefix="cooperative-api.configurations.redis")
public class RedisProperties {
    @NotBlank(message="host is required.")
    private String host;
    @NotBlank(message="port is required.")
    private String port;
}
