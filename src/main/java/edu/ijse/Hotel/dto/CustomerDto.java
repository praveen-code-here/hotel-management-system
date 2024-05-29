package edu.ijse.lovers_leap.dto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class CustomerDto {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private String Gender;
    private String email;
    private String contactNo;
    private String nicNo;

    public CustomerDto(String firstName, String lastName, String address, String country, String gender, String email, String contactNo, String nicNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        Gender = gender;
        this.email = email;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
    }

    public CustomerDto(int customerId, String firstName, String lastName, String address, String country, String gender, String email, String contactNo, String nicNo) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        Gender = gender;
        this.email = email;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
    }

    public CustomerDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }
}
