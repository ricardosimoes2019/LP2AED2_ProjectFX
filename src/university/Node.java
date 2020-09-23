package university;

import java.io.Serializable;

public class Node implements Serializable {

    public String name;
    public int x;
    public int y;
    public Integer floor;

    public Node(String name, int x, int y, Integer floor, boolean classroom) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.floor = floor;
        this.classroom = classroom;
    }

    private boolean classroom;

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

    public boolean isClassroom() {
        return classroom;
    }

    public void setClassroom(boolean classroom) {
        this.classroom = classroom;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
