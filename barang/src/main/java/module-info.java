module uas.revo {
    requires javafx.controls;
    requires javafx.fxml;

    opens uas.revo to javafx.fxml;
    exports uas.revo;
}
