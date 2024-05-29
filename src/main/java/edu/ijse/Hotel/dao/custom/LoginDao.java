package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.LoginEntity;

public interface LoginDao extends CrudDao<LoginEntity,String ,Integer> {
    LoginEntity getLastLoginDetail() throws Exception;

}
