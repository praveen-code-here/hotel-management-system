package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.RoomManagementDao;
import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import edu.ijse.lovers_leap.dto.RoomManagementDto;
import edu.ijse.lovers_leap.entity.RoomManagementEntity;
import edu.ijse.lovers_leap.service.custom.RoomManagementService;

import java.util.ArrayList;

public class RoomManagementServiceImpl implements RoomManagementService {
    RoomManagementDao roomManagementDao=(RoomManagementDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ROOMMANAGEMENT);
    @Override
    public String saveRoom(RoomManagementDto dto) throws Exception {
        if(roomManagementDao.add(new RoomManagementEntity(dto.getRoomId(),dto.getCatId(),dto.getHotelId(),dto.getNoOfBeds(),dto.getStatus()))){
            return "Successfully Added the New Room !";
        }else{
            return "Fail to add new Room !";
        }
    }

    @Override
    public String updateRoom(RoomManagementDto dto) throws Exception {
        if(roomManagementDao.update(new RoomManagementEntity(dto.getRoomId(),dto.getCatId(),dto.getHotelId(),dto.getNoOfBeds(),dto.getStatus()))){
            return "Successfully Updated the New Room !";
        }else{
            return "Fail to update the Room !";
        }
    }

    @Override
    public String deleteRoom(String Id) throws Exception {
        if (roomManagementDao.deleteRoomByStringID(Id)) {
            return "Successfully Deleted the Room!";
        } else {
            return "Fail to Delete !";
        }
    }

    @Override
    public ArrayList<RoomManagementDto> getAll() throws Exception {
        ArrayList<RoomManagementDto> dtos=new ArrayList<>();
        ArrayList<RoomManagementEntity> ety= roomManagementDao.getAll();
        for(RoomManagementEntity Etys: ety){
            dtos.add(new RoomManagementDto(Etys.getRoom_ID(),Etys.getCat_ID(),Etys.getHotel_Id(),Etys.getNo_Of_Beds(),Etys.getStatus()));
        }
        return dtos;
    }
}
