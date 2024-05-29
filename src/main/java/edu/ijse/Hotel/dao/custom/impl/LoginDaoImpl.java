package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.LoginDao;
import edu.ijse.lovers_leap.entity.LoginEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean add(LoginEntity ety) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO login_Details (login_time,login_Date,user_id) VALUES(?,?,?)",ety.getLogin_time(),ety.getLogin_Date(),ety.getUser_id());

    }

    @Override
    public LoginEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public LoginEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<LoginEntity> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM login_Details");
        ArrayList<LoginEntity> etys=new ArrayList<>();
        while (rst.next()){
            etys.add(new LoginEntity(rst.getInt("Login_Detail_Id"),
                    rst.getString("login_time"),
                    rst.getString("login_Date"),
                    rst.getInt("user_id")));
        }
        return etys;
    }

    @Override
    public boolean update(LoginEntity loginEntity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }

    @Override
    public LoginEntity getLastLoginDetail() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT Login_Detail_Id, login_time, login_Date, user_id FROM Login_Details having Login_Detail_Id=(SELECT MAX(Login_Detail_Id) AS Last_Pay_Id FROM Login_Details)");
        while (rst.next()){
            return new LoginEntity(rst.getInt("Login_Detail_Id"),
                    rst.getString("login_time"),
                    rst.getString("login_Date"),
                    rst.getInt("user_id"));
        }
        return null;
    }
}
