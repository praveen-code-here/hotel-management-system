package edu.ijse.lovers_leap.fxmlController;
import edu.ijse.lovers_leap.controller.HotelDetailController;
import edu.ijse.lovers_leap.controller.RoomCategoryController;
import edu.ijse.lovers_leap.controller.RoomManagementController;
import edu.ijse.lovers_leap.dto.HotelDto;
import edu.ijse.lovers_leap.dto.RoomCategoryDto;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class RoomManagementControllerFxml implements Initializable {
    RoomManagementController roomManagementController;
    RoomCategoryController roomCategoryController;
    HotelDetailController hotelDetailController;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private ComboBox<String> cmbHotel;

    @FXML
    private ComboBox<String> cmbStatus;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colCategoryName;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colHotelName;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colNoOfBeds;

    @FXML
    private TableColumn<RoomManagementDto, String> colRoomNo;

    @FXML
    private TableColumn<RoomManagementDto, String> colStatus;

    @FXML
    private TableView<RoomManagementDto> tblRooms;

    @FXML
    private TextField txtNoOfBeds;

    @FXML
    private TextField txtRoomNo;

    @FXML
    void btnAddReceiptionistAction(ActionEvent event) {
        if ((!txtRoomNo.getText().isEmpty()) & (!txtNoOfBeds.getText().isEmpty()) & (cmbStatus.getValue()!=null) & (cmbHotel.getValue()!=null)){
            try {
                int tempCatId=roomCategoryController.getIdByStringName(cmbCategory.getValue()).getFirst().getCatId();

                int tempHId=hotelDetailController.getHotelByStringName(cmbHotel.getValue()).getFirst().getHotelId();

                String rsp=roomManagementController.addRoom(new RoomManagementDto(txtRoomNo.getText(),tempCatId,tempHId,Integer.parseInt(txtNoOfBeds.getText()),cmbStatus.getValue()));
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Submission Successful!");
                loadTable();
                clear();
                alert2.setContentText(rsp);
                Optional<ButtonType> result = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Submission Error!!");
                alert2.setContentText(e.getMessage());
                System.out.println(e);
                Optional<ButtonType> result = alert2.showAndWait();
            }
        }else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Submission Error!!");
            alert2.setContentText("All the text fields should not be EMPTY!");
            Optional<ButtonType> result = alert2.showAndWait();
        }

    }
    void loadComboBox(){
        ObservableList<String> cmbCat= FXCollections.observableArrayList();
        try {
            ArrayList<RoomCategoryDto> roomCategoryDtos =roomCategoryController.getAll();
            for(RoomCategoryDto dto:roomCategoryDtos){
                cmbCat.addAll(dto.getRoomCatName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cmbCategory.setItems(cmbCat);

        ObservableList<String> cmbHot=FXCollections.observableArrayList();
        try {
            ArrayList<HotelDto> hotelDtos=hotelDetailController.getAll();
            for(HotelDto hotelDto:hotelDtos){
                cmbHot.add(hotelDto.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cmbHotel.setItems(cmbHot);
        ObservableList<String> list= FXCollections.observableArrayList();
        list.add("Ready");
        //list.add("Booked");
        list.add("Under Maintenance");
        list.add("Under Preparation");

        cmbStatus.setItems(list);
    }
    void loadTable(){
        ObservableList<RoomManagementDto> obList=FXCollections.observableArrayList();
        try {
            ArrayList<RoomManagementDto> rmDtos=roomManagementController.getAll();
            obList.addAll(rmDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colRoomNo.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getRoomId()));
        colCategoryName.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getCatId()).asObject());
        colHotelName.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getHotelId()).asObject());
        colNoOfBeds.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getNoOfBeds()).asObject());
        colStatus.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getStatus()));
        tblRooms.setItems(obList);
    }

    @FXML
    void btnClearAction(ActionEvent event) {
        clear();
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
       if(!tblRooms.getSelectionModel().getSelectedItem().getStatus().equals("Booked")){
           Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
           alert1.setTitle("Are You Sure ?");
           alert1.setContentText("Your Data will be permanently delete ! ");
           Optional<ButtonType> result = alert1.showAndWait();
           if (result.get() == ButtonType.OK) {
               try {
                   String resp = roomManagementController.deleteRoom(tblRooms.getSelectionModel().getSelectedItem().getRoomId());
                   Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                   alert2.setTitle("Delete Successful!");
                   loadTable();
                   clear();
                   alert2.setContentText(resp);
                   Optional<ButtonType> result2 = alert2.showAndWait();
               } catch (Exception e) {
                   Alert alert2 = new Alert(Alert.AlertType.ERROR);
                   alert2.setTitle("Error !");
                   loadTable();
                   clear();
                   alert2.setContentText(e.getMessage());
                   Optional<ButtonType> result2 = alert2.showAndWait();
               }

           }
       }else {
           Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
           alert1.setTitle("Booked Room");
           alert1.setContentText("You can not Delete Booked Rooms!");
           Optional<ButtonType> result = alert1.showAndWait();
       }

    }
    @FXML
    void tblMouseClickAction(MouseEvent event) {
        RoomManagementDto select = tblRooms.getSelectionModel().getSelectedItem();
        if(select!=null) {
            txtRoomNo.setText(select.getRoomId());
            txtNoOfBeds.setText(Integer.toString(select.getNoOfBeds()));
            cmbStatus.setPromptText(select.getStatus());
            try {
                String hotel=hotelDetailController.getHotelbyID(select.getHotelId()).getName();
                System.out.println(hotel);
                cmbHotel.setPromptText(hotel);
                String category=roomCategoryController.get(select.getCatId()).getRoomCatName();
                System.out.println(category);
                cmbCategory.setPromptText(category);
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error !");
                alert2.setContentText(e.getMessage());
                Optional<ButtonType> result2 = alert2.showAndWait();
            }

        }

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        if(!tblRooms.getSelectionModel().getSelectedItem().getStatus().equals("Booked")) {
            if ((!txtRoomNo.getText().isEmpty()) & (!txtNoOfBeds.getText().isEmpty()) & (cmbStatus.getValue() != null) & (cmbHotel.getValue() != null)) {
                try {
                    int tempCatId = roomCategoryController.getIdByStringName(cmbCategory.getValue()).getFirst().getCatId();

                    int tempHId = hotelDetailController.getHotelByStringName(cmbHotel.getValue()).getFirst().getHotelId();

                    String rsp = roomManagementController.updateRoom(new RoomManagementDto(txtRoomNo.getText(), tempCatId, tempHId, Integer.parseInt(txtNoOfBeds.getText()), cmbStatus.getValue()));
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Update Successful!");
                    loadTable();
                    clear();
                    alert2.setContentText(rsp);
                    Optional<ButtonType> result = alert2.showAndWait();
                } catch (Exception e) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Fail!");
                    loadTable();
                    clear();
                    alert2.setContentText(e.getMessage());
                    Optional<ButtonType> result = alert2.showAndWait();
                }

            } else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Submission Error!!");
                alert2.setContentText("All the text fields should not be EMPTY!");
                Optional<ButtonType> result = alert2.showAndWait();
            }
        }else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Booked Room");
            alert1.setContentText("You can not Update Booked Rooms!");
            Optional<ButtonType> result = alert1.showAndWait();
        }
    }

    @FXML
    void cmbCategoryKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbHotel.requestFocus();
        }

    }

    @FXML
    void cmbHotelKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtNoOfBeds.requestFocus();
        }

    }

    @FXML
    void cmbStatusKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnAdd.requestFocus();
        }

    }

    @FXML
    void txtNoOfBedsKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbStatus.requestFocus();
        }

    }

    @FXML
    void txtRoomNoKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbCategory.requestFocus();
        }


    }
    void clear(){
        txtRoomNo.setText("");
        cmbCategory.setPromptText("Select Room Category");
        cmbHotel.setPromptText("Select Hotel");
        txtNoOfBeds.setText("");
        cmbStatus.setPromptText("Select Room Status");
        txtRoomNo.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomManagementController=new RoomManagementController();
        roomCategoryController=new RoomCategoryController();
        hotelDetailController=new HotelDetailController();
        loadComboBox();
        loadTable();

    }
}
