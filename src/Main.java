
import dbConnect.dbConnect;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rama Dev
 */
public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomePage welcome = new WelcomePage();
            }
        });

//        Connection connection = dbConnect.connect();
//        if (connection != null) {
//            System.out.println("Connection successful!");
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Connection failed!");
//        }
    }

}
