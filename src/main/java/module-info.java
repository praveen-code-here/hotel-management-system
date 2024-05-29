module edu.ijse.lovers_leap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens edu.ijse.lovers_leap to javafx.fxml;
    exports edu.ijse.lovers_leap;
    exports edu.ijse.lovers_leap.fxmlController;
    opens edu.ijse.lovers_leap.fxmlController to javafx.fxml;
}