package edu.ijse.lovers_leap.entity;

public class PaymentSummaryEntity {
    private int Pay_Id;
    private double Total_Amount;
    private String Cus_Name;
    private String Payment_Method;
    private String payment_Date;
    private String Payment_Time;

    public PaymentSummaryEntity(int pay_Id, double total_Amount, String cus_Name, String payment_Method, String payment_Date, String payment_Time) {
        Pay_Id = pay_Id;
        Total_Amount = total_Amount;
        Cus_Name = cus_Name;
        Payment_Method = payment_Method;
        this.payment_Date = payment_Date;
        Payment_Time = payment_Time;
    }

    public PaymentSummaryEntity(double total_Amount, String cus_Name, String payment_Method, String payment_Date, String payment_Time) {
        Total_Amount = total_Amount;
        Cus_Name = cus_Name;
        Payment_Method = payment_Method;
        this.payment_Date = payment_Date;
        Payment_Time = payment_Time;
    }

    public int getPay_Id() {
        return Pay_Id;
    }

    public void setPay_Id(int pay_Id) {
        Pay_Id = pay_Id;
    }

    public double getTotal_Amount() {
        return Total_Amount;
    }

    public void setTotal_Amount(double total_Amount) {
        Total_Amount = total_Amount;
    }

    public String getCus_Name() {
        return Cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        Cus_Name = cus_Name;
    }

    public String getPayment_Method() {
        return Payment_Method;
    }

    public void setPayment_Method(String payment_Method) {
        Payment_Method = payment_Method;
    }

    public String getPayment_Date() {
        return payment_Date;
    }

    public void setPayment_Date(String payment_Date) {
        this.payment_Date = payment_Date;
    }

    public String getPayment_Time() {
        return Payment_Time;
    }

    public void setPayment_Time(String payment_Time) {
        Payment_Time = payment_Time;
    }
}
