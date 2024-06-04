/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin.Auth;

/**
 *
 * @author Rama Dev
 */
public class AdminSession {

    private static String loggedInUser;

    public static void setLoggedInUser(String email) {
        loggedInUser = email;
    }

    public static String getLogginUser() {
        return loggedInUser;
    }
}
