package models;

public class Student extends Person {
    int classId;
    public Student(int id, String name, String dayOfBirth, boolean gender, int phoneNumber) {
        super(name, dayOfBirth, gender, phoneNumber);
    }

    public Student(String name, String dayOfBirth, boolean gender, int phoneNumber, int classId) {
        super(name, dayOfBirth, gender, phoneNumber);
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String toString() {
        return super.toString()+","+classId;
    }
}
