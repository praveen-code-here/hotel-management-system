package edu.ijse.lovers_leap.entity;

public class RoomManagementEntity {
    private String room_ID;
    private int Cat_ID;
    private int hotel_Id;
    private int no_Of_Beds;
    private String status;

    public RoomManagementEntity(String room_ID, int cat_ID, int hotel_Id, int no_Of_Beds, String status) {
        this.room_ID = room_ID;
        Cat_ID = cat_ID;
        this.hotel_Id = hotel_Id;
        this.no_Of_Beds = no_Of_Beds;
        this.status = status;
    }

    public String getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(String room_ID) {
        this.room_ID = room_ID;
    }

    public int getCat_ID() {
        return Cat_ID;
    }

    public void setCat_ID(int cat_ID) {
        Cat_ID = cat_ID;
    }

    public int getHotel_Id() {
        return hotel_Id;
    }

    public void setHotel_Id(int hotel_Id) {
        this.hotel_Id = hotel_Id;
    }

    public int getNo_Of_Beds() {
        return no_Of_Beds;
    }

    public void setNo_Of_Beds(int no_Of_Beds) {
        this.no_Of_Beds = no_Of_Beds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
