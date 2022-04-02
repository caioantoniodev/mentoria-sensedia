package edu.mentorship.profiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class ConfigProperties {

    private String property1;
    private String property2;
    private String property3;
}
