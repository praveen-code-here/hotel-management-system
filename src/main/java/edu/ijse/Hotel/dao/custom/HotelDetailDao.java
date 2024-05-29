package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.HotelDetailEntity;

import java.util.ArrayList;

public interface HotelDetailDao extends CrudDao<HotelDetailEntity,String,Integer> {
    ArrayList<HotelDetailEntity> getHotelDetailByStringName(String name) throws Exception;
}
