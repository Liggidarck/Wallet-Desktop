module com.george.wallet_desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;

    opens com.george.wallet_desktop to javafx.fxml;
    exports com.george.wallet_desktop;
    exports com.george.wallet_desktop.controller;
    opens com.george.wallet_desktop.controller to javafx.fxml;
}