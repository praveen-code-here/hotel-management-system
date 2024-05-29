package edu.ijse.lovers_leap.dto;

public class RoomManagementDto {
    private String roomId;
    private int catId;
    private int hotelId;
    private int noOfBeds;
    private String status;

    public RoomManagementDto(String roomId, int catId, int hotelId, int noOfBeds, String status) {
        this.roomId = roomId;
        this.catId = catId;
        this.hotelId = hotelId;
        this.noOfBeds = noOfBeds;
        this.status = status;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
