package ru.pslm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("appContext.xml");
        Scene scene = context.getBean("SceneBean", Scene.class);
        scene.draw();
    }

}
