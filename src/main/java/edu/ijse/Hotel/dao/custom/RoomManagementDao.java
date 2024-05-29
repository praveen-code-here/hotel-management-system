package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.RoomManagementEntity;

public interface RoomManagementDao extends CrudDao<RoomManagementEntity,String,Integer> {
    boolean deleteRoomByStringID(String sId) throws Exception;
}
