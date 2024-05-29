package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.PaymentSummaryDao;
import edu.ijse.lovers_leap.entity.PaymentSummaryEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentSummaryDaoImpl implements PaymentSummaryDao {
    @Override
    public boolean add(PaymentSummaryEntity ety) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO payment_summary (Total_Amount,Cus_Name,Payment_Method,payment_Date,Payment_Time) VALUES(?,?,?,?,?)",ety.getTotal_Amount(),ety.getCus_Name(),ety.getPayment_Method(),ety.getPayment_Date(),ety.getPayment_Time());
    }

    @Override
    public PaymentSummaryEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public PaymentSummaryEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<PaymentSummaryEntity> getAll() throws Exception {
        ResultSet r=CrudUtil.executeQuery("SELECT * FROM payment_summary");
        ArrayList<PaymentSummaryEntity> ety=new ArrayList<>();
        while (r.next()){
            ety.add(new PaymentSummaryEntity(r.getInt("Pay_Id"),r.getDouble("Total_Amount"),r.getString("Cus_Name"),r.getString("Payment_Method"),r.getString("payment_Date"),r.getString("Payment_Time")));
        }
        return ety;
    }

    @Override
    public boolean update(PaymentSummaryEntity paymentSummaryEntity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }

    @Override
    public int getLatPaymentsummatyId() throws Exception {
        ResultSet r=CrudUtil.executeQuery("SELECT MAX(Pay_Id) FROM payment_summary");

        while (r.next()){
            int payId = r.getInt("MAX(Pay_Id)");
            return payId;
        }
        return 0;
    }
}
