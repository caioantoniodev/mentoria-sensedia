package edu.mentorship.cooperative.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="cooperative-ms.configurations.redis")
public class RedisProperties {
}
