package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.PaymentDetailEntity;

public interface PaymentDetailDao extends CrudDao<PaymentDetailEntity,String,Integer> {
    int getLastPaymentId() throws Exception;
}
