package ru.pslm;

import org.springframework.beans.factory.annotation.Value;

public abstract class Shape {

    private String color;

    public Shape() {};

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Value("default")
    public void setColor(String color) {
        this.color = color;
    }

    public abstract void draw();
}
