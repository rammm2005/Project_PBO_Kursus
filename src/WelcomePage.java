
import Admin.Auth.LogingGuru;
import User.Auth.LoginSiswa;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Rama Dev
 */
public class WelcomePage extends javax.swing.JFrame {

    /**
     * Creates new form WelcomePage
     */
    public WelcomePage() {
        initComponents();
        
        setVisible(true);
    }

    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAuthSiswa = new javax.swing.JButton();
        btnAuthGuru = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/welcome.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, 490));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang di Aplikasi Kursus Online");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        btnAuthSiswa.setBackground(new java.awt.Color(0, 0, 255));
        btnAuthSiswa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAuthSiswa.setForeground(new java.awt.Color(255, 255, 255));
        btnAuthSiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon-student.png"))); // NOI18N
        btnAuthSiswa.setText("Masuk Sebagai Siswa");
        btnAuthSiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAuthSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthSiswaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAuthSiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 610, 220, 50));

        btnAuthGuru.setBackground(new java.awt.Color(51, 102, 255));
        btnAuthGuru.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAuthGuru.setForeground(new java.awt.Color(255, 255, 255));
        btnAuthGuru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon-guru.png"))); // NOI18N
        btnAuthGuru.setText("Masuk Sebagai Guru");
        btnAuthGuru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAuthGuru.setPreferredSize(new java.awt.Dimension(200, 100));
        btnAuthGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthGuruActionPerformed(evt);
            }
        });
        jPanel2.add(btnAuthGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 220, 50));

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAuthGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthGuruActionPerformed
        // TODO add your handling code here:
        new LogingGuru(this);
    }//GEN-LAST:event_btnAuthGuruActionPerformed

    private void btnAuthSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthSiswaActionPerformed
        // TODO add your handling code here:
        new LoginSiswa(this);
    }//GEN-LAST:event_btnAuthSiswaActionPerformed

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
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthGuru;
    private javax.swing.JButton btnAuthSiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}