package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.ArrayList;

public interface RoomCategoryService extends SuperService {
    String saveRoomCategory(RoomCategoryDto rDto) throws Exception;
    String updateRoomCategory(RoomCategoryDto rDto) throws Exception;
    String deleteRoomCategory(int rID) throws Exception;
    ArrayList<RoomCategoryDto> getAll( ) throws Exception;
    ArrayList<RoomCategoryDto> getIdByStringName( String sName) throws Exception;
    RoomCategoryDto get(int id) throws Exception;
}
