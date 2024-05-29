package edu.ijse.lovers_leap.dto;

public class ReceptionistsDto {
    private String firstName;
    private String lastName;
    private int age;
    private String contactNo;
    private String position;
    private int hotelId;
    private String password;

    private int receptionistId;

    public ReceptionistsDto(String firstName,
                            String lastName,
                            int age,
                            String contactNo,
                            String position,
                            int hotelId,
                            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contactNo = contactNo;
        this.position = position;
        this.hotelId = hotelId;
        this.password = password;
    }

    public ReceptionistsDto(int receptionistId,
                            String firstName,
                            String lastName,
                            int age,
                            String contactNo,
                            String position,
                            int hotelId,
                            String password) {
        this.receptionistId=receptionistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contactNo = contactNo;
        this.position = position;
        this.hotelId = hotelId;
        this.password = password;

    }

    public ReceptionistsDto() {
    }

    public int getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(int receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
