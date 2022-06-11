package com.george.wallet_desktop.view;

import com.george.wallet_desktop.WalletApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeView extends AnchorPane {
    public HomeView() {
        FXMLLoader fxmlLoader = new FXMLLoader(WalletApplication.class.getResource("home-view.fxml"));


        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
