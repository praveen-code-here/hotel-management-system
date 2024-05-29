package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.RoomCategoryDao;
import edu.ijse.lovers_leap.entity.RoomCategoryEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomCategoryDaoImpl implements RoomCategoryDao {
    @Override
    public boolean add(RoomCategoryEntity rEntity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO room_category (Room_Type_Name,Cost_Per_Night,Discription) VALUES(?,?,?)",rEntity.getRoomTypeName(),rEntity.getCostPerNight(),rEntity.getDescription());

    }

    @Override
    public RoomCategoryEntity get(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM room_category WHERE CatID=?",id);
       while (rst.next()){
           return new RoomCategoryEntity(rst.getInt("CatID"),rst.getString("Room_Type_Name"),rst.getDouble("Cost_Per_Night"),rst.getString("Discription"));
       }
       return null;

    }

    @Override
    public RoomCategoryEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RoomCategoryEntity> getAll() throws Exception {
        ResultSet rst= CrudUtil.executeQuery("SELECT * FROM room_category");
        ArrayList<RoomCategoryEntity> ety=new ArrayList<>();
        while (rst.next()){
            ety.add(new RoomCategoryEntity(rst.getInt("CatID"),rst.getString("Room_Type_Name"),rst.getDouble("Cost_Per_Night"),rst.getString("Discription")));
        }
        return ety;
    }

    @Override
    public boolean update(RoomCategoryEntity rEty) throws Exception {
        return CrudUtil.executeUpdate("UPDATE room_category SET Room_Type_Name=?,Cost_Per_Night=?,Discription=? WHERE CatID=?",rEty.getRoomTypeName(),rEty.getCostPerNight(),rEty.getDescription(),rEty.getCatID());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM room_category WHERE CatID=? ",id);

    }

    @Override
    public ArrayList<RoomCategoryEntity> getIdByStaringName(String sName) throws Exception {
       ResultSet rst= CrudUtil.executeQuery("SELECT * FROM room_category WHERE Room_Type_Name=?",sName);
        ArrayList<RoomCategoryEntity> ety=new ArrayList<>();
        while (rst.next()){
            ety.add(new RoomCategoryEntity(rst.getInt("CatID"),rst.getString("Room_Type_Name"),rst.getDouble("Cost_Per_Night"),rst.getString("Discription")));
        }
        return ety;
    }
}
