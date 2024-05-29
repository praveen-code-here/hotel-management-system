package edu.ijse.lovers_leap.fxmlController;
import edu.ijse.lovers_leap.controller.LoginController;
import edu.ijse.lovers_leap.controller.ReceptionistController;
import edu.ijse.lovers_leap.dto.LoginDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class LoginControllerFxml extends Stage{
    private ReceptionistController receptionistController = new ReceptionistController();
    private LoginController loginController=new LoginController();

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserId;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtMobileNo;

    String getCurrentTime(){
        LocalTime time=LocalTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm:ss");
        String timetoString=time.format(formatter);
        return timetoString;

    }
    String getCurrentDate(){
        LocalDate date=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString =date.format(formatter);
        return dateString;
    }

    @FXML
    void btnSearchAction(ActionEvent event) {
        try {
            int id=receptionistController.getId(txtMobileNo.getText()).getReceptionistId();
            txtMobileNo.setText("");
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Please login with this user ID");
            alert2.setContentText("Your User Id ->" + id);
            Optional<ButtonType> result2 = alert2.showAndWait();


        } catch (Exception e) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error!");
            alert2.setContentText("Sorry,Incorrect mobile no! or Register as new Receptionist!");
            Optional<ButtonType> result2 = alert2.showAndWait();
        }

    }

    @FXML
    void btnLogin(ActionEvent event) {
        if ((txtPassword.getText().isEmpty()) | (txtUserId.getText().isEmpty())) {
            errorAlert.setTitle("Login Error");
            errorAlert.setContentText("Please Enter Valid User name & Password");
            Optional<ButtonType> result = errorAlert.showAndWait();
        } else {
            try {
                if (receptionistController.getReceptionist(Integer.parseInt(txtUserId.getText())).getPassword().equals(txtPassword.getText())) {
                    try {
                        String resp=loginController.saveLogin(new LoginDto(getCurrentTime(),getCurrentDate(),Integer.parseInt(txtUserId.getText())));
                        System.out.println(resp);


                        Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/home.fxml"));
                        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene1 = new Scene(root);
                        scene1.getStylesheets().add(getClass().getResource("/edu/ijse/lovers_leap/Style.css").toExternalForm());
                        stage1.setScene(scene1);

                        stage1.show();
                        stage1.centerOnScreen();
                        stage1.setResizable(false);
                        stage1.initStyle(StageStyle.UTILITY);




                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    errorAlert.setTitle("Login Error");
                    errorAlert.setContentText("Your Password or User Id is incorrect");
                    Optional<ButtonType> result = errorAlert.showAndWait();
                }
            } catch (Exception e) {
                errorAlert.setTitle("Login Error");
                errorAlert.setContentText("Your Password or User Id is incorrect");
                Optional<ButtonType> result = errorAlert.showAndWait();
            }
        }

    }

    @FXML
    void btnRegister(ActionEvent event) {
        try {
            Stage pStage=new Stage();
            pStage.initModality(Modality.APPLICATION_MODAL);
            Parent root=FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/Receptionist_Register.fxml"));
            pStage.setTitle("Register new Receptionist");
            pStage.setScene(new Scene(root,622,466));
            pStage.setResizable(false);
            //pStage.initStyle(StageStyle.TRANSPARENT);
            pStage.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void txtPasswordKeyPressAction(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            btnLogin.requestFocus();
        }

    }
    @FXML
    void txtMobileNoKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            btnSearch.requestFocus();
        }

    }

    @FXML
    void txtUserIDKeyPresses(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtPassword.requestFocus();
        }

    }
}
