package university;

public class CrossingPoint extends Node{

    private String about;

    public CrossingPoint(String name, String about, int x, int y, int floor, boolean classroom) {
        super(name,x, y, floor, classroom);
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
