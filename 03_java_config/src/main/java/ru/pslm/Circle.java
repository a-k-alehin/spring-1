package ru.pslm;

public class Circle extends Shape {

    private Coords center;

    private int radius;

    public Circle(
            String color, 
            Coords center,  
            int radius) {
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
    public void setX(int y) {
        getCenter().setX(y);
    }
    public int getY() {
        return getCenter().getY();
    }
    public void setY(int y) {
        getCenter().setY(y);
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    //@Override
    public void draw() {
        System.out.printf("Circle. center: (%d, %d); Color: %s; Radius: %d\n",  getX(), getY(), getColor(), getRadius());
    }
}
