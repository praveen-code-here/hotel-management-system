package edu.ijse.lovers_leap.fxmlController;
// #1D59A0
import edu.ijse.lovers_leap.controller.ReceptionistController;
import edu.ijse.lovers_leap.dto.ReceptionistsDto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReceptionistsRegisterControllerFxml extends Stage implements Initializable {

    private ReceptionistController receptionistController;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<String> cmbHotelId;

    @FXML
    private ComboBox<String> cmbPosition;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtContatcNo;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnBack;



    @FXML
    void btnSubmitActionPerformed(ActionEvent event) {
        if ((!txtPassword.getText().isEmpty()) & (!txtContatcNo.getText().isEmpty())) {
            try {

                ReceptionistsDto receptionistsDto = new ReceptionistsDto(
                        txtFirstName.getText(),
                        txtLastName.getText(),
                        Integer.parseInt(txtAge.getText()),
                        txtContatcNo.getText(),
                        cmbPosition.getValue(),
                        cmbHotelId.getValue().equals("1] Hotel Lovers Leap") ? 1 : 2,
                        txtPassword.getText());

                String resp = null;
                try {
                    resp = receptionistController.save(receptionistsDto);
                    System.out.println(resp);

                    if (resp != null) {
                        try {
                            int userID = receptionistController.getId(txtContatcNo.getText()).getReceptionistId();
                            System.out.println(userID);

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Successfully Registered!!");
                            alert.setContentText("Your Login Id --->  " + userID);
                            Optional<ButtonType> result = alert.showAndWait();

//                            root = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/login.fxml"));
//                            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//                            scene = new Scene(root);
//                            stage.setScene(scene);
//                            stage.show();

//
//                    if(result.isEmpty()){
//                        System.out.println("Alert closed");
//                    } else if(result.get() == ButtonType.OK){
//                        System.out.println("OK!");
//                    } else if(result.get() == ButtonType.CANCEL){
//                        System.out.println("Never!");
//                    }


                        } catch (Exception e) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Submission Error!!");
                            String error = String.valueOf(e);
                            alert.setContentText(error);
                            Optional<ButtonType> result = alert.showAndWait();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Submission Error!!");
                        alert.setContentText("Please Check your Enterd Data...");
                        Optional<ButtonType> result = alert.showAndWait();
                    }
                } catch (Exception e) {

                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Submission Error!!");
                    alert2.setContentText(e.getMessage());
                    Optional<ButtonType> result = alert2.showAndWait();

                }
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Submission Error!!");
                alert2.setContentText("Please enter Valid Data..." + e.getMessage());
                Optional<ButtonType> result = alert2.showAndWait();
            }
        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Submission Error!!");
            String error = String.valueOf("Please Contatc No & Password should not be EMPTY");
            alert2.setContentText("Please enter Valid Data...");
            Optional<ButtonType> result = alert2.showAndWait();
        }


    }

    @FXML
    void cmbHotelIdKeyPress(KeyEvent event) {
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
    void txtAgeKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtContatcNo.requestFocus();
        }

    }

    @FXML
    void txtContatcNoKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbPosition.requestFocus();
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
            btnSubmit.requestFocus();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbHotelId.setItems(FXCollections.observableArrayList("1] Hotel Lovers Leap", "2] Hotel Grand Royal"));
        cmbPosition.setItems(FXCollections.observableArrayList("Junior Receptionist", "Senior Receptionist"));
    }

    public ReceptionistsRegisterControllerFxml() {
        receptionistController = new ReceptionistController();
    }
}
