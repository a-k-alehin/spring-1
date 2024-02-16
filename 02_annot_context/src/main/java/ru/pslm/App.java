package ru.pslm;

import org.springframework.context.annotation.*;

//@ComponentScan(basePackages = {"ru.pslm"})
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("ru.pslm");

        Scene scene = context.getBean(Scene.class);
        scene.draw();
    }

}
