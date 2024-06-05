/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public static boolean addPackage(String packageName, String deskripsi, InputStream image) {
        String sql = "INSERT INTO packages(name, deskripsi, image) VALUES(?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, packageName);
            pstmt.setString(2, deskripsi);
            pstmt.setBinaryStream(3, image);
            int rowsAffected = pstmt.executeUpdate(); // Mengembalikan jumlah baris yang terpengaruh oleh perintah SQL
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Package added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add package!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add package", e);
            JOptionPane.showMessageDialog(null, "Failed to add package! See logs for details.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean editPackage(int id, String packageName, String deskripsi) {
        String sql = "UPDATE packages SET name = ?, deskripsi = ? WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, packageName);
            pstmt.setString(2, deskripsi);
            pstmt.setInt(3, id);
            int rowsAffected = pstmt.executeUpdate(); // Mengembalikan jumlah baris yang terpengaruh oleh perintah SQL
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to update package", e);
            return false;
        }
    }

    public static boolean deletePackage(int id) {
        String sql = "DELETE FROM packages WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to Delete package", e);
            return false;
        }

    }

//    public static void selectPackage(String packageName) {
//        String sql = "SELECT * FROM packages ORDER BY DESC";
//
//        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                String id = rs.getString("id");
//                String name = rs.getString("name");
//            } else {
//                System.out.println("Package not found!");
//            }
//
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Failed to select package", e);
//        }
//    }
    public static void addMaterial(int packageId, String title, String content) {
        String sql = "INSERT INTO materials(package_id, title, content) VALUES(?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, packageId);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.executeUpdate();
            System.out.println("Material added successfully!");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add material", e);
        }
    }

    public static void addQuiz(int packageId, String question, String answer, String options) {
        String sql = "INSERT INTO quizzes(package_id, question, answer, options) VALUES(?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, packageId);
            pstmt.setString(2, question);
            pstmt.setString(3, answer);
            pstmt.setString(4, options);
            pstmt.executeUpdate();
            System.out.println("Quiz added successfully!");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to add quiz", e);
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
