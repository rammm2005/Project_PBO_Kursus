/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rama Dev
 */
public class dbConnect {

    public static final Logger logger = Logger.getLogger(dbConnect.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/course_registration?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An SQL exception occurred", e);
            return null;
        }
    }

    public static void testConnection() {
        Connection conn = connect();
        if (conn != null) {
            System.out.println("Connected to the database successfully!");
            try {
                conn.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to close connection", e);
            }
        } else {
            System.out.println("Failed to connect to the database!");
        }
    }
}
