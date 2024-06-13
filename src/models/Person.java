package models;

public abstract class Person {
    private int id;
    private String name;
    private String dayOfBirth;
    private boolean isMale;
    private int phoneNumber;

    public Person(String name, String dayOfBirth, boolean gender, int phoneNumber) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.isMale = gender;
        this.phoneNumber = phoneNumber;
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        this.isMale = male;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return id + "," + name + "," + dayOfBirth + "," + isMale + "," + phoneNumber;
    }
}
