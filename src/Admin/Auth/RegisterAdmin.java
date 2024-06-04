/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin.Auth;

import User.Auth.LoginSiswa;
import dbConnect.dbConnect;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rama Dev
 */
public class RegisterAdmin extends javax.swing.JFrame {

    /**
     * Creates new form RegisterAdmin
     */
    public RegisterAdmin(JFrame currentFrame) {
        currentFrame.dispose();
        initComponents();
        this.setVisible(true);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail|yahoo)\\.com$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean createUser(String name, String email, String hashedPassword) {
        try (Connection connection = dbConnect.connect()) {
            if (connection != null) {
                String query = "INSERT INTO guru (name, email, password) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, hashedPassword);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            dbConnect.logger.log(Level.SEVERE, "Database connection error", e);
        }
        return false;
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
        emailInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passInput = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cpassInput = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        registerAdmin = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        loginLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-regis-user.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 690));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 20, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 60, -1));

        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });
        jPanel1.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 360, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 20, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 110, -1));

        passInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passInputActionPerformed(evt);
            }
        });
        jPanel1.add(passInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 360, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 30, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ulangi Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 140, -1));

        cpassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpassInputActionPerformed(evt);
            }
        });
        jPanel1.add(cpassInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 360, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 20, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Email");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 60, -1));

        jTextField2.setText("jTextField1");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 250, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Nama");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 60, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 20, -1));

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });
        jPanel1.add(nameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 360, 30));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel14.setText("Halaman Register ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, -1, -1));

        registerAdmin.setBackground(new java.awt.Color(0, 0, 204));
        registerAdmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerAdmin.setForeground(new java.awt.Color(255, 255, 255));
        registerAdmin.setText("Bergabung");
        registerAdmin.setToolTipText("click untuk register");
        registerAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAdminActionPerformed(evt);
            }
        });
        jPanel1.add(registerAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 360, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Sudah memiliki akun ?");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 170, -1));

        loginLink.setBackground(new java.awt.Color(0, 51, 255));
        loginLink.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginLink.setForeground(new java.awt.Color(0, 51, 255));
        loginLink.setText("login disini");
        loginLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLinkMouseClicked(evt);
            }
        });
        jPanel1.add(loginLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void passInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passInputActionPerformed

    private void cpassInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpassInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpassInputActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void registerAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerAdminActionPerformed
        // TODO add your handling code here:
        String name = nameInput.getText();
        String email = emailInput.getText();
        String password = new String(passInput.getPassword());
        String confirmPassword = new String(cpassInput.getPassword());

        // Validate input data
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tolong isi Semua kolom ! ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isEmailValid(email)) {
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Confirm Password anda Tidak sama dengan Password ! ", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String hashedPassword = hashPassword(password);

            boolean success = createUser(name, email, hashedPassword);

            if (success) {
                JOptionPane.showMessageDialog(this, "Berhasil Melakukan Register !", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Redirect to login page or dashboard
                new LogingGuru(this);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal Melakukan Register ! ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email yang anda masukan tidak Valid !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerAdminActionPerformed

    private void loginLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMouseClicked
        // TODO add your handling code here:
        new LogingGuru(this);
    }//GEN-LAST:event_loginLinkMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegisterAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegisterAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegisterAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegisterAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterAdmin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cpassInput;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel loginLink;
    private javax.swing.JTextField nameInput;
    private javax.swing.JPasswordField passInput;
    private javax.swing.JButton registerAdmin;
    // End of variables declaration//GEN-END:variables
}
