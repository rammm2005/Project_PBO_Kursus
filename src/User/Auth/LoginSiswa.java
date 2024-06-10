/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User.Auth;

import User.Pages.Dashboard;
import dbConnect.dbConnect;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rama Dev
 */
public class LoginSiswa extends javax.swing.JFrame {

    /**
     * Creates new form LoginSiswa
     */
    public LoginSiswa(JFrame currentFrame) {
        currentFrame.dispose();
        initComponents();
        this.setVisible(true);
    }

    public boolean authenticateUser(String email, String password) {
        try (Connection connection = dbConnect.connect()) {
            if (connection != null) {
                String query = "SELECT * FROM users WHERE email = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String storedHash = resultSet.getString("password");
                    return checkPassword(password, storedHash);
                }
            }
        } catch (SQLException e) {
            dbConnect.logger.log(Level.SEVERE, "Database connection error", e);
        }
        return false;
    }

    private boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail|yahoo)\\.com$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) { // mengonversi setiap byte menjadi representasi string dalam format hexadecimal
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            dbConnect.logger.log(Level.SEVERE, "Hashing algorithm not found", e);
            return null;
        }
    }

    private boolean checkPassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        regiterLink = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        passInput = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student-l.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 200, 670, 400));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Halo, Selamat Datang Kembali");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 350, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("kamu masih di rindukan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 230, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 40, 20));

        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });
        jPanel1.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 330, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 70, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Belum memiliki akun ?");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, -1, -1));

        regiterLink.setBackground(new java.awt.Color(0, 51, 255));
        regiterLink.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regiterLink.setForeground(new java.awt.Color(0, 51, 255));
        regiterLink.setText("register disini");
        regiterLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regiterLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regiterLinkMouseClicked(evt);
            }
        });
        jPanel1.add(regiterLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, -1, -1));

        btnLogin.setBackground(new java.awt.Color(0, 51, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 330, 40));

        passInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passInputActionPerformed(evt);
            }
        });
        jPanel1.add(passInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 330, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1010, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String email = emailInput.getText();
        String password = new String(passInput.getPassword());

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isEmailValid(email)) {
            System.out.println("Setting logged in user: " + email);
            UserSession.setLoggedInUser(email);
            if (authenticateUser(email, password)) {
                JOptionPane.showMessageDialog(this, "Anda berhasil Login dengan " + email, "Success", JOptionPane.INFORMATION_MESSAGE);
                Dashboard dashboard = new Dashboard(this, email);
                dashboard.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Password yang anda masukan salah", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email yang anda masukan tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void regiterLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regiterLinkMouseClicked
        // TODO add your handling code here:
        new RegisterUser(this);
    }//GEN-LAST:event_regiterLinkMouseClicked

    private void passInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginSiswa().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passInput;
    private javax.swing.JLabel regiterLink;
    // End of variables declaration//GEN-END:variables
}
