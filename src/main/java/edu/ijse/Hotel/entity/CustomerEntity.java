package edu.ijse.lovers_leap.entity;

public class CustomerEntity {
    private int Cus_Id;
    private String First_Name;
    private String Last_Name;
    private String Address;
    private String Country;
    private String Gender;
    private String  Email;
    private String contact_no;
    private String NIC_no;

    public CustomerEntity() {
    }

    public CustomerEntity(String first_Name, String last_Name, String address, String country, String gender, String email, String contact_no, String NIC_no) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Address = address;
        Country = country;
        Gender = gender;
        Email = email;
        this.contact_no = contact_no;
        this.NIC_no = NIC_no;
    }

    public CustomerEntity(int cus_Id, String first_Name, String last_Name, String address, String country, String gender, String email, String contact_no, String NIC_no) {
        Cus_Id = cus_Id;
        First_Name = first_Name;
        Last_Name = last_Name;
        Address = address;
        Country = country;
        Gender = gender;
        Email = email;
        this.contact_no = contact_no;
        this.NIC_no = NIC_no;
    }

    public int getCus_Id() {
        return Cus_Id;
    }

    public void setCus_Id(int cus_Id) {
        Cus_Id = cus_Id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getNIC_no() {
        return NIC_no;
    }

    public void setNIC_no(String NIC_no) {
        this.NIC_no = NIC_no;
    }
}
