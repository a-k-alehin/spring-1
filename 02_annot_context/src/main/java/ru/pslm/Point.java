package ru.pslm;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
@Scope("prototype")
// <bean id="PointBean" class="ru.pslm.Point" scope="singleton">
//   <property name="color"  value="${point.color}"/>
//   <property name="coords" ref="CoordsForPointBean"/>
// </bean>
public class Point extends Shape {

    @Bean
    private Coords coords;

    public Point() {};

    public Point(String color, Coords coords) {
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
    public void setX(int y) {
        getCoords().setX(y);
    }
    public int getY() {
        return getCoords().getY();
    }
    public void setY(int y) {
        getCoords().setY(y);
    }

    //@Override
    public void draw() {
        System.out.printf("Point (%d, %d) Color: %s\n",  getX(), getY(), getColor());

    }

}
