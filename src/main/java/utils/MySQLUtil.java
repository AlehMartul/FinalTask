package utils;

import aquality.selenium.browser.AqualityServices;

import java.sql.*;

public class MySQLUtil {

    private static Connection con;

    public static void connectToDataBase(String url, String user, String password) {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void makeQuery(String query) throws SQLException {
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException se) {
            {
                AqualityServices.getLogger().error(se.getMessage());
            }
        }

    }
}
