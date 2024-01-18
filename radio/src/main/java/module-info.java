module com.radio {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.radio to javafx.fxml;
    exports com.radio;
}
