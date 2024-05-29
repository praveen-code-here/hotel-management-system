package edu.ijse.lovers_leap.fxmlController;

import edu.ijse.lovers_leap.controller.HotelDetailController;
import edu.ijse.lovers_leap.controller.ReceptionistController;
import edu.ijse.lovers_leap.dto.HotelDto;
import edu.ijse.lovers_leap.dto.ReceptionistsDto;
import javafx.beans.binding.Bindings;
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

public class MainReceptionistRegisterControllerFxml implements Initializable {
    ReceptionistController receptionistController;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearchReceiptionist;

    @FXML
    private ToggleButton btnToggleShowPassword;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbHotelId;

    @FXML
    private ComboBox<String> cmbPosition;

    @FXML
    private TableColumn<ReceptionistsDto, Integer> colAge;

    @FXML
    private TableColumn<ReceptionistsDto, String> colContatcNo;

    @FXML
    private TableColumn<ReceptionistsDto, Integer> colHotelId;

    @FXML
    private TableColumn<ReceptionistsDto, Integer> colID;

    @FXML
    private TableColumn<ReceptionistsDto, String> colName;

    @FXML
    private TableColumn<ReceptionistsDto, String> colPosition;

    @FXML
    private Label lblGetReceiptionistID;

    @FXML
    private Label lblShowAge;

    @FXML
    private Label lblShowContatcNo;

    @FXML
    private Label lblShowHotelId;

    @FXML
    private Label lblShowID;

    @FXML
    private Label lblShowName;

    @FXML
    private Label lblshowPassword;

    @FXML
    private TableView<ReceptionistsDto> tblShowReceiptionist;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtContatcNo;

    @FXML
    private TextField txtEnterContatcNo;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnAddReceiptionistAction(ActionEvent event) {
        if ((!txtPassword.getText().isEmpty()) & (!txtContatcNo.getText().isEmpty()) & (!txtFirstName.getText().isEmpty())) {
            ReceptionistsDto receptionistsDto = new ReceptionistsDto(txtFirstName.getText(),
                    txtLastName.getText(),
                    Integer.parseInt(txtAge.getText()),
                    txtContatcNo.getText(),
                    cmbPosition.getValue(),
                    cmbHotelId.getValue().equals("1] Hotel Lovers Leap") ? 1 : 2,
                    txtPassword.getText());
            try {
                String rsp = receptionistController.save(receptionistsDto);
                clear();
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Successfully Added ");
                alert2.setContentText(rsp);
                Optional<ButtonType> result = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Submission Error!!");
                alert2.setContentText("Unable to Save the Receptionist! " + e.getMessage());
                Optional<ButtonType> result = alert2.showAndWait();
            }

        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Submission Error!!");
            alert2.setContentText("All the text fields should not be EMPTY!");
            Optional<ButtonType> result = alert2.showAndWait();
        }
        showReceptionist();
    }

    @FXML
    void btnClearAction(ActionEvent event) {
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
                String result2 = receptionistController.deleteReceptionist(Integer.parseInt(lblGetReceiptionistID.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Deleted");
                alert.setContentText(result2);
                showReceptionist();
                clear();
                Optional<ButtonType> r = alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
                alert.setContentText("Fail to delete the customer" + e.getMessage());
                Optional<ButtonType> result3 = alert.showAndWait();
            }
        }

    }

    @FXML
    void btnSearchReceptionistAction(ActionEvent event) {
        try {
            ReceptionistsDto dto = receptionistController.getId(txtEnterContatcNo.getText());
            if (dto != null) {
                lblShowID.setText(Integer.toString(dto.getReceptionistId()));
                lblShowName.setText(dto.getFirstName());
                lblShowAge.setText(Integer.toString(dto.getAge()));
                lblShowContatcNo.setText(dto.getContactNo());
                lblShowHotelId.setText(Integer.toString(dto.getHotelId()));
            } else {
                lblShowID.setText("");
                lblShowName.setText("");
                lblShowAge.setText("");
                lblShowContatcNo.setText("");
                lblShowHotelId.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("Not found any Receptionist");
                Optional<ButtonType> result = alert.showAndWait();

            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Not found any Receptionist");
            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    @FXML
    void btnToggleShowPasswordAction(ActionEvent event) {
        if(btnToggleShowPassword.isSelected()){
            lblshowPassword.setVisible(true);
            lblshowPassword.textProperty().bind(Bindings.concat(txtPassword.getText()));
            btnToggleShowPassword.setText("Hide");
        }else {
            lblshowPassword.setVisible(false);
            btnToggleShowPassword.setText("Show");
        }

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        if ((!txtPassword.getText().isEmpty()) & (!txtContatcNo.getText().isEmpty()) & (!txtFirstName.getText().isEmpty())) {
            ReceptionistsDto receptionistsDto = new ReceptionistsDto(Integer.parseInt(lblGetReceiptionistID.getText()),
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    Integer.parseInt(txtAge.getText()),
                    txtContatcNo.getText(),
                    cmbPosition.getValue(),
                    cmbHotelId.getValue().equals("1] Hotel Lovers Leap") ? 1 : 2,
                    txtPassword.getText());
            try {
                String rsp = receptionistController.UpdateReceptionist(receptionistsDto);
                clear();
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Successfully Updated ");
                alert2.setContentText(rsp);
                showReceptionist();
                clear();
                Optional<ButtonType> result = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Update Error!!");
                alert2.setContentText("Unable to update the Receptionist! " + e.getMessage());
                Optional<ButtonType> result = alert2.showAndWait();
            }
        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Submission Error!!");
            alert2.setContentText("All the text fields should not be EMPTY!");
            Optional<ButtonType> result = alert2.showAndWait();
        }

    }
    public void clear() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        txtContatcNo.setText("");
        txtPassword.setText("");
    }

    @FXML
    void cmbHotelIDKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtPassword.requestFocus();
        }
    }

    @FXML
    void cmbPositionKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbHotelId.requestFocus();
        }
    }

    @FXML
    void tblShowReceiptionistMouseClick(MouseEvent event) {
        ReceptionistsDto r=tblShowReceiptionist.getSelectionModel().getSelectedItem();
        if(r!=null){
            lblGetReceiptionistID.setText(Integer.toString(r.getReceptionistId()));
            txtFirstName.setText(r.getFirstName());
            txtLastName.setText(r.getLastName());
            txtAge.setText(Integer.toString(r.getAge()));
            txtContatcNo.setText(r.getContactNo());
            txtPassword.setText(r.getPassword());
            cmbPosition.setPromptText(r.getPosition());
        }
    }
    void showReceptionist() {
        ObservableList<ReceptionistsDto> list = FXCollections.observableArrayList();
        try {
            list.addAll(receptionistController.getAllCustomers());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colID.setCellValueFactory(celData -> new SimpleIntegerProperty(celData.getValue().getReceptionistId()).asObject());
        colName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFirstName()));
        colAge.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getAge()).asObject());
        colContatcNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getContactNo()));
        colPosition.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPosition()));
        colHotelId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getHotelId()).asObject());

        tblShowReceiptionist.setItems(list);
    }
    public MainReceptionistRegisterControllerFxml() {
        receptionistController = new ReceptionistController();
    }

    @FXML
    void txtAgeKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtContatcNo.requestFocus();
        }
    }

    @FXML
    void txtContactNoKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbPosition.requestFocus();
        }
    }

    @FXML
    void txtEnterContactNoKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnSearchReceiptionist.requestFocus();
        }
    }

    @FXML
    void txtFirstNameKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {

            txtLastName.requestFocus();
        }
    }

    @FXML
    void txtLastNameKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtAge.requestFocus();
        }
    }

    @FXML
    void txtPasswordKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnAdd.requestFocus();
        }
        lblshowPassword.textProperty().bind(Bindings.concat(txtPassword.getText()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbPosition.setItems(FXCollections.observableArrayList("Junior Receptionist", "Senior Receptionist"));
        showReceptionist();
        loadHotelComboBox();
        lblshowPassword.setVisible(false);

    }
    void loadHotelComboBox() {
        HotelDetailController hotelDetailController = new HotelDetailController();
        try {
            ArrayList<String> hotels = new ArrayList<>();
            ArrayList<HotelDto> hDtos = hotelDetailController.getAll();
            for (HotelDto h : hDtos) {
                hotels.add(h.getName());
            }

            ObservableList<String> olist = FXCollections.observableArrayList();
            olist.addAll(hotels);
            cmbHotelId.setItems(olist);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
