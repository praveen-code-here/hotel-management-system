package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.CustomerDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {
    String addCustomer(CustomerDto dto) throws Exception;
    String updateCustomer(CustomerDto dto) throws Exception;
    List<CustomerDto> getAllCustomer() throws Exception;
    String DeleteCustomer(int id) throws Exception;

    CustomerDto getCustomer(String nic) throws Exception;
    CustomerDto getCustomerById(int id) throws Exception;
}
