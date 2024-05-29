package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.HotelDetailDao;
import edu.ijse.lovers_leap.dto.HotelDto;
import edu.ijse.lovers_leap.entity.HotelDetailEntity;
import edu.ijse.lovers_leap.service.custom.HotelDetailService;

import java.util.ArrayList;

public class HotelDetailServiceImple implements HotelDetailService {
    HotelDetailDao hotelDetailDao=(HotelDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.HOTELDETAIL);
    @Override
    public String addHotel(HotelDto hDto) throws Exception {
        HotelDetailEntity ety=new HotelDetailEntity(hDto.getName(),hDto.getAddress(),hDto.getDistrict(),hDto.getContactNo());
        if(hotelDetailDao.add(ety)){
            return "Successfully Saved the new hotel";
        }else {
            return "Fail to save !";
        }
    }

    @Override
    public String updateHotelDetails(HotelDto hDto) throws Exception {
        HotelDetailEntity ety=new HotelDetailEntity(hDto.getHotelId(),hDto.getName(),hDto.getAddress(),hDto.getDistrict(),hDto.getContactNo());
        if(hotelDetailDao.update(ety)){
            return "Successfully Updated the new hotel !";
        }else {
            return "Fail to Update the hotel Details";
        }
    }

    @Override
    public HotelDto get(String sId) throws Exception {
        HotelDetailEntity ety=hotelDetailDao.getId(sId);
        return new HotelDto(ety.getHotel_ID(),ety.getName(),ety.getAddress(),ety.getDistrict(),ety.getContactNo());
    }

    @Override
    public HotelDto getIdType(int iId) throws Exception {
        HotelDetailEntity ety=hotelDetailDao.get(iId);
        return new HotelDto(ety.getHotel_ID(),ety.getName(),ety.getAddress(),ety.getDistrict(),ety.getContactNo());
    }

    @Override
    public ArrayList<HotelDto> getAll() throws Exception {
        ArrayList<HotelDto> list=new ArrayList<>();
        ArrayList<HotelDetailEntity> ety=hotelDetailDao.getAll();
        for(HotelDetailEntity e:ety){
            list.add(new HotelDto(e.getHotel_ID(),e.getName(),e.getAddress(),e.getDistrict(),e.getContactNo()));
        }
        return list;
    }

    @Override
    public String deleteHotel(int iId) throws Exception {
        if(hotelDetailDao.delete(iId)){
            return "Deleted successfully";
        }else {
            return "Fail to Delete";
        }
    }

    @Override
    public ArrayList<HotelDto> getHotelDeatilsByStringName(String name) throws Exception {
        ArrayList<HotelDto> dtos=new ArrayList<>();
        ArrayList<HotelDetailEntity> etys=hotelDetailDao.getHotelDetailByStringName(name);
        for(HotelDetailEntity Ety:etys){
            dtos.add(new HotelDto(Ety.getHotel_ID(),Ety.getName(),Ety.getAddress(),Ety.getDistrict(),Ety.getContactNo()));
        }
        return dtos;
    }
}
