package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.ReceptionistsDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.List;

public interface ReceptionistService extends SuperService {
    String saveReceptionist(ReceptionistsDto receptionistsDto) throws Exception;
    ReceptionistsDto getId(String contactNo)throws Exception;
    ReceptionistsDto getReceiptionist(int id) throws Exception;

    String updateReceiptionist(ReceptionistsDto receptionistsDto) throws Exception;
    String deleteReceptionist(int id) throws Exception;

    List<ReceptionistsDto> getAllCustomers() throws Exception;
}
