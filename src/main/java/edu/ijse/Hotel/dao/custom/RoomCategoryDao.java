package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.RoomCategoryEntity;

import java.util.ArrayList;

public interface RoomCategoryDao extends CrudDao<RoomCategoryEntity,String, Integer> {
    ArrayList<RoomCategoryEntity> getIdByStaringName(String sName) throws Exception;
}
