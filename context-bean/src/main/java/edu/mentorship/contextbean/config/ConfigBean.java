package edu.mentorship.contextbean.config;

import edu.mentorship.contextbean.interfaces.ObjectType;
import edu.mentorship.contextbean.domain.Object1;
import edu.mentorship.contextbean.domain.Object2;
import edu.mentorship.contextbean.domain.Object3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    @Conditional(value = Object3.class)
    public ObjectType object1() {
        return new Object1();
    }

    @Bean
    public ObjectType object2() {
        return new Object2();
    }
}
