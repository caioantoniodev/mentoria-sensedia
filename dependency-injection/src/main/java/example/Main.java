package example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private final BuildAnimal buildAnimal;

    public Main(BuildAnimal buildAnimal) {
        this.buildAnimal = buildAnimal;
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BeansConfig.class);

    }
}
