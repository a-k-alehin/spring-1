package ru.pslm;

import java.util.List;

@Configuration
// <bean id="SceneBean" class="ru.pslm.Scene"
// scope="singleton"
// factory-method="getInstance"
// >
//   <property name="objects">
//     <list>
//       <ref bean="PointBean"/>
//       <ref bean="CircleBean"/>
//     </list>
//   </property>
// </bean>
public class Scene {

    private List<Shape> objects;

    private Scene() {}

    private static Scene instance = null;

    public static synchronized Scene getInstance() {
        if (instance == null)
            instance = new Scene();
        return instance;
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
