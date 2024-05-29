package edu.ijse.lovers_leap.fxmlController;
import edu.ijse.lovers_leap.controller.HotelDetailController;
import edu.ijse.lovers_leap.controller.LoginController;
import edu.ijse.lovers_leap.controller.ReceptionistController;
import edu.ijse.lovers_leap.dto.HotelDto;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class HotelDetailsControllerFxml implements Initializable {
    HotelDetailController hotelDetailController;
    ReceptionistController receptionistController;


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<HotelDto, String> colAddress;

    @FXML
    private TableColumn<HotelDto, String> colContatcNo;

    @FXML
    private TableColumn<HotelDto, String> colDistrict;

    @FXML
    private TableColumn<HotelDto, Integer> colHotelID;

    @FXML
    private TableColumn<HotelDto, String> colName;

    @FXML
    private Label lblGetHotelId;

    @FXML
    private TableView<HotelDto> tblShowHotels;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContatcNo;

    @FXML
    private TextField txtDistrict;

    @FXML
    private TextField txtHotelName;
    @FXML
    private Label lblShowReceiptionistName;
    public HotelDetailsControllerFxml() {
        hotelDetailController = new HotelDetailController();
        receptionistController=new ReceptionistController();

    }

    @FXML
    void btnAddAction(ActionEvent event) {
        if ((!txtHotelName.getText().isEmpty()) & (!txtAddress.getText().isEmpty()) & (!txtContatcNo.getText().isEmpty())) {
            HotelDto hotelDto = new HotelDto(txtHotelName.getText(), txtAddress.getText(), txtDistrict.getText(), txtContatcNo.getText());
            try {
                String resp = hotelDetailController.addHotel(hotelDto);
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Submission Successful!");
                alert2.setContentText(resp);
                Optional<ButtonType> result = alert2.showAndWait();

            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Submission Error!!");
                alert2.setContentText(e.getMessage());
                Optional<ButtonType> result = alert2.showAndWait();
            }

        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Submission Error!!");
            alert2.setContentText("All the text fields should not be EMPTY!");
            Optional<ButtonType> result = alert2.showAndWait();
        }
        showHotels();
        clear();

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
                String resp = hotelDetailController.deleteHotel(Integer.parseInt(lblGetHotelId.getText()));
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Delete Successful!");
                alert2.setContentText(resp);
                Optional<ButtonType> result2 = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Delete Error!!");
                alert2.setContentText("Unable to Delete this hotel due to use of another field....");
                Optional<ButtonType> result2 = alert2.showAndWait();
            }
        }
        showHotels();
        clear();

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        if ((!txtHotelName.getText().isEmpty()) & (!txtAddress.getText().isEmpty()) & (!txtContatcNo.getText().isEmpty())) {
            HotelDto hDto = new HotelDto(Integer.parseInt(lblGetHotelId.getText()), txtHotelName.getText(), txtAddress.getText(), txtDistrict.getText(), txtContatcNo.getText());
            try {
                String resp = hotelDetailController.UpdateHotelDetails(hDto);
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Update Successful!");
                alert2.setContentText(resp);
                clear();
                Optional<ButtonType> result = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Update Error!!");
                alert2.setContentText(e.getMessage());
                Optional<ButtonType> result = alert2.showAndWait();
            }
        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Update Error!!");
            alert2.setContentText("All the text fields should not be EMPTY!");
            Optional<ButtonType> result = alert2.showAndWait();
        }
        showHotels();



    }

    @FXML
    void tblShowHotelMouseClicked(MouseEvent event) {
        HotelDto selectedHotel = tblShowHotels.getSelectionModel().getSelectedItem();
        if(selectedHotel!=null) {
            lblGetHotelId.setText(Integer.toString(selectedHotel.getHotelId()));
            txtHotelName.setText(selectedHotel.getName());
            txtAddress.setText(selectedHotel.getAddress());
            txtDistrict.setText(selectedHotel.getDistrict());
            txtContatcNo.setText(selectedHotel.getContactNo());
        }

    }

    @FXML
    void tblShowHotelsAction(ActionEvent event) {

    }

    @FXML
    void txtAddressKeyPressed(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtDistrict.requestFocus();
        }


    }

    @FXML
    void txtContactNoKeyPressed(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnAdd.requestFocus();
        }

    }

    @FXML
    void txtDistrictKeyPressed(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtContatcNo.requestFocus();
        }

    }

    @FXML
    void txtHotelNameKeyPressed(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtAddress.requestFocus();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHotels();
    }
    public void clear(){
        txtHotelName.setText("");
        txtAddress.setText("");
        txtDistrict.setText("");
        txtContatcNo.setText("");
    }



    public ObservableList<HotelDto> getHotelList() {
        ObservableList<HotelDto> hotelList = FXCollections.observableArrayList();
        try {
            ArrayList<HotelDto> hotelArray = hotelDetailController.getAll();
            for (HotelDto hdto : hotelArray) {
                hotelList.add(hdto);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hotelList;
    }

    public void showHotels() {
        ObservableList<HotelDto> list = getHotelList();
        colHotelID.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHotelId()).asObject());
        colName.setCellValueFactory(celData -> new SimpleStringProperty(celData.getValue().getName()));
        colAddress.setCellValueFactory(celData -> new SimpleStringProperty(celData.getValue().getAddress()));
        colDistrict.setCellValueFactory(clData -> new SimpleStringProperty(clData.getValue().getDistrict()));
        colContatcNo.setCellValueFactory(celData -> new SimpleStringProperty(celData.getValue().getContactNo()));
        tblShowHotels.setItems(list);
    }
}
