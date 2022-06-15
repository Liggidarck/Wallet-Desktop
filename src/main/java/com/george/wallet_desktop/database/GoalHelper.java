package com.george.wallet_desktop.database;

import com.george.wallet_desktop.model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.george.wallet_desktop.util.Keys.DATABASE_LOCATION;

public class GoalHelper {
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

    public void insertAccount(Account account) {
        String name = account.getName();
        String type = account.getType();
        int price = account.getPrice();

        String query = ("INSERT INTO goals (name, type, price) " + "" +
                "VALUES('%s', '%s', '%s');").formatted(name, type, price);

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
            e.printStackTrace();
        }
    }

}