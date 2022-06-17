package com.george.wallet_desktop.database;

import com.george.wallet_desktop.model.Account;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class AccountHelperTest {

    @Test
    public void createAccount() {
        AccountHelper accountHelper = new AccountHelper();
        try(Connection connection = accountHelper.open()) {
            try(Statement statement = connection.createStatement()) {
                connection.setAutoCommit(false);

                // cleanup:
                statement.executeUpdate("DELETE FROM cash_account");

                // input parameters:
                String name = "money";
                String type = "bank card";
                int price = 60000;

                // Do the call:
                Account account = new Account(name, type, price);
                accountHelper.insertAccount(account);

                // Javabean Checks: Check the javabean contains the expected values:
                assertEquals(name, account.getName());
                assertEquals(type, account.getType());
                assertEquals(price, account.getPrice());

                try(ResultSet resultSet = statement.executeQuery("SELECT * FROM cash_account")) {
                    assertTrue(resultSet.next());
                    int id = resultSet.getInt("id");
                    assertEquals(name, resultSet.getString("name"));
                    assertEquals(type, resultSet.getString("type"));
                    assertEquals(price, resultSet.getInt("price"));

                    assertFalse(resultSet.next());
                }

            }

            finally {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
