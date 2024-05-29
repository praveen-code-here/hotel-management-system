package edu.ijse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.RoomCategoryService;

import java.util.ArrayList;

public class RoomCategoryController {
    private RoomCategoryService roomCategoryService=(RoomCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOMCATEGORY);

    public  String saveRoomCategory(RoomCategoryDto dto) throws Exception{
        return roomCategoryService.saveRoomCategory(dto);
    }
    public String deleteRoomCategory(int rId) throws Exception{
        return roomCategoryService.deleteRoomCategory(rId);
    }

    public ArrayList<RoomCategoryDto> getAll() throws Exception{
        return roomCategoryService.getAll();
    }
    public String updateRoomCategory(RoomCategoryDto dto) throws Exception{
        return roomCategoryService.updateRoomCategory(dto);
    }
    public ArrayList<RoomCategoryDto> getIdByStringName(String sName) throws Exception{
        return roomCategoryService.getIdByStringName(sName);
    }
    public RoomCategoryDto get(int id) throws Exception{
        return roomCategoryService.get(id);
    }

}
