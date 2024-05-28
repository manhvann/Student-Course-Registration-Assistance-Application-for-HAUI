/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.dangnhap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.JOptionPane;
import model.QuanTriVien;
import model.SinhVien;
import model.TaiKhoan;
import view.admin.TrangChuAdmin;
import view.sinhvien.TrangChuSinhVien;

/**
 *
 * @author Le Thi Ngoc
 */
public class DangNhap extends javax.swing.JFrame {
    public DangNhap() {
        initComponents();
        this.setTitle("Đăng nhập");
        loadDataBase();
    }
    private ArrayList<TaiKhoan> adminList;
    private ArrayList<TaiKhoan> sinhVienList;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGRRole = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tenDangNhap = new javax.swing.JTextField();
        rdoQuanTriVien = new javax.swing.JRadioButton();
        rdoSinhVien = new javax.swing.JRadioButton();
        btnThoat = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        matKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        tenDangNhap.setName("txtTenDangNhap"); // NOI18N
        tenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenDangNhapActionPerformed(evt);
            }
        });

        btnGRRole.add(rdoQuanTriVien);
        rdoQuanTriVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoQuanTriVien.setText("Quản trị viên");
        rdoQuanTriVien.setName("rdoAdmin"); // NOI18N
        rdoQuanTriVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoQuanTriVienActionPerformed(evt);
            }
        });

        btnGRRole.add(rdoSinhVien);
        rdoSinhVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoSinhVien.setText("Sinh viên");
        rdoSinhVien.setName("rdoSinhVien"); // NOI18N

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setName("btnThoat"); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Đăng nhập");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        matKhau.setName("txtMatKhau"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(matKhau)
                            .addComponent(tenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(rdoQuanTriVien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoQuanTriVien)
                    .addComponent(rdoSinhVien))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataBase(){
        adminList = readUserFromFile("src\\data\\TaiKhoanAdmin.txt");
        sinhVienList = readUserFromFile("src\\data\\TaiKhoanSV.txt");
    }
    private ArrayList<TaiKhoan> readUserFromFile(String fileName){
        ArrayList<TaiKhoan> users = new ArrayList<>();
        FileReader inFileReader;
        BufferedReader in;
        try{
            inFileReader = new FileReader(fileName);
            in = new BufferedReader(inFileReader);
            String line;
            while((line = in.readLine()) != null){
                String[] tk = line.split(",");
                TaiKhoan taiKhoan = new TaiKhoan(tk[0].trim(), tk[1].trim());
                users.add(taiKhoan);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return users;
    }
    
    private int checkLogin(String maTK, String passWord)throws Exception{
        if(maTK.trim().equals("") || passWord.trim().equals(""))
            throw  new Exception("Vui lòng điền đầy đủ thông tin!");
        
        if(!rdoQuanTriVien.isSelected() && !rdoSinhVien.isSelected())
            throw new Exception("Vui lòng chọn vai trò đăng nhập");
        
        if(rdoQuanTriVien.isSelected()){
            for(TaiKhoan qtv : adminList){
                if(maTK.equalsIgnoreCase(qtv.getMaTK())&& passWord.equals(qtv.getMatKhau())){
                    return 0;
                }
            }
        }
        else {
            for(TaiKhoan sv : sinhVienList){
                if(maTK.equalsIgnoreCase(sv.getMaTK())&& passWord.equals(sv.getMatKhau())){
                    return 1;
                }
            }
        }
        return 2;
    }
//    Map<String, String> userMap = new HashMap<>();
    
    private void rdoQuanTriVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoQuanTriVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoQuanTriVienActionPerformed

    private void tenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenDangNhapActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String userName = tenDangNhap.getText();
        String passWord = new String(matKhau.getPassword()) ;
        String outputFileName = "src\\data\\LichSuDangNhap.txt";
        try{
            if(checkLogin(userName, passWord) == 1){
                writeUserInFileHistory(userName, outputFileName);
                TrangChuSinhVien sinhVien = new TrangChuSinhVien();
                sinhVien.setVisible(true);
                dispose();
                JOptionPane.showMessageDialog(DangNhap.this, "Đăng nhập thành công với vai trò sinh viên!");
            }
            else if(checkLogin(userName, passWord) == 0){
                writeUserInFileHistory(userName, outputFileName);
                TrangChuAdmin admin = new TrangChuAdmin();
                admin.setVisible(true); //Truy cập đến trang chủ admin
                dispose(); //Đóng giao diện đăng nhập hiện tại
                JOptionPane.showMessageDialog(DangNhap.this, "Đăng nhập thành công với vai trò quản trị viên!");
            }
            else
                throw new Exception("Tài khoản không tồn tại!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(DangNhap.this, ex.getMessage(),  "Invalidation", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void writeUserInFileHistory(String maUser, String outputFileName)throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        // Ghi thông tin tài khoản đăng nhập vào file
        writer.write(maUser);
        writer.close();
    }
    
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(DangNhap.this, "Bạn có chắc chắn muốn thoát chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if(choose == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed
    
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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGRRole;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField matKhau;
    private javax.swing.JRadioButton rdoQuanTriVien;
    private javax.swing.JRadioButton rdoSinhVien;
    private javax.swing.JTextField tenDangNhap;
    // End of variables declaration//GEN-END:variables
}
