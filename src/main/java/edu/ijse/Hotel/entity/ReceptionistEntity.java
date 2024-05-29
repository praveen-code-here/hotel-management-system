package edu.ijse.lovers_leap.entity;

public class ReceptionistEntity {
    private String first_Name;
    private String last_Name;
    private String position;
    private int hotel_ID;
    private String password;
    private int age;

    private String contact_No;
    private int Rep_Id;

    public ReceptionistEntity() {
    }

    public String getContact_No() {
        return contact_No;
    }

    public void setContact_No(String contact_No) {
        this.contact_No = contact_No;
    }

    public ReceptionistEntity(String first_Name,
                              String last_Name,
                              String position,
                              int hotel_ID,
                              String password,
                              int age,
                              String contact_No) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.position = position;
        this.hotel_ID = hotel_ID;
        this.password = password;
        this.age = age;
        this.contact_No = contact_No;
    }
    public ReceptionistEntity(int Rep_Id,
                              String first_Name,
                              String last_Name,
                              String position,
                              int hotel_ID,
                              String password,
                              int age,
                              String contact_No) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.position = position;
        this.hotel_ID = hotel_ID;
        this.password = password;
        this.age = age;
        this.contact_No = contact_No;
        this.Rep_Id=Rep_Id;
    }

    public int getRep_Id() {
        return Rep_Id;
    }

    public void setRep_Id(int rep_Id) {
        Rep_Id = rep_Id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHotel_ID() {
        return hotel_ID;
    }

    public void setHotel_ID(int hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReceptionistEntity{" +
                "first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", position='" + position + '\'' +
                ", hotel_ID=" + hotel_ID +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
