package edu.ijse.lovers_leap.entity;

public class PaymentDetailEntity {
    private int Pay_Id;
    private int Res_ID;
    private double amount;

    public PaymentDetailEntity(int pay_Id, int res_ID, double amount) {
        Pay_Id = pay_Id;
        Res_ID = res_ID;
        this.amount = amount;
    }

    public int getPay_Id() {
        return Pay_Id;
    }

    public void setPay_Id(int pay_Id) {
        Pay_Id = pay_Id;
    }

    public int getRes_ID() {
        return Res_ID;
    }

    public void setRes_ID(int res_ID) {
        Res_ID = res_ID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
