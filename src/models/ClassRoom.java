package models;

public class ClassRoom {
    private int id;
    private String name;
    private int teacherId;

    public ClassRoom(int id, String name, int techerId) {
        this.id = id;
        this.name = name;
        this.teacherId = techerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
