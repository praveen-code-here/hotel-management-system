package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.LoginDao;
import edu.ijse.lovers_leap.dto.LoginDto;
import edu.ijse.lovers_leap.entity.LoginEntity;
import edu.ijse.lovers_leap.service.custom.LoginService;

import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao=(LoginDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.LOGIN);
    @Override
    public String saveLoginDeatil(LoginDto dto) throws Exception {
        if(loginDao.add(new LoginEntity(dto.getLoginTime(),dto.getLoginDate(),dto.getUserId()))){
            return "Successfully Saved the Login!";
        }else {
            return "Fail";
        }
    }

    @Override
    public LoginDto getLastLoginDetail() throws Exception {
        LoginEntity ety= loginDao.getLastLoginDetail();
        return new LoginDto(ety.getLogin_Detail_Id(),ety.getLogin_time(),ety.getLogin_Date(),ety.getUser_id());
    }

    @Override
    public ArrayList<LoginDto> getAll() throws Exception {
        ArrayList<LoginEntity> etys=loginDao.getAll();
        ArrayList<LoginDto> dtos=new ArrayList<>();
       for(LoginEntity en:etys){
           dtos.add(new LoginDto(en.getLogin_Detail_Id(),en.getLogin_time(),en.getLogin_Date(),en.getUser_id()));
       }
       return dtos;
    }
}
