package edu.ijse.Hotel.controllerse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.HotelDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.HotelDetailService;

import java.util.ArrayList;

public class HotelDetailController {
    HotelDetailService hotelDetailService=(HotelDetailService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.HOTELDETAIL);


    public String addHotel(HotelDto dto) throws Exception{
        return hotelDetailService.addHotel(dto);
    }
    public String UpdateHotelDetails(HotelDto dto) throws Exception{
        return hotelDetailService.updateHotelDetails(dto);
    }
    public ArrayList<HotelDto> getAll() throws Exception{
        return hotelDetailService.getAll();
    }

    public String deleteHotel(int iId) throws Exception{
        return hotelDetailService.deleteHotel(iId);
    }

    public HotelDto getHotelbyID(int iId) throws Exception{
        return hotelDetailService.getIdType(iId);
    }
    public ArrayList<HotelDto> getHotelByStringName(String sId) throws Exception{
        return hotelDetailService.getHotelDeatilsByStringName(sId);
    }
}
