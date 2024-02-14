package ru.pslm;

@Component
@Scope("prototype")
// <bean id="CoordsForPointBean" class="ru.pslm.Coords">
//   <property name="x" value="${point.x}"/>
//   <property name="y" value="${point.y}"/>
// </bean>
// <bean id="CoordsForCircleBean" class="ru.pslm.Coords">
//   <property name="x" value="${circle.x}"/>
//   <property name="y" value="${circle.y}"/>
// </bean>
public class Coords {
    private int x;
    private int y;

    public Coords() {}

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
