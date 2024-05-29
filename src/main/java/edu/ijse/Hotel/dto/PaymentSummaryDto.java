package edu.ijse.lovers_leap.dto;

import java.util.ArrayList;

public class PaymentSummaryDto {
    private int paymentID;
    private String Customer;
    private double totalAmount;
    private String paymentMethod;
    private String paidDate;

    private String paidTime;

    private ArrayList<PaymentCartDto> pDtos;

    public PaymentSummaryDto(int paymentID, String customer, double totalAmount, String paymentMethod, String paidDate, String paidTime, ArrayList<PaymentCartDto> pDtos) {
        this.paymentID = paymentID;
        Customer = customer;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paidDate = paidDate;
        this.paidTime = paidTime;
        this.pDtos = pDtos;
    }

    public PaymentSummaryDto(String customer, String paymentMethod, String paidDate, String paidTime, ArrayList<PaymentCartDto> pDtos) {
        Customer = customer;
        this.paymentMethod = paymentMethod;
        this.paidDate = paidDate;
        this.paidTime = paidTime;
        this.pDtos = pDtos;
    }

    public PaymentSummaryDto(String customer, double totalAmount, String paymentMethod, String paidDate, String paidTime, ArrayList<PaymentCartDto> pDtos) {
        Customer = customer;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paidDate = paidDate;
        this.paidTime = paidTime;
        this.pDtos = pDtos;
    }

    public PaymentSummaryDto(int paymentID, String customer, double totalAmount, String paymentMethod, String paidDate, String paidTime) {
        this.paymentID = paymentID;
        Customer = customer;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paidDate = paidDate;
        this.paidTime = paidTime;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public ArrayList<PaymentCartDto> getpDtos() {
        return pDtos;
    }

    public void setpDtos(ArrayList<PaymentCartDto> pDtos) {
        this.pDtos = pDtos;
    }
}
