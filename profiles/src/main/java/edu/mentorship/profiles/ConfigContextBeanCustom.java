package edu.mentorship.profiles;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
public class ConfigContextBeanCustom {

    @Autowired
    private ConfigProperties configProperties;

    @Bean
    @Profile(value = "profile1")
    public ContextBeanCustom bean1() {

        return new ContextBeanCustomImpl1(configProperties.getProperty1(),
                configProperties.getProperty2(),
                configProperties.getProperty3());
    }

    @Bean
    @Profile(value = "profile2")
    public ContextBeanCustom bean2() {
        return new ContextBeanCustomImpl2(configProperties.getProperty1(),
                configProperties.getProperty2(),
                configProperties.getProperty3());
    }
}
