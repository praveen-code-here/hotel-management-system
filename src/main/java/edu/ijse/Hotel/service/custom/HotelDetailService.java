package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.HotelDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.ArrayList;

public interface HotelDetailService extends SuperService {
    String addHotel(HotelDto hDto) throws Exception;
    String updateHotelDetails(HotelDto hDto) throws Exception;
    HotelDto get(String sId) throws Exception;
    HotelDto getIdType(int iId) throws Exception;
    ArrayList<HotelDto> getAll() throws Exception;
    String deleteHotel(int iId) throws Exception;

    ArrayList<HotelDto> getHotelDeatilsByStringName(String name) throws Exception;

}
