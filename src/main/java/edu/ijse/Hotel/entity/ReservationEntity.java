package edu.ijse.lovers_leap.entity;

public class ReservationEntity {
    private int reservationId;
    private int customerId;
    private String inDate;
    private String outDate;
    private String bookingStatus;
    private String roomNo;
    private int noOfGuests;
    private String bookedDate;
    private String bookedTime;

    public ReservationEntity(int customerId, String inDate, String outDate, String bookingStatus, String roomNo, int noOfGuests,String bookedDate,String bookedTime) {
        this.customerId = customerId;
        this.inDate = inDate;
        this.outDate = outDate;
        this.bookingStatus = bookingStatus;
        this.roomNo = roomNo;
        this.noOfGuests = noOfGuests;
        this.bookedDate=bookedDate;
        this.bookedTime=bookedTime;
    }

    public ReservationEntity(int reservationId, int customerId, String inDate, String outDate, String bookingStatus, String roomNo, int noOfGuests,String bookedDate,String bookedTime) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.inDate = inDate;
        this.outDate = outDate;
        this.bookingStatus = bookingStatus;
        this.roomNo = roomNo;
        this.noOfGuests = noOfGuests;
        this.bookedDate=bookedDate;
        this.bookedTime=bookedTime;
    }


    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public String getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(String bookedTime) {
        this.bookedTime = bookedTime;
    }

    public ReservationEntity() {

    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }
}
