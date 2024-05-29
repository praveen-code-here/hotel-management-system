package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.CustomerDao;
import edu.ijse.lovers_leap.dao.custom.ReservationDao;
import edu.ijse.lovers_leap.dao.custom.RoomCategoryDao;
import edu.ijse.lovers_leap.dao.custom.RoomManagementDao;
import edu.ijse.lovers_leap.db.DBConnection;
import edu.ijse.lovers_leap.dto.ReservationDto;
import edu.ijse.lovers_leap.dto.ReservationSummaryDto;
import edu.ijse.lovers_leap.entity.ReservationEntity;
import edu.ijse.lovers_leap.entity.RoomManagementEntity;
import edu.ijse.lovers_leap.service.custom.ReservationService;
import edu.ijse.lovers_leap.service.custom.RoomManagementService;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao = (ReservationDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RESERVATION);
    private RoomManagementDao roomManagementDao = (RoomManagementDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ROOMMANAGEMENT);
    private CustomerDao customerDao=(CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);
    private RoomCategoryDao roomCategoryDao=(RoomCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ROOMCATEGORY);
    @Override
    public String saveReservation(ReservationDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            if (reservationDao.add(new ReservationEntity(dto.getCustomerId(), dto.getInDate(), dto.getOutDate(), dto.getBookingStatus(), dto.getRoomNo(), dto.getGuests(), dto.getBookedDate(), dto.getBookedTime()))) {


                RoomManagementEntity roomManagementEntity = roomManagementDao.getId(dto.getRoomNo());
                if (roomManagementEntity != null) {
                    roomManagementEntity.setStatus("Booked");
                    if (roomManagementDao.update(roomManagementEntity)) {
                        connection.commit();
                        return "Successfully Saved the Reservation for Room no : " + dto.getRoomNo();
                    } else {
                        connection.rollback();
                        return "Fail to update the room Status";
                    }
                } else {
                    connection.rollback();
                    return "Fail to get room entity!";
                }


            } else {
                connection.rollback();
                return "Fail to Book!";
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
    public String updateReservation(ReservationDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            String oldRoomNo = reservationDao.get(dto.getReservationId()).getRoomNo();
            RoomManagementEntity roomManagementEntity = roomManagementDao.getId(oldRoomNo);
            if (roomManagementEntity != null) {
                roomManagementEntity.setStatus("Available");
                if (roomManagementDao.update(roomManagementEntity)) {
                    if (reservationDao.update(new ReservationEntity(dto.getReservationId(), dto.getCustomerId(), dto.getInDate(), dto.getOutDate(), dto.getBookingStatus(), dto.getRoomNo(), dto.getGuests(), dto.getBookedDate(), dto.getBookedTime()))) {
                        RoomManagementEntity roomManagementEntity2 = roomManagementDao.getId(dto.getRoomNo());
                        roomManagementEntity2.setStatus("Booked");
                        if (roomManagementDao.update(roomManagementEntity2)) {
                            connection.commit();
                            return "Successfully Updated the Reservation :" + dto.getReservationId();
                        } else {
                            connection.rollback();
                            return "Fail to update room!";
                        }


                    } else {
                        connection.rollback();
                        return "Fail to update!";
                    }
                } else {
                    connection.rollback();
                    return "Fail to update the old room";
                }
            } else {
                connection.rollback();
                return "Fail to get the Reservation Entity";
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
    public String deleteReservation(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            String deletingRoomNo=reservationDao.get(id).getRoomNo();
            RoomManagementEntity roomManagementEntity=roomManagementDao.getId(deletingRoomNo);
            if(roomManagementEntity!=null){
                roomManagementEntity.setStatus("Available");
                if(roomManagementDao.update(roomManagementEntity)){
                    if (reservationDao.delete(id)) {
                        connection.commit();
                        return "Successfully deleted the Reservation no : , "+ id;
                    } else {
                        connection.rollback();
                        return "Fail to delete!";
                    }
                }else {
                    connection.rollback();
                    return "Fail to update room management entity!";
                }
            }else {
                connection.rollback();
                return "Fail to get room no";
            }
        }catch (Exception e){
            connection.rollback();
            e.printStackTrace();
            throw e;

        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<ReservationDto> getAll() throws Exception {
        ArrayList<ReservationDto> dlist = new ArrayList<>();
        ArrayList<ReservationEntity> ety = reservationDao.getAll();
        for (ReservationEntity entity : ety) {
            dlist.add(new ReservationDto(entity.getReservationId(), entity.getCustomerId(), entity.getInDate(), entity.getOutDate(), entity.getBookingStatus(), entity.getRoomNo(), entity.getNoOfGuests(), entity.getBookedDate(), entity.getBookedTime()));
        }
        return dlist;
    }

    @Override
    public ReservationDto getReservation(int id) throws Exception {
        ReservationEntity ety=reservationDao.get(id);
        return new ReservationDto(ety.getReservationId(),ety.getCustomerId(),ety.getInDate(),ety.getOutDate(),ety.getBookingStatus(),ety.getRoomNo(),ety.getNoOfGuests(),ety.getBookedDate(),ety.getBookedTime());
    }

    @Override
    public String UpdateReservationStatus(int id,String roomNo) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            ReservationEntity ety=reservationDao.get(id);
            if(ety!=null){
                ety.setBookingStatus("Cancelled");
                if(reservationDao.update(ety)){
                    RoomManagementEntity rmety=roomManagementDao.getId(roomNo);
                    if(rmety!=null){
                        rmety.setStatus("Available");
                        if(roomManagementDao.update(rmety)){
                            connection.commit();
                            return "Successfully Cancelled the reservation NO : "+Integer.toString(id);
                        }else {
                            connection.rollback();
                            return "Fail to update the room Status";
                        }
                    }else {
                        connection.rollback();
                        return "Fail to get the room management entity";
                    }
                }else {
                    connection.rollback();
                    return "Fail to update the status";
                }
            }else {
                connection.rollback();
                return "Fail to get the Reservation Entity";
            }

        }catch (Exception e){
            connection.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            connection.setAutoCommit(true);

        }
    }

    @Override
    public ArrayList<ReservationSummaryDto> getAllSummary() throws Exception {
        ArrayList<ReservationSummaryDto> reservationSummaryDtos=new ArrayList<>();
        ArrayList<ReservationEntity> rdtos=reservationDao.getAll();


        for(ReservationEntity ety:rdtos){
            reservationSummaryDtos.add(new ReservationSummaryDto(ety.getReservationId(),customerDao.get(ety.getCustomerId()).getFirst_Name(),customerDao.get(ety.getCustomerId()).getContact_no(),ety.getRoomNo(),ety.getBookingStatus(),roomCategoryDao.get(roomManagementDao.getId(ety.getRoomNo()).getCat_ID()).getCostPerNight(),(int)getDays(ety.getInDate().toString(),ety.getOutDate().toString())));
        }
        return reservationSummaryDtos;
    }

     long getDays(String currentDate, String otherDate) {
        LocalDate currentDateObj = LocalDate.parse(currentDate);
        LocalDate otherDateObj = LocalDate.parse(otherDate);
        return ChronoUnit.DAYS.between(currentDateObj, otherDateObj);
    }
}
