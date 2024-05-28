/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.dangnhap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import view.admin.TrangChuAdmin;
import view.sinhvien.TrangChuSinhVien;

/**
 *
 * @author Le Thi Ngoc
 */
public class DoiMatKhau extends javax.swing.JDialog {

    /**
     * Creates new form DoiMatKhau
     */
    public DoiMatKhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Đổi mật khẩu");
    }
    
    private String tkDangNhap;
    private String password;
    
    public void checkChange(){
        String filePath = "src\\data\\LichSuDangNhap.txt";
        try {
            // Tạo đối tượng FileReader để đọc tệp tin
            FileReader fileReader = new FileReader(filePath);

            // Tạo đối tượng BufferedReader để đọc dữ liệu từ FileReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                tkDangNhap = line;
            }
            System.out.println("Tên đang nhập: " + tkDangNhap);
            // Đóng FileReader và BufferedReader sau khi đọc xong
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try{
            String fileNameSV = "src\\data\\TaiKhoanSV.txt";
            String fileNameAdmin = "src\\data\\TaiKhoanAdmin.txt";
            
            if(checkUser(tkDangNhap, fileNameSV)){
                btnQuayLai.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                    
                });
                Map<String, String> svMap = readUserMapFromFile(fileNameSV);
                password = svMap.get(tkDangNhap);
                if(checkChangePassword()){
                    password = new String(txtMatKhauMoi.getPassword());
                    svMap.put(tkDangNhap, password);
                    JOptionPane.showMessageDialog(DoiMatKhau.this, "Đổi mật khẩu thành công");
                    resetForm();
                }  
                writeDataToFile(svMap, fileNameSV);
                return;
            }
                        
            if(checkUser(tkDangNhap, fileNameAdmin)){
                btnQuayLai.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                    
                });
                Map<String, String> adminMap = readUserMapFromFile(fileNameAdmin);
                password = adminMap.get(tkDangNhap);
                if(checkChangePassword()){
                    password = new String(txtMatKhauMoi.getPassword());
                    adminMap.put(tkDangNhap, password);
                    JOptionPane.showMessageDialog(DoiMatKhau.this, "Đổi mật khẩu thành công");
                    resetForm();
                }  
                writeDataToFile(adminMap, fileNameAdmin);
                return;
            }
        }catch(IOException e){
             e.printStackTrace();
        }
    }
    
    private Map<String, String> readUserMapFromFile(String fileName) throws FileNotFoundException, IOException{
        Map<String, String> userMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        // Đọc từng dòng từ file
        while ((line = br.readLine()) != null) {
            // Tách các phần trong dòng bằng dấu phẩy
            String[] parts = line.split(",");
            userMap.put(parts[0],parts[1]);
        }
        return userMap;
    }
    
    //Kiểm tra xem user đăng nhập thuộc danh sách nào
    private boolean checkUser(String username, String fileName) throws IOException{
        Map<String, String> userMap = readUserMapFromFile(fileName);
        if(userMap.containsKey(username))
            return true;
        else
            return false;
    }
    
    private void writeDataToFile(Map<String, String> dataMap, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private boolean checkChangePassword(){
        //Lấy thông tin các ô textbox
        String matKhauCu = new String(txtMatKhauCu.getPassword());
        String matKhauMoi = new String(txtMatKhauMoi.getPassword());
        String nhapLaiMK = new String(txtNhapLai.getPassword());
        
        try{
            //Kiểm tra bỏ trống
            if(matKhauCu.equals("") || matKhauMoi.equals("") || nhapLaiMK.equals("")){
                throw new Exception("Vui lòng điền đầy đủ thông tin");
            }
            
            //Kiểm tra mật khẩu cũ nhập vào đã khớp với mật khẩu đăng nhập chưa
            if(!matKhauCu.equals(password))
                throw new Exception("Mật khẩu nhập vào không đúng");
            
            //Kiểm tra trường mật khẩu mới và nhập lại mật khẩu mới
            if(!matKhauMoi.equals(nhapLaiMK))
                throw new Exception("Mật khẩu mới và mật khẩu nhập lại không trùng khớp");
            
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(DoiMatKhau.this,ex.getMessage(), "Invalidation", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void resetForm(){
        txtMatKhauCu.setText("");
        txtMatKhauMoi.setText("");
        txtNhapLai.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        txtMatKhauCu = new javax.swing.JPasswordField();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        txtNhapLai = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Mật khẩu cũ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mật khẩu mới");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Nhập lại mật khẩu mới");

        btnQuayLai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.setName("btnQuayLai"); // NOI18N
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.setName("btnDoiMatKhau"); // NOI18N
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMatKhauCu)
                                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNhapLai, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnDoiMatKhau)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLai)
                    .addComponent(btnDoiMatKhau))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        checkChange();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoiMatKhau dialog = new DoiMatKhau(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtMatKhauCu;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JPasswordField txtNhapLai;
    // End of variables declaration//GEN-END:variables
}
