module com.example.gerenciamentodeparque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gerenciamentodeparque to javafx.fxml;
    exports com.example.gerenciamentodeparque;
}