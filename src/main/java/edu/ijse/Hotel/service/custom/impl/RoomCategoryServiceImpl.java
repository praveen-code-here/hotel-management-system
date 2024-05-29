package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.RoomCategoryDao;
import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import edu.ijse.lovers_leap.entity.RoomCategoryEntity;
import edu.ijse.lovers_leap.service.custom.RoomCategoryService;

import java.util.ArrayList;

public class RoomCategoryServiceImpl implements RoomCategoryService {
    RoomCategoryDao roomCategoryDao= (RoomCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ROOMCATEGORY);

    @Override
    public String saveRoomCategory(RoomCategoryDto rDto) throws Exception {
        boolean rst=roomCategoryDao.add(new RoomCategoryEntity(rDto.getRoomCatName(),rDto.getCostPerNight(),rDto.getDescription()));
        if(rst){
            return "Successfully Saved the new Room Category !";
        }else {
            return "Fail to Save !!!";
        }
    }

    @Override
    public String updateRoomCategory(RoomCategoryDto rDto) throws Exception {
        if(roomCategoryDao.update(new RoomCategoryEntity(rDto.getCatId(),rDto.getRoomCatName(),rDto.getCostPerNight(),rDto.getDescription()))){
            return "Updated Scuuessfully !";
        }else {
            return "Failed !";
        }
    }

    @Override
    public String deleteRoomCategory(int rID) throws Exception {
        if(roomCategoryDao.delete(rID)){
            return "Successfully Deleted";
        }else {
            return "Failed !!";
        }
    }

    @Override
    public ArrayList<RoomCategoryDto> getAll() throws Exception {
        ArrayList<RoomCategoryDto> rDto=new ArrayList<>();
        ArrayList<RoomCategoryEntity> rEnty=roomCategoryDao.getAll();
        for( RoomCategoryEntity ety:rEnty ){
            rDto.add(new RoomCategoryDto(ety.getCatID(),ety.getRoomTypeName(),ety.getCostPerNight(),ety.getDescription()));
        }
        return rDto;
    }

    @Override
    public ArrayList<RoomCategoryDto> getIdByStringName(String sName) throws Exception {
        ArrayList<RoomCategoryDto> dtos=new ArrayList<>();
        ArrayList<RoomCategoryEntity> rEnty=roomCategoryDao.getIdByStaringName(sName);
        for( RoomCategoryEntity ety:rEnty ){
            dtos.add(new RoomCategoryDto(ety.getCatID(),ety.getRoomTypeName(),ety.getCostPerNight(),ety.getDescription()));
        }
        return dtos;

    }

    @Override
    public RoomCategoryDto get(int id) throws Exception {
        RoomCategoryEntity ety=roomCategoryDao.get(id);
        return new RoomCategoryDto(ety.getCatID(),ety.getRoomTypeName(),ety.getCostPerNight(),ety.getDescription());
    }
}
