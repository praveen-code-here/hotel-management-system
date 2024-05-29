package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.CustomerDao;
import edu.ijse.lovers_leap.dto.CustomerDto;
import edu.ijse.lovers_leap.entity.CustomerEntity;
import edu.ijse.lovers_leap.service.custom.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao=(CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto dto) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity(dto.getFirstName(),
                dto.getLastName(),
                dto.getAddress(),
                dto.getCountry(),
                dto.getGender(),
                dto.getEmail(),
                dto.getContactNo(),
                dto.getNicNo());
        if(customerDao.add(customerEntity)){
            return "Submitted the Customer Successfully";

        }else {
            return "Submission Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDto dto) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity(dto.getCustomerId(),dto.getFirstName(),dto.getLastName(),dto.getAddress(),dto.getCountry(),dto.getGender(),dto.getEmail(),dto.getContactNo(),dto.getNicNo());
        if(customerDao.update(customerEntity)){
            return "Updated Successfully";
        }else {
            return "Update Error!";
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() throws Exception {
        List<CustomerDto> customerDtos=new ArrayList<>();
        List<CustomerEntity> customerEntities=customerDao.getAll();
        for(CustomerEntity cusEy:customerEntities){
            customerDtos.add(new CustomerDto(cusEy.getCus_Id(),
                    cusEy.getFirst_Name(),
                    cusEy.getLast_Name(),
                    cusEy.getAddress(),
                    cusEy.getCountry(),
                    cusEy.getGender(),
                    cusEy.getEmail(),
                    cusEy.getContact_no(),
                    cusEy.getNIC_no()));
        }

        return customerDtos;
    }

    @Override
    public String DeleteCustomer(int id) throws Exception {
        if(customerDao.delete(id)){
            return "Successfully Deleted ";
        }else {
            return "Fail to Delete the Customer";
        }
    }

    @Override
    public CustomerDto getCustomer(String nic) throws Exception {
        CustomerEntity customerEntity=customerDao.getId(nic);
        if(customerEntity!=null){
            return new CustomerDto(customerEntity.getCus_Id(),
                    customerEntity.getFirst_Name(),
                    customerEntity.getLast_Name(),
                    customerEntity.getAddress(),
                    customerEntity.getCountry(),
                    customerEntity.getGender(),
                    customerEntity.getEmail(),
                    customerEntity.getContact_no(),
                    customerEntity.getNIC_no());
        }
        return null;
    }

    @Override
    public CustomerDto getCustomerById(int id) throws Exception {
        CustomerEntity ety=customerDao.get(id);
        return new CustomerDto(ety.getCus_Id(),ety.getFirst_Name(),ety.getLast_Name(),ety.getAddress(),ety.getCountry(),ety.getGender(),ety.getEmail(),ety.getContact_no(),ety.getNIC_no());
    }
}
