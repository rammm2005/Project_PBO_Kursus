/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin.Dashboard;

import Admin.Auth.AdminSession;
import Admin.Auth.LogingGuru;
import dbConnect.dbConnect;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Rama Dev
 */
public class Dashboard_Admin extends javax.swing.JFrame {

    String Email;
    private DefaultTableModel tableModel;

    /**
     * Creates new form Dashboard_Admin
     */
    public Dashboard_Admin(JFrame frame, String logginUser) {
        initComponents();
        nameDisplay.setText(logginUser);
        frame.dispose();
        updateTotalGuru();
        updateTotalSiswa();
        customizeTable();
        loadStudentData();
        this.setVisible(true);

    }

    public void updateUsername(String loggedInUser) {
        nameDisplay.setText(loggedInUser);
    }

    public void updateTotalGuru() {
        int total = dbConnect.getTotalGuruFromDatabase();
        total_guru.setText("Total Guru: " + total);
    }

    public void updateTotalSiswa() {
        int totalSiswa = dbConnect.getTotalSiswaFromDatabase();
        total_siswa.setText("Total Siswa: " + totalSiswa);
    }

    private void customizeTable() {
        // Inisialisasi tableModel dengan kolom yang sesuai
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Email", "Pendidikan", "Action"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Hanya kolom "Action" yang bisa diedit
            }
        };

        // Set model tabel ke tabelDashboard
        tableDashboard.setModel(tableModel);
        tableDashboard.getColumn("Action").setCellRenderer(new ButtonRenderer());
        tableDashboard.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
    }

    private void loadStudentData() {
        try (Connection conn = dbConnect.connect()) {
            String sql = "SELECT id, name, email, pendidikan FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String pendidikan = rs.getString("pendidikan");
                tableModel.addRow(new Object[]{id, name, email, pendidikan, "Delete"});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(int userId, int rowIndex) {
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda Yakin untuk menghapus data pengguna dengan id " +  userId, "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = dbConnect.deleteUser(userId);
            if (success) {
                tableModel.removeRow(rowIndex);
                JOptionPane.showMessageDialog(this, "Pengguna Berhasil Di hapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus pengguna", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            String imagePath = "/assets/delete.png";
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            if (inputStream != null) {
                // Jika gambar default ditemukan
                try {
                    BufferedImage img = ImageIO.read(inputStream);
                    ImageIcon defaultImageIcon = new ImageIcon(img.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                    setIcon(defaultImageIcon);
                    setOpaque(true);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Jika gambar default tidak ditemukan
                System.err.println("Gambar icon delete tidak ditemukan: " + imagePath);
            }
//            setIcon(new ImageIcon("assets/delete.png")); // Ganti dengan path ikon delete Anda
//            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private boolean isPushed;
        private int rowIndex;
        private JTable table;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setIcon(new ImageIcon("path/to/delete_icon.png")); // Ganti dengan path ikon delete Anda
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    int userId = (int) table.getValueAt(rowIndex, 0);
                    deleteUser(userId, rowIndex);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.rowIndex = row;
            this.table = table;
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        soal = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        dashboard = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JLabel();
        panel_main = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        total_guru = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        nameDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total_siswa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDashboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 51, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Logout");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 80, 20));

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pengaturan");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 150, 30));

        soal.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        soal.setForeground(new java.awt.Color(153, 153, 153));
        soal.setText("Soal");
        soal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        soal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soalMouseClicked(evt);
            }
        });
        jPanel7.add(soal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 150, 30));

        jLabel33.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dashboard.png"))); // NOI18N
        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 40, 40));

        jLabel34.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/leaderboard.png"))); // NOI18N
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 30, 40));

        dashboard.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setText("Dashboard");
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
        });
        jPanel7.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 150, 30));

        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/switch.png"))); // NOI18N
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
        });
        jPanel7.add(LogoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 760));

        panel_main.setBackground(new java.awt.Color(0, 204, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Guru Tersedia");
        panel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teacher.png"))); // NOI18N
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 40, 40));

        total_guru.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total_guru.setText("jLabel7");
        panel_main.add(total_guru, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 300, 160));

        jLabel38.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel38.setText("Hallo ! Selamat Datang");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        nameDisplay.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        nameDisplay.setText("Nama Loe ");
        nameDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(nameDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel4.setText("Seleasikan Task anda sebagai admin.");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Siswa Tersedia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 50, 60));

        total_siswa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total_siswa.setText("jLabel7");
        jPanel1.add(total_siswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 290, 160));

        tableDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Email", "Pendidikan", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDashboard.setRowHeight(35);
        jScrollPane1.setViewportView(tableDashboard);
        if (tableDashboard.getColumnModel().getColumnCount() > 0) {
            tableDashboard.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 950, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        int choice = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            AdminSession.setLoggedInUser(null);

            LogingGuru loginPage = new LogingGuru(this);
            loginPage.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void soalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soalMouseClicked
        // TODO add your handling code here:
        dispose();
        Soal soal = new Soal(this);
        soal.setVisible(true);
    }//GEN-LAST:event_soalMouseClicked

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        // TODO add your handling code here:
        dispose();
        Dashboard_Admin dashboard = new Dashboard_Admin(this, Email);
        dashboard.setVisible(true);
    }//GEN-LAST:event_dashboardMouseClicked

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
//            java.util.logging.Logger.getLogger(Dashboard_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard_Admin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoutBtn;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameDisplay;
    private javax.swing.JPanel panel_main;
    private javax.swing.JLabel soal;
    private javax.swing.JTable tableDashboard;
    private javax.swing.JLabel total_guru;
    private javax.swing.JLabel total_siswa;
    // End of variables declaration//GEN-END:variables
}
