package edu.ijse.lovers_leap.dto;

public class RoomCategoryDto {
    private int catId;
    private String roomCatName;
    private double costPerNight;
    private String description;

    public RoomCategoryDto(int catId, String roomCatName, double costPerNight, String description) {
        this.catId = catId;
        this.roomCatName = roomCatName;
        this.costPerNight = costPerNight;
        this.description = description;
    }

    public RoomCategoryDto(String roomCatName, double costPerNight, String description) {
        this.roomCatName = roomCatName;
        this.costPerNight = costPerNight;
        this.description = description;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getRoomCatName() {
        return roomCatName;
    }

    public void setRoomCatName(String roomCatName) {
        this.roomCatName = roomCatName;
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
