package edu.mentorship;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final int ANIMAL = 3;
    private static final String O_ANIMAL_FAZ = "O animal faz ";

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BeansConfig.class);

        var beanDefinitionNames = context.getBeanDefinitionNames();

        var environment = context.getEnvironment();

        switch (ANIMAL) {
            case 1:
                bird(context);
                break;
            case 2:
                cat(context);
                break;
            case 3:
                dog(context);
                break;
            default:
                System.out.println("Animal not found!");
        }
    }

    private static void bird(AnnotationConfigApplicationContext context) {
        Animal bird = context.getBean("bird", Animal.class);

        System.out.print(O_ANIMAL_FAZ);

        bird.shout();
    }

    private static void cat(AnnotationConfigApplicationContext context) {
        Animal cat = context.getBean("cat", Animal.class);

        System.out.print(O_ANIMAL_FAZ);

        cat.shout();
    }

    private static void dog(AnnotationConfigApplicationContext context) {
        Animal dog = context.getBean("dog", Animal.class);

        System.out.print(O_ANIMAL_FAZ);

        dog.shout();
    }
}
