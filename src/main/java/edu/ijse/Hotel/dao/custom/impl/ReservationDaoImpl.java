package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.ReservationDao;
import edu.ijse.lovers_leap.entity.ReservationEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public boolean add(ReservationEntity ety) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO reservation (Cus_ID,In_Date,out_Date,Booking_Status,Room_no,Guest,BookedDate,BookedTime) VALUES(?,?,?,?,?,?,?,?)",ety.getCustomerId(),
                ety.getInDate(),
                ety.getOutDate(),
                ety.getBookingStatus(),
                ety.getRoomNo(),
                ety.getNoOfGuests(),
                ety.getBookedDate(),
                ety.getBookedTime());
    }

    @Override
    public ReservationEntity get(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM reservation WHERE Res_Id=?",id);
        while (rst.next()){
            return new ReservationEntity(rst.getInt("Res_Id"),
                    rst.getInt("Cus_ID"),
                    rst.getString("In_Date"),
                    rst.getString("out_Date"),
                    rst.getString("Booking_Status"),
                    rst.getString("Room_no"),
                    rst.getInt("Guest"),
                    rst.getString("BookedDate"),
                    rst.getString("BookedTime"));
        }
        return null;
    }

    @Override
    public ReservationEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReservationEntity> getAll() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM reservation");
        ArrayList<ReservationEntity> list=new ArrayList<>();
        while (rst.next()){
            list.add(new ReservationEntity(rst.getInt("Res_Id"),
                    rst.getInt("Cus_ID"),
                    rst.getString("In_Date"),
                    rst.getString("out_Date"),
                    rst.getString("Booking_Status"),
                    rst.getString("Room_no"),
                    rst.getInt("Guest"),
                    rst.getString("BookedDate"),
                    rst.getString("BookedTime")));
        }
        return list;
    }

    @Override
    public boolean update(ReservationEntity ety) throws Exception {
        return CrudUtil.executeUpdate("UPDATE reservation SET Cus_ID=?,In_Date=?," +
                        "out_Date=?,Booking_Status=?,Room_no=?,Guest=?, BookedDate=?," +
                        "BookedTime=?  WHERE Res_Id=?",
                ety.getCustomerId(),
                ety.getInDate(),
                ety.getOutDate(),
                ety.getBookingStatus(),
                ety.getRoomNo(),
                ety.getNoOfGuests(),
                ety.getBookedDate(),
                ety.getBookedTime(),
                ety.getReservationId());

    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM reservation WHERE Res_Id=?",id);
    }


}
