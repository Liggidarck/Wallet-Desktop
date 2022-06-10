module com.george.wallet_desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.george.wallet_desktop to javafx.fxml;
    exports com.george.wallet_desktop;
    exports com.george.wallet_desktop.controller;
    opens com.george.wallet_desktop.controller to javafx.fxml;
    exports com.george.wallet_desktop.view;
    opens com.george.wallet_desktop.view to javafx.fxml;
}