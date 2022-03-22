package edu.mentorship;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean(name = "bird")
    public Animal bird() {
        return new Bird();
    }

    @Bean(name = "cat")
    public Animal cat() {
        return new Cat();
    }

    @Bean(name = "dog")
    public Animal dog() {
        return new Dog();
    }
}
