package ru.pslm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.*;

@ComponentScan(basePackages = {"ru.pslm"})
@PropertySource("app.properties")
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(App.class);

        Scene scene = context.getBean(Scene.class);
        scene.draw();
    }

}
