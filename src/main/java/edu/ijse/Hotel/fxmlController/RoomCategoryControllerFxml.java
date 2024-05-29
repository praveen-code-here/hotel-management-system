package edu.ijse.lovers_leap.fxmlController;
import edu.ijse.lovers_leap.controller.RoomCategoryController;
import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import javafx.beans.property.SimpleDoubleProperty;
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

public class RoomCategoryControllerFxml implements Initializable {
    RoomCategoryController roomCategoryController = new RoomCategoryController();
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<RoomCategoryDto, Integer> colCategoryID;

    @FXML
    private TableColumn<RoomCategoryDto, String> colCategoryName;

    @FXML
    private TableColumn<RoomCategoryDto, Double> colCostPerNight;

    @FXML
    private TableColumn<RoomCategoryDto, String> colDescription;

    @FXML
    private TableView<RoomCategoryDto> tblRoomCategory;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextField txtCostPerNight;

    @FXML
    private TextArea txtDescription;

    @FXML
    void btnAddAction(ActionEvent event) {
        if ((!txtCategoryName.getText().isEmpty()) & (!txtCostPerNight.getText().isEmpty())) {
            try {
                String rsp = roomCategoryController.saveRoomCategory(new RoomCategoryDto(txtCategoryName.getText(), Double.parseDouble(txtCostPerNight.getText()), txtDescription.getText()));
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
                Optional<ButtonType> result = alert2.showAndWait();
            }
        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Submission Error!!");
            alert2.setContentText("All the text fields should not be EMPTY!");
            Optional<ButtonType> result = alert2.showAndWait();
        }

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
        if (result.get() == ButtonType.OK) {
            try {
                String resp = roomCategoryController.deleteRoomCategory(tblRoomCategory.getSelectionModel().getSelectedItem().getCatId());
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Submission Successful!");
                loadTable();
                clear();
                alert2.setContentText(resp);
                Optional<ButtonType> result2 = alert2.showAndWait();
            } catch (Exception e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error !");
                loadTable();
                clear();
                alert2.setContentText("Please select valid room category from the table");
                Optional<ButtonType> result2 = alert2.showAndWait();
            }

        }
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        if ((!txtCategoryName.getText().isEmpty()) & (!txtCostPerNight.getText().isEmpty())) {
            try {
                String rest=roomCategoryController.updateRoomCategory(new RoomCategoryDto(tblRoomCategory.getSelectionModel().getSelectedItem().getCatId(),txtCategoryName.getText(),Double.parseDouble(txtCostPerNight.getText()),txtDescription.getText()));
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Update Successful!");
                loadTable();
                clear();
                alert2.setContentText(rest);
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


    }

    @FXML
    void tblRoomCategoryMouseClicked(MouseEvent event) {
        if (tblRoomCategory.getSelectionModel().getSelectedItem() != null) {
            txtCategoryName.setText(tblRoomCategory.getSelectionModel().getSelectedItem().getRoomCatName());
            txtCostPerNight.setText(Double.toString(tblRoomCategory.getSelectionModel().getSelectedItem().getCostPerNight()));
            txtDescription.setText(tblRoomCategory.getSelectionModel().getSelectedItem().getDescription());
        } else {

        }

    }

    @FXML
    void txtCategoryNameKeyPressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtCostPerNight.requestFocus();
        }

    }

    @FXML
    void txtCostPerNightKeyPressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtDescription.requestFocus();
        }

    }

    @FXML
    void txtDescriptionKeyPressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnAdd.requestFocus();
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }
    void loadTable() {
        ObservableList<RoomCategoryDto> obList = FXCollections.observableArrayList();
        try {
            ArrayList<RoomCategoryDto> rDto = roomCategoryController.getAll();

            obList.addAll(rDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colCategoryID.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCatId()).asObject());
        colCategoryName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRoomCatName()));
        colCostPerNight.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getCostPerNight()).asObject());
        colDescription.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
        tblRoomCategory.setItems(obList);

    }

    void clear() {
        txtCategoryName.setText("");
        txtCostPerNight.setText("");
        txtDescription.setText("");
        txtCategoryName.requestFocus();
    }
}
