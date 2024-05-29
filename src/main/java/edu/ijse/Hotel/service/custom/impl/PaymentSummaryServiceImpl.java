package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.PaymentDetailDao;
import edu.ijse.lovers_leap.dao.custom.PaymentSummaryDao;
import edu.ijse.lovers_leap.dao.custom.ReservationDao;
import edu.ijse.lovers_leap.dao.custom.RoomManagementDao;
import edu.ijse.lovers_leap.db.DBConnection;
import edu.ijse.lovers_leap.dto.PaymentCartDto;
import edu.ijse.lovers_leap.dto.PaymentSummaryDto;
import edu.ijse.lovers_leap.entity.PaymentDetailEntity;
import edu.ijse.lovers_leap.entity.PaymentSummaryEntity;
import edu.ijse.lovers_leap.entity.ReservationEntity;
import edu.ijse.lovers_leap.entity.RoomManagementEntity;
import edu.ijse.lovers_leap.service.custom.PaymentSummaryService;

import java.sql.Connection;
import java.util.ArrayList;

public class PaymentSummaryServiceImpl implements PaymentSummaryService {
    private PaymentDetailDao paymentDetailDao = (PaymentDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.PAYMENT_DETAIL);
    private PaymentSummaryDao paymentSummaryDao = (PaymentSummaryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.PAYMENT_SUMMARY);
    private RoomManagementDao roomManagementDao = (RoomManagementDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ROOMMANAGEMENT);
    private ReservationDao reservationDao = (ReservationDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RESERVATION);

    @Override
    public ArrayList<PaymentSummaryDto> getAllPaymentSummary() throws Exception {
       ArrayList <PaymentSummaryDto> dto=new ArrayList<>();
       ArrayList<PaymentSummaryEntity> ety=paymentSummaryDao.getAll();
       for(PaymentSummaryEntity etys:ety){
           dto.add(new PaymentSummaryDto(etys.getPay_Id(),etys.getCus_Name(),etys.getTotal_Amount(),etys.getPayment_Method(),etys.getPayment_Date(),etys.getPayment_Time()));
       }
       return dto;
    }

    @Override
    public String SavePayment(PaymentSummaryDto dto ,int payId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            double totalCostCal=0.0;
            for(PaymentCartDto dtos:dto.getpDtos()){
                totalCostCal=totalCostCal+dtos.getAmount();
            }

            if (paymentSummaryDao.add(new PaymentSummaryEntity( totalCostCal , dto.getCustomer(), dto.getPaymentMethod(), dto.getPaidDate(), dto.getPaidTime()))) {

                boolean isSaved = true;
                for (PaymentCartDto pcDto : dto.getpDtos()) {//paymentCartDtos List
                    if (paymentDetailDao.add(new PaymentDetailEntity(payId, pcDto.getReservationId(), pcDto.getAmount()))) {
                    } else {
                        isSaved = false;
                    }
                }
                if (isSaved) {
                    boolean saveRoomStatus = true;
                    for (PaymentCartDto pcdto : dto.getpDtos()) {
                        String roomNo = reservationDao.get(pcdto.getReservationId()).getRoomNo();
                        RoomManagementEntity ety = roomManagementDao.getId(roomNo);
                        ety.setStatus("Available");
                        if(roomManagementDao.update(ety)){


                        }else {
                           saveRoomStatus=false;
                        }
                    }
                    if (saveRoomStatus) {
                        boolean saveResStatus=true;
                        for(PaymentCartDto pcDto:dto.getpDtos()){
                            ReservationEntity ety=reservationDao.get(pcDto.getReservationId());
                            ety.setBookingStatus("Paid");
                            if(reservationDao.update(ety)){

                            }else {
                                saveResStatus=false;
                            }
                        }

                        if(saveResStatus){
                            connection.commit();
                            return "Payment Successful !";
                        }else {
                            connection.rollback();
                            return "Fail to update Reservation Status";
                        }

                    } else {
                        connection.rollback();
                        return "Fail to update the room Status";
                    }
                } else {
                    connection.rollback();
                    return "Fail to save the payment details";
                }

            } else {
                connection.rollback();
                return "Fail to update the payment Summary";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;

        } finally {
            connection.setAutoCommit(true);

        }


    }

    @Override
    public int getLatsPaymentId() throws Exception {
        return paymentSummaryDao.getLatPaymentsummatyId();
    }


}
