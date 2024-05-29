package edu.ijse.lovers_leap.controller;

import edu.ijse.lovers_leap.dto.PaymentSummaryDto;
import edu.ijse.lovers_leap.service.ServiceFactory;
import edu.ijse.lovers_leap.service.custom.PaymentSummaryService;

import java.util.ArrayList;

public class PaymentSummaryController {
    PaymentSummaryService paymentSummaryService=(PaymentSummaryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.PAYMENT_SUMMARY);

    public ArrayList<PaymentSummaryDto> getAllPaymentSummary() throws Exception{
        return paymentSummaryService.getAllPaymentSummary();
    }

    public String savePayment(PaymentSummaryDto dto, int payId)  throws Exception{
        return paymentSummaryService.SavePayment(dto ,payId);
    }

    public int getLatsPaymentId() throws Exception{
        return paymentSummaryService.getLatsPaymentId();
    }




}
