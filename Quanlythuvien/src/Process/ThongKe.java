/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.ConnectDB;
import static Process.UpdateTable.ps;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Gaara
 */
public class ThongKe extends javax.swing.JFrame {

    public static String sql = "SELECT * FROM PHIEU_MUON where Han_tra < (select GETDATE())";

    public JTextArea getTa() {
        return taBaoCao;
    }

    public JButton inbc() {
        return jButton2;
    }
    public static Connection con = ConnectDB.getConnect();

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        setSize(735,631);
        setResizable(false);
        UpdateTable.LoadData(sql, tbPhieuQuaHan);
        setLocationRelativeTo(null);
        try {
            String sql1 = "SELECT SUM(So_luong) as sach FROM SACH";
            String sql2 = "SELECT COUNT(Ma_Ban_Doc) as bandoc FROM Ban_Doc";
            String sql3 = "SELECT COUNT(Ma_Phieu_muon) as phieumuon FROM PHIEU_MUON";
            String sql4 = "SELECT COUNT(DISTINCT Ma_Ban_Doc) as nguoimuon FROM PHIEU_MUON";
            String sql5 = "SELECT COUNT(Ma_Phieu_muon) as phieumuon FROM PHIEU_MUON where (Han_tra < (select GETDATE()) and NgayTra IS NULL)";
            ResultSet rs1 = UpdateTable.ShowTextField(sql1);
            ResultSet rs2 = UpdateTable.ShowTextField(sql2);
            ResultSet rs3 = UpdateTable.ShowTextField(sql3);
            ResultSet rs4 = UpdateTable.ShowTextField(sql4);
            ResultSet rs5 = UpdateTable.ShowTextField(sql5);
            if (rs1.next()) {
                this.lbTongSach.setText("Tổng số sách : " + Integer.toString(rs1.getInt("sach")));
            }
            if (rs2.next()) {
                this.lbTongKhach.setText("Tổng số bạn đọc: " + Integer.toString(rs2.getInt("bandoc")));
            }
            if (rs3.next()) {
                this.lbTongPhieu.setText("Tổng số phiếu mượn: " + Integer.toString(rs3.getInt("phieumuon")));
            }
            if (rs4.next()) {
                this.lbTongKhachMuon.setText("Tổng số người mượn sách: " + Integer.toString(rs4.getInt("nguoimuon")));
            }
            if (rs5.next()) {
                this.lbTongPhieuQuaHan.setText("Tổng số phiếu quá hạn là: " + Integer.toString(rs5.getInt("phieumuon")));
            }

        } catch (Exception e) {

        }
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        List l;
        l = DbUtils.resultSetToNestedList(rs);
        this.taBaoCao.append(this.lbTongSach.getText() + "\n");
        this.taBaoCao.append(this.lbTongKhach.getText() + "\n");
        this.taBaoCao.append(this.lbTongPhieu.getText() + "\n");
        this.taBaoCao.append(this.lbTongKhachMuon.getText() + "\n");
        this.taBaoCao.append(this.lbTongPhieuQuaHan.getText() + "\n\n");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuQuaHan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbTongSach = new javax.swing.JLabel();
        lbTongPhieu = new javax.swing.JLabel();
        lbTongKhachMuon = new javax.swing.JLabel();
        lbTongKhach = new javax.swing.JLabel();
        lbTongPhieuQuaHan = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taBaoCao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thống kê");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(311, 11, 110, 29);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Danh sách phiếu mượn quá hạn");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(261, 186, 176, 14);

        tbPhieuQuaHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPhieuQuaHan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 206, 740, 188);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\MÔN HỌC\\JAVA\\Images1\\quaylai1.png")); // NOI18N
        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(598, 0, 127, 45);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(464, 47, 0, 0);

        lbTongSach.setText("?");
        getContentPane().add(lbTongSach);
        lbTongSach.setBounds(60, 70, 402, 16);

        lbTongPhieu.setText("?");
        getContentPane().add(lbTongPhieu);
        lbTongPhieu.setBounds(60, 90, 396, 16);

        lbTongKhachMuon.setText("?");
        getContentPane().add(lbTongKhachMuon);
        lbTongKhachMuon.setBounds(60, 110, 396, 16);

        lbTongKhach.setText("?");
        getContentPane().add(lbTongKhach);
        lbTongKhach.setBounds(60, 50, 396, 16);

        lbTongPhieuQuaHan.setText("?");
        getContentPane().add(lbTongPhieuQuaHan);
        lbTongPhieuQuaHan.setBounds(60, 130, 396, 16);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("In báo cáo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(598, 73, 91, 42);

        taBaoCao.setColumns(20);
        taBaoCao.setRows(5);
        taBaoCao.setText("\t                        BÁO CÁO THỐNG KÊ \n");
        jScrollPane2.setViewportView(taBaoCao);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 390, 740, 170);

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 740, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Chucnang t = new Chucnang();
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("Save File");
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String content = this.taBaoCao.getText();
                jfc.setDialogTitle("Save File");
                FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile());
                fos.write(content.getBytes());
                fos.flush();
                fos.close();
                JOptionPane.showMessageDialog(null, "In báo cáo thành công");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTongKhach;
    private javax.swing.JLabel lbTongKhachMuon;
    private javax.swing.JLabel lbTongPhieu;
    private javax.swing.JLabel lbTongPhieuQuaHan;
    private javax.swing.JLabel lbTongSach;
    private javax.swing.JTextArea taBaoCao;
    private javax.swing.JTable tbPhieuQuaHan;
    // End of variables declaration//GEN-END:variables
}
