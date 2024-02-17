package ru.pslm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("app.properties")
public class AppConfig {
    
    @Autowired
    private Environment env;
    
    private int getEnv(String key, int defaultValue) {
        return env.getProperty(key, Integer.class, defaultValue);
    }
    
    private String getEnv(String key, String defaultValue) {
        return env.getProperty(key, String.class, defaultValue);
    }
    
    @Bean("coords")
    @Scope("prototype")
    public Coords getCoords(int x, int y) {
        return new Coords(x, y);
    }
    
    @Bean("point")
    @Lazy
    public Point getPoint() {
        Coords coords = getCoords(
                getEnv("point.x", 0),
                getEnv("point.y", 0));
        Point point = new Point(
                getEnv("point.color", "white"),
                coords); 
        return point;
    }
    
    @Bean("circle")
    @Lazy
    public Circle getCircle() {
        Coords coords = getCoords(
                getPoint().getX(),
                getEnv("circle.y", 10));
        Circle circle = new Circle(
                getEnv("circle.color", "green"),
                coords,
                getEnv("circle.radius", 10)); 
        return circle;
    }
    
    @Bean("scene")
    @Lazy
    public Scene getScene() {
        List<Shape> o = new ArrayList<Shape>();
        o.add(getPoint());
        o.add(getCircle());        
        return new Scene(o);
    }

}
