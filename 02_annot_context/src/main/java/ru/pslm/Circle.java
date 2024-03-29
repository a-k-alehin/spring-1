package ru.pslm;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class Circle extends Shape {

    private Coords center;

    //@Value("${circle.radius}")
    private int radius;

    public Circle(
            @Value("${circle.color}") String color, 
            Coords center,  
            @Value("#{point.x}") int radius) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public Coords getCenter() {
        return center;
    }
    public void setCenter(Coords coords) {
        this.center = coords;
    }
    public int getX() {
        return getCenter().getX();
    }
    @Value("${circle.x}")
    public void setX(int y) {
        getCenter().setX(y);
    }
    public int getY() {
        return getCenter().getY();
    }
    @Value("${circle.y}")
    public void setY(int y) {
        getCenter().setY(y);
    }
    public int getRadius() {
        return radius;
    }
    //@Value("${circle.radius}")
    public void setRadius(int radius) {
        this.radius = radius;
    }

    //@Override
    public void draw() {
        System.out.printf("Circle. center: (%d, %d); Color: %s; Radius: %d\n",  getX(), getY(), getColor(), getRadius());
    }
}
