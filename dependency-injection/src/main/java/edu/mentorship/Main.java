package edu.mentorship;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final int ANIMAL = 1;

    private final BuildAnimal buildAnimal;

    public Main(BuildAnimal buildAnimal) {
        this.buildAnimal = buildAnimal;
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BeansConfig.class);

        var beanDefinitionNames = context.getBeanDefinitionNames();

//        switch (ANIMAL) {
//            case 1:;break;
//            case 2:;break;
//            case 3:;break;
//        }
    }
}
