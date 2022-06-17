package com.george.wallet_desktop.database;

import com.george.wallet_desktop.model.Account;
import com.george.wallet_desktop.model.Goal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.george.wallet_desktop.util.Keys.DATABASE_LOCATION;

public class GoalHelper {
    Connection connection;
    Statement statement;

    public Connection open() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_LOCATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertGoal(Goal goal) {
        String name = goal.getName();
        int goalPrice = goal.getGoalPrice();
        int defaultPrice = goal.getDefaultPrice();
        String dateGoal = goal.getDateGoal();
        String color = goal.getColor();

        String query = ("INSERT INTO goals (name, goal_price, default_price, date_goal, color) " + "" +
                "VALUES('%s', '%s', '%s', '%s', '%s');").formatted(name, goalPrice, defaultPrice, dateGoal, color);

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