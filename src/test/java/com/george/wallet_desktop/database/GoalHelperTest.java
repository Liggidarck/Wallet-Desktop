package com.george.wallet_desktop.database;

import com.george.wallet_desktop.model.Goal;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class GoalHelperTest {

    @Test
    public void createGoal() {
        GoalHelper goalHelper = new GoalHelper();

        try(Connection connection = goalHelper.open()) {
            try(Statement connectionStatement = connection.createStatement()) {
                connection.setAutoCommit(false);

                // Initial cleanup:
                connectionStatement.executeUpdate("DELETE FROM goals");

                // Setting input parameters:
                String name = "Поездка";
                int goalPrice = 60000;
                int defaultPrice = 0;
                String dateGoal = "15.06.2023";
                String color = "RED";

                // Do the call:
                Goal goal = new Goal(name, goalPrice, defaultPrice, dateGoal, color);
                goalHelper.insertGoal(goal);

                // Javabean Checks: Check the javabean contains the expected values:
                assertEquals(name, goal.getName());
                assertEquals(goalPrice, goal.getGoalPrice());
                assertEquals(defaultPrice, goal.getDefaultPrice());
                assertEquals(dateGoal, goal.getDateGoal());
                assertEquals(color, goal.getColor());

                // Database Checks:
                int id;
                // Check the goal table contains one row with the expected values:
                try(ResultSet resultSet = connectionStatement.executeQuery("SELECT * FROM goals")) {
                    assertTrue(resultSet.next());

                    id = resultSet.getInt("id");
                    assertEquals(name, resultSet.getString("name"));
                    assertEquals(goalPrice, resultSet.getInt("goal_price"));
                    assertEquals(defaultPrice, resultSet.getInt("default_price"));
                    assertEquals(dateGoal, resultSet.getString("date_goal"));
                    assertEquals(color, resultSet.getString("color"));
                    System.out.println(resultSet.getString("name"));

                    assertFalse(resultSet.next());
                }

            }

            finally {
                // Undo the testing operations:
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
