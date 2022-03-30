package edu.mentorship.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigContextBeanCustom {

    @Value("${application.property1}")
    private String property1;

    @Value("${application.property2}")
    private String property2;

    @Value("${application.property3}")
    private String property3;

    @Bean
    @Profile(value="profile1")
    public ContextBeanCustom bean1(@Value("${application.property1}") String property1,
                                   @Value("${application.property2}") String property2,
                                   @Value("${application.property3}") String property3) {


        return new ContextBeanCustomImpl1(property1, property2, property3);
    }

    @Bean
    @Profile(value="profile2")
    public ContextBeanCustom bean2() {
        return new ContextBeanCustomImpl2(property1, property2, property3);
    }
}
