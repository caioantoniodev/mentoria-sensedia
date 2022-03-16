package example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BeansConfig {

    @Bean(name = "bird")
    public Animal bird() {
        return new Bird();
    }

    @Bean(name = "Cat")
    public Animal cat() {
        return new Cat();
    }

    @Bean(name = "dog")
    public Animal dog() {
        return new Dog();
    }
}
