package edu.ijse.lovers_leap.service.custom;

import edu.ijse.lovers_leap.dto.PaymentSummaryDto;
import edu.ijse.lovers_leap.service.SuperService;

import java.util.ArrayList;

public interface PaymentSummaryService extends SuperService {
    ArrayList<PaymentSummaryDto> getAllPaymentSummary() throws Exception;
    String SavePayment(PaymentSummaryDto dto, int payId) throws Exception;

    int getLatsPaymentId() throws Exception;

}
