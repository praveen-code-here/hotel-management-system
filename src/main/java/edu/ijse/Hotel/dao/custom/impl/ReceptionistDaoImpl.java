package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.ReceptionistDao;
import edu.ijse.lovers_leap.entity.ReceptionistEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ReceptionistDaoImpl implements ReceptionistDao {
    @Override
    public boolean add(ReceptionistEntity receptionistEntity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO receptionists (First_Name,Last_Name,position,Hotel_ID,password,age,contact_no) VALUES(?,?,?,?,?,?,?)",
                receptionistEntity.getFirst_Name(),
                receptionistEntity.getLast_Name(),
                receptionistEntity.getPosition(),
                receptionistEntity.getHotel_ID(),
                receptionistEntity.getPassword(),
                receptionistEntity.getAge(),
                receptionistEntity.getContact_No());
    }

    @Override
    public ReceptionistEntity get(Integer Rep_Id) throws Exception {
        ResultSet rst1=CrudUtil.executeQuery("SELECT * FROM receptionists WHERE Rep_Id=?",Rep_Id);
        while (rst1.next()){
            return new ReceptionistEntity(
                    rst1.getString("First_Name"),
                    rst1.getString("Last_Name"),
                    rst1.getString("position"),
                    rst1.getInt("Hotel_ID"),
                    rst1.getString("password"),
                    rst1.getInt("age"),
                    rst1.getString("contact_no"));
        }
        return null;
    }

    @Override
    public ReceptionistEntity getId(String contact_no) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM receptionists WHERE contact_no=?",contact_no);
        while (rst.next()){
            return new ReceptionistEntity(rst.getInt("Rep_Id"),
                    rst.getString("First_Name"),
                    rst.getString("Last_Name"),
                    rst.getString("position"),
                    rst.getInt("Hotel_ID"),
                    rst.getString("password"),
                    rst.getInt("age"),
                    rst.getString("contact_no"));
        }
        return null;
    }

    @Override
    public ArrayList<ReceptionistEntity> getAll() throws Exception {
        ResultSet result=CrudUtil.executeQuery("SELECt * FROM receptionists");
        ArrayList<ReceptionistEntity> ety=new ArrayList<>();
        while (result.next()){
            ety.add(new ReceptionistEntity(result.getInt("Rep_Id"),
                    result.getString("First_Name"),
                    result.getString("Last_Name"),
                    result.getString("position"),
                    result.getInt("Hotel_ID"),
                    result.getString("password"),
                    result.getInt("age"),
                    result.getString("contact_no")));
        }
        return  ety;

    }

    @Override
    public boolean update(ReceptionistEntity ety) throws Exception {
        return CrudUtil.executeUpdate("UPDATE receptionists SET First_Name=?,Last_Name=?,position=?,Hotel_ID=?,password=?,age=?,contact_no=? WHERE Rep_Id=?",
                ety.getFirst_Name(),
                ety.getLast_Name(),
                ety.getPosition(),
                ety.getHotel_ID(),
                ety.getPassword(),
                ety.getAge(),
                ety.getContact_No(),
                ety.getRep_Id());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM receptionists WHERE Rep_Id=?",id);
    }
}
