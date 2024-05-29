package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.PaymentDetailDao;
import edu.ijse.lovers_leap.entity.PaymentDetailEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentDetailDaoImpl implements PaymentDetailDao {
    @Override
    public boolean add(PaymentDetailEntity pEty) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Payment_Details (Pay_Id,Res_ID,amount) VALUES(?,?,?)",pEty.getPay_Id(),pEty.getRes_ID(),pEty.getAmount());

    }

    @Override
    public PaymentDetailEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public PaymentDetailEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<PaymentDetailEntity> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM Payment_Details");
        ArrayList<PaymentDetailEntity> pdEty=new ArrayList<>();
        while (rst.next()){
            pdEty.add(new PaymentDetailEntity(rst.getInt("Pay_Id"),rst.getInt("Res_ID"),rst.getDouble("amount")));
        }
        return pdEty;
    }

    @Override
    public boolean update(PaymentDetailEntity paymentDetailEntity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }

    @Override
    public int getLastPaymentId() throws Exception {
        ResultSet r=CrudUtil.executeQuery("SELECT MAX(Pay_Id) AS Last_Pay_Id FROM Payment_Summary;");
        while (r.next()){
            return r.getInt("Pay_Id");
        }
        return 0;
    }
}
