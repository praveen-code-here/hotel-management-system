package edu.ijse.lovers_leap.entity;

public class RoomCategoryEntity {
    private int catID;
    private String roomTypeName;
    private double costPerNight;
    private String description;

    public RoomCategoryEntity(int catID, String roomTypeName, double costPerNight, String description) {
        this.catID = catID;
        this.roomTypeName = roomTypeName;
        this.costPerNight = costPerNight;
        this.description = description;
    }

    public RoomCategoryEntity(String roomTypeName, double costPerNight, String description) {
        this.roomTypeName = roomTypeName;
        this.costPerNight = costPerNight;
        this.description = description;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
