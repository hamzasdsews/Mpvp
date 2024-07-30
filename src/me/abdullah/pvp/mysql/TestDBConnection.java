package me.abdullah.pvp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://bcwc7oywkqjydplfnkn7-mysql.services.clever-cloud.com:3306/bcwc7oywkqjydplfnkn7";
        String user = "uzetdbyfhvvzjbyp";
        String password = "D8fCbsiJewc0e8LFh40T";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            if (con != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database. Error: " + e.getMessage());
        }
    }
}