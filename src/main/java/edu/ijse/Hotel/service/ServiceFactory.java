package edu.ijse.lovers_leap.service;

import edu.ijse.lovers_leap.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){

    }

    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }


    public SuperService getService(ServiceType serviceType){
        switch (serviceType){
            case RECEIPTIONIST:
                return new ReceptionistServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case HOTELDETAIL:
                return new HotelDetailServiceImple();
            case ROOMCATEGORY:
                return new RoomCategoryServiceImpl();
            case ROOMMANAGEMENT:
                return new RoomManagementServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            case PAYMENT_SUMMARY:
                return new PaymentSummaryServiceImpl();
            case LOGIN:
                return new LoginServiceImpl();
            default:
                throw new AssertionError();
        }

    }

    public enum ServiceType{
        RECEIPTIONIST,CUSTOMER,HOTELDETAIL,ROOMCATEGORY,ROOMMANAGEMENT,RESERVATION,PAYMENT_SUMMARY,LOGIN;
    }

}
