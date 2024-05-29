package edu.ijse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.ReceptionistsDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.ReceptionistService;

import java.util.List;

public class ReceptionistController {
    private ReceptionistService receptionistService=(ReceptionistService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RECEIPTIONIST);

    public String save(ReceptionistsDto receptionistsDto) throws Exception {
        return receptionistService.saveReceptionist(receptionistsDto);
    }

    public ReceptionistsDto getId(String contactNo) throws Exception{
        return receptionistService.getId(contactNo);
    }

    public ReceptionistsDto getReceptionist(int repId) throws Exception{
        return receptionistService.getReceiptionist(repId);
    }

    public String deleteReceptionist(int id) throws Exception{
        return receptionistService.deleteReceptionist(id);
    }

    public String UpdateReceptionist(ReceptionistsDto receptionistsDto) throws Exception{
        return receptionistService.updateReceiptionist(receptionistsDto);
    }

    public List<ReceptionistsDto> getAllCustomers() throws Exception{
        return receptionistService.getAllCustomers();
    }

}
