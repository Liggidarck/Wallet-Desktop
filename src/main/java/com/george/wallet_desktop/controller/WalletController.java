package com.george.wallet_desktop.controller;

import com.george.wallet_desktop.WalletApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class WalletController {
    @FXML
    public BorderPane mainContainer;

    @FXML
    private void showHomeView() {
        loadFXML(WalletApplication.class.getResource("home-view.fxml"));
    }

    private void loadFXML(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            mainContainer.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}