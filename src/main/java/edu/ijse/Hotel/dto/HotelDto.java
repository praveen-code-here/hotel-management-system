package edu.ijse.lovers_leap.dto;

public class HotelDto {
    private int hotelId;
    private String name;
    private String address;
    private String district;
    private String contactNo;

    public HotelDto() {
    }

    public HotelDto(int hotelId, String name, String address, String district, String contactNo) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.district = district;
        this.contactNo = contactNo;
    }

    public HotelDto(String name, String address, String district, String contactNo) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.contactNo = contactNo;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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
