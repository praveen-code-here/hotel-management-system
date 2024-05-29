package edu.ijse.lovers_leap.entity;

public class HotelDetailEntity {
    private int hotel_ID;
    private String name;
    private String address;
    private String district;
    private String contactNo;

    public HotelDetailEntity() {
    }

    public HotelDetailEntity(int hotel_ID, String name, String address, String district, String contactNo) {
        this.hotel_ID = hotel_ID;
        this.name = name;
        this.address = address;
        this.district = district;
        this.contactNo = contactNo;
    }

    public HotelDetailEntity(String name, String address, String district, String contactNo) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.contactNo = contactNo;
    }

    public int getHotel_ID() {
        return hotel_ID;
    }

    public void setHotel_ID(int hotel_ID) {
        this.hotel_ID = hotel_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
