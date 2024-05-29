package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.RoomManagementDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.ArrayList;

public interface RoomManagementService extends SuperService {
    String saveRoom(RoomManagementDto dto) throws Exception;
    String updateRoom(RoomManagementDto dto) throws Exception;
    String deleteRoom(String rId) throws Exception;
    ArrayList<RoomManagementDto> getAll() throws Exception;
}
