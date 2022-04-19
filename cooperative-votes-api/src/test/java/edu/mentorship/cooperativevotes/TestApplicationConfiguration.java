package edu.mentorship.cooperativevotes;

import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Versions;
import de.flapdoodle.embed.process.distribution.GenericVersion;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@TestConfiguration
public class TestApplicationConfiguration {

    @Configuration
    public static class EmbeddedMongoConfig {

        @Bean(name = "mongoTestVersion")
        public IMongodConfig iMongodConfig() throws IOException {

            return new MongodConfigBuilder()
                    .net(new Net("127.0.0.1", Network.getFreeServerPort(), Network.localhostIsIPv6()))
                    .version(Versions.withFeatures(new GenericVersion("3.5.5")))
                    .build();
        }
    }
}
