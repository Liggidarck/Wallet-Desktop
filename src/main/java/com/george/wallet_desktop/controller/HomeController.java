package com.george.wallet_desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;

public class HomeController {
    @FXML
    public PieChart ObligatoryPaymentsChart;
    @FXML
    public LineChart TrendLineChart;

    @FXML
    private void initialize() {

        PieChart.Data slice1 = new PieChart.Data("Аренда", 20000);
        PieChart.Data slice2 = new PieChart.Data("ЖКХ", 5000);
        PieChart.Data slice3 = new PieChart.Data("Домашний интернет", 550);
        PieChart.Data slice4 = new PieChart.Data("Мобильный интернет", 760);
        PieChart.Data slice5 = new PieChart.Data("Остальное", 1300);


        ObligatoryPaymentsChart.getData().add(slice1);
        ObligatoryPaymentsChart.getData().add(slice2);
        ObligatoryPaymentsChart.getData().add(slice3);
        ObligatoryPaymentsChart.getData().add(slice4);
        ObligatoryPaymentsChart.getData().add(slice5);
    }
}
