package ru.pslm;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class Point extends Shape {

    private Coords coords;

    public Point(@Value("${point.color}") String color, Coords coords) {
        super(color);
        this.coords = coords;
    }

    public Coords getCoords() {
        return coords;
    }
    public void setCoords(Coords coords) {
        this.coords = coords;
    }
    public int getX() {
        return getCoords().getX();
    }
    @Value("#{T(java.lang.Math).random()*100}")
    public void setX(int y) {
        getCoords().setX(y);
    }
    public int getY() {
        return getCoords().getY();
    }
    @Value("${point.y}")
    public void setY(int y) {
        getCoords().setY(y);
    }

    //@Override
    public void draw() {
        System.out.printf("Point (%d, %d) Color: %s\n",  getX(), getY(), getColor());

    }

}
