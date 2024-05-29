package edu.ijse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.CustomerDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService customerService=(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String addCustomer(CustomerDto customerDto) throws Exception{
        return customerService.addCustomer(customerDto);
    }

    public String updateCustomer(CustomerDto customerDto) throws Exception{
        return customerService.updateCustomer(customerDto);
    }

    public List<CustomerDto> getAllCustomer() throws Exception{
        return  customerService.getAllCustomer();
    }

    public String deleteCustomer(int id)throws  Exception{
        return customerService.DeleteCustomer(id);
    }

    public CustomerDto getCustomer(String nic) throws Exception{
        return customerService.getCustomer(nic);
    }

    public CustomerDto getCustomrById(int id) throws Exception{
        return customerService.getCustomerById(id);
    }
}
