package ru.pslm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = {"ru.pslm"})
public class App {

    @Bean
    static Scene scene;

    public static void main(String[] args) {
        scene.draw();
    }

}
