package edu.ijse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.LoginDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.LoginService;

import java.util.ArrayList;

public class LoginController {
   private LoginService loginService=(LoginService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LOGIN);

    public String saveLogin(LoginDto dto) throws Exception{
        return loginService.saveLoginDeatil(dto);
    }

    public ArrayList<LoginDto> getAll() throws Exception{
        return loginService.getAll();
    }

    public LoginDto getLastLoginDetails() throws Exception{
        return loginService.getLastLoginDetail();
    }

}
