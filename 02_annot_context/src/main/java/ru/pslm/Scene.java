package ru.pslm;

import java.util.List;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;


@Component
public class Scene {

    private List<Shape> objects;

    // сам ищет все бины типа Shape
    // можно даже не указывать @Autowired, если нет конструктора без параметров
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
