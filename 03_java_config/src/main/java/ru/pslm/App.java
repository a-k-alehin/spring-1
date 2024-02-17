package ru.pslm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.*;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        Scene scene = context.getBean(Scene.class);
        scene.draw();
    }

}
