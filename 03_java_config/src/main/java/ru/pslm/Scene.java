package ru.pslm;

import java.util.List;

public class Scene {

    private List<Shape> objects;

    public Scene(List<Shape> objects) {
        super();
        this.objects = objects;
    }

    public List<Shape> getObjects() {
        return objects;
    }

    public void setObjects(List<Shape> objects) {
        this.objects = objects;
    }

    public void draw() {
        for(Shape s : getObjects())
            s.draw();

    }
}
