package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.ReservationDto;
import edu.ijse.lovers_leap.dto.ReservationSummaryDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.ArrayList;

public interface ReservationService extends SuperService {
    String saveReservation(ReservationDto dto) throws Exception;
    String updateReservation(ReservationDto dto) throws Exception;
    String deleteReservation(int id) throws Exception;
    ArrayList<ReservationDto> getAll() throws Exception;
    ReservationDto getReservation(int id) throws Exception;

    String UpdateReservationStatus(int id,String RoomNo) throws Exception;

    ArrayList<ReservationSummaryDto> getAllSummary() throws Exception;
}
