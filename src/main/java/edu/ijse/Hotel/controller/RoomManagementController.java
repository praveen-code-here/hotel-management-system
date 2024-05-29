package edu.ijse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import edu.ijse.lovers_leap.dto.RoomManagementDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.RoomManagementService;

import java.util.ArrayList;

public class RoomManagementController {
    RoomManagementService roomManagementService=(RoomManagementService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOMMANAGEMENT);
    public ArrayList<RoomManagementDto> getAll() throws Exception{
       return roomManagementService.getAll();
    }
    public String addRoom(RoomManagementDto dto) throws Exception{
        return roomManagementService.saveRoom(dto);
    }
    public String updateRoom(RoomManagementDto dto) throws Exception{
        return roomManagementService.updateRoom(dto);
    }

    public String deleteRoom(String id) throws Exception{
        return roomManagementService.deleteRoom(id);
    }

}
