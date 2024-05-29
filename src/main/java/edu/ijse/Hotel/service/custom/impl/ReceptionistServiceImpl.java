package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.ReceptionistDao;
import edu.ijse.lovers_leap.dto.ReceptionistsDto;
import edu.ijse.lovers_leap.entity.ReceptionistEntity;
import edu.ijse.lovers_leap.service.custom.ReceptionistService;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistServiceImpl implements ReceptionistService {
    private ReceptionistDao receptionistDao=(ReceptionistDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RECEPTIONIST);
    @Override
    public String saveReceptionist(ReceptionistsDto dto) throws Exception {
        ReceptionistEntity receptionistEntity=new ReceptionistEntity(dto.getFirstName(),
                dto.getLastName(),
                dto.getPosition(),
                dto.getHotelId(),
                dto.getPassword(),
                dto.getAge(),
                dto.getContactNo());
        if(receptionistDao.add(receptionistEntity)){
            return "Submitted the data";

        }else {
            return "Fail";
        }
    }

    @Override
    public ReceptionistsDto getId(String contactNo) throws Exception {
        ReceptionistEntity receptionistEntity=receptionistDao.getId(contactNo);
        return new ReceptionistsDto(receptionistEntity.getRep_Id(),
                receptionistEntity.getFirst_Name(),
                receptionistEntity.getLast_Name(),
                receptionistEntity.getAge(),
                receptionistEntity.getContact_No(),
                receptionistEntity.getPosition(),
                receptionistEntity.getHotel_ID(),
                receptionistEntity.getPassword());
    }

    @Override
    public ReceptionistsDto getReceiptionist(int id) throws Exception {
        ReceptionistEntity receptionistEntity1=receptionistDao.get(id);
        return new ReceptionistsDto(
                receptionistEntity1.getFirst_Name(),
                receptionistEntity1.getLast_Name(),
                receptionistEntity1.getAge(),
                receptionistEntity1.getContact_No(),
                receptionistEntity1.getPosition(),
                receptionistEntity1.getHotel_ID(),
                receptionistEntity1.getPassword());
    }

    @Override
    public String updateReceiptionist(ReceptionistsDto dto) throws Exception {
        ReceptionistEntity receptionistEntity=new ReceptionistEntity(dto.getReceptionistId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPosition(),
                dto.getHotelId(),
                dto.getPassword(),
                dto.getAge(),
                dto.getContactNo());
        if(receptionistDao.update(receptionistEntity)){
            return "Successfully updated the Receptionist";
        }else {
            return "Fail to Update Receptionist";
        }
    }

    @Override
    public String deleteReceptionist(int id) throws Exception {
        if(receptionistDao.delete(id)){
            return "Successfully Deleted the Receptionist!";
        }else {
            return "Fail to Delete !";
        }
    }

    @Override
    public List<ReceptionistsDto> getAllCustomers() throws Exception {
        List <ReceptionistsDto> dto=new ArrayList<>();
        ArrayList<ReceptionistEntity> ety=receptionistDao.getAll();
        for(ReceptionistEntity r: ety){
            dto.add(new ReceptionistsDto(r.getRep_Id(),
                    r.getFirst_Name(),
                    r.getLast_Name(),
                    r.getAge(),
                    r.getContact_No(),
                    r.getPosition(),
                    r.getHotel_ID(),
                    r.getPassword()));
        }
        return dto;
    }
}
