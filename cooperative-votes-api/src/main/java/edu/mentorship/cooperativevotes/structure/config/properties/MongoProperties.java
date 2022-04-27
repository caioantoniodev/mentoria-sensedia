package edu.mentorship.cooperativevotes.structure.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix="cooperative-votes-api.configurations.datasource")
@Validated
@Data
public class MongoProperties {

    private Integer port = 27017;

    private String database = "votes-db";

    @NotBlank
    private String host;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String authenticationDatabase;
}
