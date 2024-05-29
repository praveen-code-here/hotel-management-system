package edu.ijse.lovers_leap.dto;

public class ReservationSummaryDto {
    private int reservationId;
    private String customerName;
    private String contactNo;
    private String roomNo;
    private String packageName;
    private double roomCost;
    private int stayedDated;

    public ReservationSummaryDto(int reservationId, String customerName, String contactNo, String roomNo, String packageName, double roomCost, int stayedDated) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.roomNo = roomNo;
        this.packageName = packageName;
        this.roomCost = roomCost;
        this.stayedDated = stayedDated;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }

    public int getStayedDated() {
        return stayedDated;
    }

    public void setStayedDated(int stayedDated) {
        this.stayedDated = stayedDated;
    }
}
