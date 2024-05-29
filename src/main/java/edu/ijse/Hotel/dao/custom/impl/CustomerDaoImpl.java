package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.CustomerDao;
import edu.ijse.lovers_leap.entity.CustomerEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean add(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO customer (First_Name,Last_Name,Address,Country,Gender,Email,contact_no,NIC_no) VALUES(?,?,?,?,?,?,?,?)",
                customerEntity.getFirst_Name(),
                customerEntity.getLast_Name(),
                customerEntity.getAddress(),
                customerEntity.getCountry(),
                customerEntity.getGender(),
                customerEntity.getEmail(),
                customerEntity.getContact_no(),
                customerEntity.getNIC_no());
    }

    @Override
    public CustomerEntity get(Integer id) throws Exception {
        ResultSet rst= CrudUtil.executeQuery("SELECT * FROM customer WHERE Cus_Id=?",id);
        while (rst.next()){
            return new CustomerEntity(rst.getInt("Cus_Id"),
                    rst.getString("First_Name"),
                    rst.getString("Last_Name"),
                    rst.getString("Address"),
                    rst.getString("Country"),
                    rst.getString("Gender"),
                    rst.getString("Email"),
                    rst.getString("contact_no"),
                    rst.getString("NIC_no"));
        }
        return null;
    }

    @Override
    public CustomerEntity getId(String nic) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer WHERE NIC_no=?", nic);
        while (rst.next()) {
            return new CustomerEntity(rst.getInt("Cus_Id"),
                    rst.getString("First_Name"),
                    rst.getString("Last_Name"),
                    rst.getString("Address"),
                    rst.getString("Country"),
                    rst.getString("Gender"),
                    rst.getString("Email"),
                    rst.getString("contact_no"),
                    rst.getString("NIC_no"));
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM customer");
        ArrayList<CustomerEntity> customerEntities=new ArrayList<>();
        while (rst.next()){
            customerEntities.add(new CustomerEntity(rst.getInt("Cus_Id"),
                    rst.getString("First_Name"),
                    rst.getString("Last_Name"),
                    rst.getString("Address"),
                    rst.getString("Country"),
                    rst.getString("Gender"),
                    rst.getString("Email"),
                    rst.getString("contact_no"),
                    rst.getString("NIC_no")));
        }
        return customerEntities;
    }

    @Override
    public boolean update(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE customer SET First_Name=?, Last_Name=?, Address=?, Country=?,Gender=?,Email=?,contact_no=?,NIC_no=? WHERE Cus_Id=?",customerEntity.getFirst_Name(),
                customerEntity.getLast_Name(),
                customerEntity.getAddress(),
                customerEntity.getCountry(),
                customerEntity.getGender(),
                customerEntity.getEmail(),
                customerEntity.getContact_no(),
                customerEntity.getNIC_no(),
                customerEntity.getCus_Id());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE Cus_Id=?",id);
    }
}
