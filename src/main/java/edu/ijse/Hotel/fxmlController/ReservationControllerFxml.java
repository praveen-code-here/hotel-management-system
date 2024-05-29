package edu.ijse.lovers_leap.fxmlController;

import edu.ijse.lovers_leap.controller.CustomerController;
import edu.ijse.lovers_leap.controller.ReservationController;
import edu.ijse.lovers_leap.controller.RoomCategoryController;
import edu.ijse.lovers_leap.controller.RoomManagementController;
import edu.ijse.lovers_leap.dto.CustomerDto;
import edu.ijse.lovers_leap.dto.ReservationDto;
import edu.ijse.lovers_leap.dto.RoomManagementDto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateStringConverter;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReservationControllerFxml implements Initializable {
    private RoomManagementController roomManagementController;
    private CustomerController customerController;
    private RoomCategoryController roomCategoryController;
    private ReservationController reservationController;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancell;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbBookingStatus;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colBedsRS;

    @FXML
    private TableColumn<ReservationDto, String> colBookingStatus;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colCategoryRS;

    @FXML
    private TableColumn<CustomerDto,String> colContatcNoCS;

    @FXML
    private TableColumn<ReservationDto, Integer> colCusId;

    @FXML
    private TableColumn<CustomerDto, Integer> colCustomerIdCS;

    @FXML
    private TableColumn<ReservationDto, Integer> colGuests;

    @FXML
    private TableColumn<ReservationDto, String> colInDate;

    @FXML
    private TableColumn<CustomerDto, String> colNameCS;

    @FXML
    private TableColumn<ReservationDto, String> colOutDate;

    @FXML
    private TableColumn<ReservationDto, Integer> colResId;

    @FXML
    private TableColumn<RoomManagementDto,String> colRoomIdRS;

    @FXML
    private TableColumn<ReservationDto, String> colRoomNo;

    @FXML
    private TableColumn<RoomManagementDto,String> colStatusRS;
    @FXML
    private TableColumn<ReservationDto, String> colBookedDate;
    @FXML
    private TableColumn<ReservationDto, String> colBookedTime;

    @FXML
    private DatePicker dateIN;

    @FXML
    private DatePicker dateOut;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblCustomerNic;

    @FXML
    private TableView<CustomerDto> tblCustomerStatus;

    @FXML
    private TableView<ReservationDto> tblReservation;

    @FXML
    private TableView<RoomManagementDto> tblRoomStatus;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtGuests;

    @FXML
    private TextField txtRoomId;

    @FXML
    private Label lblRoomCategory;

    @FXML
    private Label lblRoomCost;

    String getCurrentDate(){
        LocalDate date=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString =date.format(formatter);
        return dateString;
    }

    String getCurrentTime(){
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm:ss");
        String timetoString=time.format(formatter);
        return timetoString;

    }
    static long getDaysDifference(String currentDate, String otherDate) {
        LocalDate currentDateObj = LocalDate.parse(currentDate);
        LocalDate otherDateObj = LocalDate.parse(otherDate);
        return ChronoUnit.DAYS.between(currentDateObj, otherDateObj);
    }

    @FXML
    void btnAddAction(ActionEvent event) {
        if(!txtCusId.getText().isEmpty() | !txtRoomId.getText().isEmpty() | dateOut.getValue()!=null | dateIN.getValue()!=null | !txtGuests.getText().isEmpty() ){
            String dateInSelection=dateIN.getValue().toString();
            String currentDate=getCurrentDate();

            int comparison=dateInSelection.compareTo(currentDate);

            if(comparison>=0){
                String dateOutSelection=dateOut.getValue().toString();
                int comparisonOfInandOut=dateOutSelection.compareTo(dateInSelection);
                if(comparisonOfInandOut>=0){
                    try {
                        String rst=reservationController.saveReservation(new ReservationDto(Integer.parseInt(txtCusId.getText()),dateIN.getValue().toString(),dateOut.getValue().toString(),cmbBookingStatus.getValue(),txtRoomId.getText(),Integer.parseInt(txtGuests.getText()),getCurrentDate(),getCurrentTime()));
                        clear();
                        loadTables();
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setContentText(rst);
                        Optional<ButtonType> result2 = alert2.showAndWait();
                    } catch (Exception e) {
                        Alert alert2 = new Alert(Alert.AlertType.ERROR);
                        alert2.setContentText(e.getMessage());
                        Optional<ButtonType> result2 = alert2.showAndWait();

                    }

                }else {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Check in date and check out date error !");
                    alert2.setContentText("Please select correct check in date and check out Date !");
                    Optional<ButtonType> result2 = alert2.showAndWait();
                }
            }else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Check in date Error !");
                alert2.setContentText("Please select correct check in date! afte the "+getCurrentDate());
                Optional<ButtonType> result2 = alert2.showAndWait();

            }

        }else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error !");
            alert2.setContentText("Please Fill all the data !");
            Optional<ButtonType> result2 = alert2.showAndWait();
        }
        loadTables();

    }

    @FXML
    void btnCancellAction(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Are You Sure ?");
        alert1.setContentText("Your Reservation will be cancel permanently! ");
        Optional<ButtonType> result = alert1.showAndWait();
        if (result.isEmpty()) {
        } else if (result.get() == ButtonType.OK) {
            try {
                String dateOfIn=reservationController.getReservation(tblReservation.getSelectionModel().getSelectedItem().getReservationId()).getInDate();
                String currentDate=getCurrentDate();
                long daysDifference = getDaysDifference(currentDate, dateOfIn);
                if(daysDifference>1){
                    try {
                        String rst=reservationController.updateReservationStatusByReservationId(tblReservation.getSelectionModel().getSelectedItem().getReservationId(),tblReservation.getSelectionModel().getSelectedItem().getRoomNo());
                        clear();
                        loadTables();
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setContentText(rst);
                        Optional<ButtonType> result2 = alert2.showAndWait();
                    } catch (Exception e) {
                        Alert alert2 = new Alert(Alert.AlertType.ERROR);
                        alert2.setContentText(e.getMessage());
                        Optional<ButtonType> result2 = alert2.showAndWait();

                    }


                }else {
                    Alert alert3 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Cancellation Error");
                    alert1.setContentText("Sorry You can not Cancel this reservation due to exceed 24h time limit.");
                    Optional<ButtonType> rst = alert1.showAndWait();
                }
            } catch (Exception e) {
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Error");
                alert1.setContentText("Please select the reservation!");
                Optional<ButtonType> rst = alert1.showAndWait();
            }
        }
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Are You Sure ?");
        alert1.setContentText("Your Data will be permanently delete ! ");
        Optional<ButtonType> result = alert1.showAndWait();
        if (result.isEmpty()) {
        } else if (result.get() == ButtonType.OK) {

            try {
                String rst=reservationController.deleteReservation(tblReservation.getSelectionModel().getSelectedItem().getReservationId());
                clear();
                loadTables();
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setContentText(rst);
                Optional<ButtonType> result2 = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setContentText("Please Select the Relavent reservation to delete !");
                Optional<ButtonType> result2 = alert2.showAndWait();
            }


        }
        loadTables();

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        if(!txtCusId.getText().isEmpty() | !txtRoomId.getText().isEmpty() | dateOut.getValue()!=null | dateIN.getValue()!=null | !txtGuests.getText().isEmpty() ){
            String dateInSelection=dateIN.getValue().toString();
            String currentDate=getCurrentDate();

            int comparison=dateInSelection.compareTo(currentDate);

            if(comparison>=0){
                String dateOutSelection=dateOut.getValue().toString();
                int comparisonOfInandOut=dateOutSelection.compareTo(dateInSelection);
                if(comparisonOfInandOut>=0){
                    try {
                        String bookingStatus=reservationController.getReservation(tblReservation.getSelectionModel().getSelectedItem().getReservationId()).getBookingStatus();
                        if(!bookingStatus.equals("Cancelled")){
                            try {
                                String rst=reservationController.updateReservation(new ReservationDto(tblReservation.getSelectionModel().getSelectedItem().getReservationId(),Integer.parseInt(txtCusId.getText()),dateIN.getValue().toString(),dateOut.getValue().toString(),cmbBookingStatus.getValue(),txtRoomId.getText(),Integer.parseInt(txtGuests.getText()),getCurrentDate(),getCurrentTime()));
                                clear();
                                loadTables();
                                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                alert2.setContentText(rst);
                                Optional<ButtonType> result2 = alert2.showAndWait();
                            } catch (Exception e) {
                                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                                alert2.setContentText(e.getMessage());
                                Optional<ButtonType> result2 = alert2.showAndWait();

                            }

                        }else {
                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setTitle("Cancelled Booking!");
                            alert2.setContentText("Selected Reservation is already cancelled,can not Update!!");
                            Optional<ButtonType> result2 = alert2.showAndWait();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }else {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Check in date and check out date error !");
                    alert2.setContentText("Please select correct check in date and check out Date !");
                    Optional<ButtonType> result2 = alert2.showAndWait();
                }
            }else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Check in date Error !");
                alert2.setContentText("Please select correct check in date! afte the "+getCurrentDate());
                Optional<ButtonType> result2 = alert2.showAndWait();

            }
        }else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setContentText("Please Fill all the data !");
            Optional<ButtonType> result2 = alert2.showAndWait();
        }
        loadTables();

    }

    @FXML
    void cmbBookingStatusKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtGuests.requestFocus();
        }

    }

    @FXML
    void dateINKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            dateOut.requestFocus();
        }

    }

    @FXML
    void dateOutKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            cmbBookingStatus.requestFocus();
        }

    }

    @FXML
    void tblCustomerStatusMouseClicked(MouseEvent event) {
        if(tblCustomerStatus.getSelectionModel().getSelectedItem()!=null){
            int selectedCustomerId=tblCustomerStatus.getSelectionModel().getSelectedItem().getCustomerId();
            txtCusId.setText(Integer.toString(selectedCustomerId));
            try {
                String selectedCustomerName=customerController.getCustomrById(selectedCustomerId).getFirstName();
                String nic=customerController.getCustomrById(selectedCustomerId).getNicNo();
                lblCustomerName.setText(selectedCustomerName);
                lblCustomerNic.setText("Nic: "+nic);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else {

        }

    }
    @FXML
    void txtCustomerIdKeyTyped(KeyEvent event) {

    }
    @FXML
    void txtCustomerIdAction(ActionEvent event) {


    }

    @FXML
    void tblReservationMouseClicked(MouseEvent event) {
        ReservationDto rdto=tblReservation.getSelectionModel().getSelectedItem();
        txtCusId.setText(Integer.toString(rdto.getCustomerId()));
        txtRoomId.setText(rdto.getRoomNo());
        dateIN.setValue(LocalDate.parse(rdto.getInDate()));
        dateOut.setValue(LocalDate.parse(rdto.getOutDate()));
        txtGuests.setText(Integer.toString(rdto.getGuests()));



    }

    @FXML
    void tblRoomStatusMouseClicked(MouseEvent event) {

        if(tblRoomStatus.getSelectionModel().getSelectedItem().getStatus()!=null){
            String rst=tblRoomStatus.getSelectionModel().getSelectedItem().getStatus();
            if(rst.equals("Available") | rst.equals("Ready") ){
                txtRoomId.setText(tblRoomStatus.getSelectionModel().getSelectedItem().getRoomId());
                try {
                    String selectedRoomCategory=roomCategoryController.get(tblRoomStatus.getSelectionModel().getSelectedItem().getCatId()).getRoomCatName();
                    lblRoomCategory.setText(selectedRoomCategory);

                    Double selectedRoomCategoryCost=roomCategoryController.get(tblRoomStatus.getSelectionModel().getSelectedItem().getCatId()).getCostPerNight();
                    lblRoomCost.setText("Rs. "+Double.toString(selectedRoomCategoryCost));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }else {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                txtRoomId.setText("");
                lblRoomCategory.setText("");
                lblRoomCost.setText("");
                alert2.setTitle("Error !");
                alert2.setContentText("You can only Book -Available Room- Only...");
                Optional<ButtonType> result2 = alert2.showAndWait();
            }
        }else {
            System.out.println("not selected");
        }

    }

    @FXML
    void txtCustomerIdKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtRoomId.requestFocus();
        }

    }

    @FXML
    void txtGuestsKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            btnAdd.requestFocus();
        }

    }

    @FXML
    void txtRoomNoKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            dateIN.requestFocus();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomManagementController=new RoomManagementController();
        customerController=new CustomerController();
        roomCategoryController=new RoomCategoryController();
        reservationController=new ReservationController();
        ObservableList<String> status=FXCollections.observableArrayList();
        status.add("Full Board");
        status.add("Half Board");
        status.add("Bed and Breakfast");
        cmbBookingStatus.setItems(status);

        loadTables();
    }
    void loadTables(){
        ObservableList<RoomManagementDto> odtos= FXCollections.observableArrayList();
        ObservableList<CustomerDto> customerDtoObservableList=FXCollections.observableArrayList();
        ObservableList<ReservationDto> reservationDtos=FXCollections.observableArrayList();
        try {
            ArrayList<RoomManagementDto> dtos=roomManagementController.getAll();
            odtos.addAll(dtos);
            List<CustomerDto> customerDtos=customerController.getAllCustomer();
            customerDtoObservableList.addAll(customerDtos);
            ArrayList<ReservationDto> list=reservationController.getAll();
            reservationDtos.addAll(list);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colRoomIdRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getRoomId()));
        colCategoryRS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getCatId()).asObject());
        colStatusRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getStatus()));
        colBedsRS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getNoOfBeds()).asObject());

        tblRoomStatus.setItems(odtos);

        colCustomerIdCS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getCustomerId()).asObject());
        colNameCS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getFirstName()));
        colContatcNoCS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getContactNo()));
        tblCustomerStatus.setItems(customerDtoObservableList);

        colResId.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getReservationId()).asObject());
        colCusId.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getCustomerId()).asObject());
        colInDate.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getInDate()));
        colOutDate.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getOutDate()));
        colBookingStatus.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getBookingStatus()));
        colRoomNo.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getRoomNo()));
        colGuests.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getGuests()).asObject());
        colBookedDate.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getBookedDate()));
        colBookedTime.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getBookedTime()));
        tblReservation.setItems(reservationDtos);


    }
    void clear(){
        txtCusId.setText("");
        txtRoomId.setText("");
        dateIN.setValue(LocalDate.now());
        dateOut.setValue(LocalDate.now());
        cmbBookingStatus.setPromptText("Select Booking Status");
        txtGuests.setText("");
        lblRoomCost.setText("");
        lblRoomCategory.setText("");
        lblCustomerName.setText("");
        lblCustomerNic.setText("");

    }
}
