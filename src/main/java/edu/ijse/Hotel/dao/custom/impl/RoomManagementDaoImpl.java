package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.RoomManagementDao;
import edu.ijse.lovers_leap.entity.RoomManagementEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomManagementDaoImpl implements RoomManagementDao {
    @Override
    public boolean add(RoomManagementEntity ETY) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO room (Room_Id,Cat_ID,Hotel_ID,No_of_Beds,Status) VALUES(?,?,?,?,?)",ETY.getRoom_ID(),
                ETY.getCat_ID(),
                ETY.getHotel_Id(),
                ETY.getNo_Of_Beds(),
                ETY.getStatus());
    }

    @Override
    public RoomManagementEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public RoomManagementEntity getId(String s) throws Exception {
        ResultSet rst= CrudUtil.executeQuery("SELECT * FROM room WHERE Room_Id=? ",s);
        while (rst.next()){
            return new RoomManagementEntity(rst.getString("Room_Id"),
                    rst.getInt("Cat_ID"),
                    rst.getInt("Hotel_ID"),
                    rst.getInt("No_of_Beds"),
                    rst.getString("Status"));
        }
        return null;
    }

    @Override
    public ArrayList<RoomManagementEntity> getAll() throws Exception {
        ResultSet rst= CrudUtil.executeQuery("SELECT * FROM room");
        ArrayList<RoomManagementEntity> ety =new ArrayList<>();
        while ((rst.next())){
            ety.add(new RoomManagementEntity(rst.getString("Room_Id"),rst.getInt("Cat_ID"),rst.getInt("Hotel_ID"),rst.getInt("No_of_Beds"),rst.getString("Status")));
        }
        return ety;
    }

    @Override
    public boolean update(RoomManagementEntity ETY) throws Exception {
        return CrudUtil.executeUpdate("UPDATE room SET Cat_ID=?,Hotel_ID=?,No_of_Beds=?,Status=? WHERE Room_Id=?",
                ETY.getCat_ID(),
                ETY.getHotel_Id(),
                ETY.getNo_Of_Beds(),
                ETY.getStatus(),
                ETY.getRoom_ID());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRoomByStringID(String sId) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM room WHERE Room_Id=?",sId);
    }
}
