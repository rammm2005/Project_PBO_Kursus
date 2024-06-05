
import User.Auth.UserSession;
import User.Pages.Dashboard;
import dbConnect.dbConnect;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
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

    private static final String PREFS_KEY_LOGGED_IN_USER = "loggedInUser";
    private static Dashboard dashboard;

    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);

        String loggedInUser = prefs.get(PREFS_KEY_LOGGED_IN_USER, null);
        if (loggedInUser != null) {
            openDashboardPage(loggedInUser);
        } else {
            openWelcomePage();
        }
    }

    private static void openWelcomePage() {
        SwingUtilities.invokeLater(() -> {
            WelcomePage welcome = new WelcomePage();
            dbConnect.testConnection();
        });
    }

    private static void openDashboardPage(String loggedInUser) {
        JFrame frame = new JFrame();
        SwingUtilities.invokeLater(() -> {
            if (dashboard == null) {
                dashboard = new Dashboard(frame, loggedInUser);
                dbConnect.testConnection();
                dbConnect.testConnection();
            } else {
                dashboard.updateUsername(loggedInUser);
            }
        });
    }

}
