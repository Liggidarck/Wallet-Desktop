package com.george.wallet_desktop.database;

import com.george.wallet_desktop.model.ObligatoryPayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.george.wallet_desktop.util.Keys.DATABASE_LOCATION;

public class PaymentHelper {
    Connection connection;
    Statement statement;

    public void open() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_LOCATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPayment(ObligatoryPayment payment) {
        String name = payment.getName();
        String category = payment.getCategory();
        int price = payment.getPrice();
        String date = payment.getDate();
        String frequency = payment.getFrequency();

        String query = ("INSERT INTO obligatory_payments (name, category, price, date, frequency) " +
                "VALUES('%s', '%s', '%d', '%s', '%s');")
                .formatted(name, category, price, date, frequency);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
