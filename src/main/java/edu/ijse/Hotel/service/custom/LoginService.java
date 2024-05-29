package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.LoginDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.ArrayList;

public interface LoginService extends SuperService {
    String saveLoginDeatil(LoginDto dto) throws Exception;

    LoginDto getLastLoginDetail() throws Exception;
    ArrayList<LoginDto> getAll() throws Exception;

}
