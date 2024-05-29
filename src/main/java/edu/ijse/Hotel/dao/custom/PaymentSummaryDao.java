package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.PaymentSummaryEntity;

public interface PaymentSummaryDao extends CrudDao<PaymentSummaryEntity,String,Integer> {
    int getLatPaymentsummatyId() throws Exception;
}
