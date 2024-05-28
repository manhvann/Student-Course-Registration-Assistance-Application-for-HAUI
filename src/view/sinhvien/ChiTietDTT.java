/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.sinhvien;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.FakeData;
import model.Nganh;
import model.SinhVienTapThe;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class ChiTietDTT extends javax.swing.JDialog {

    /**
     * Creates new form ChiTietDTT
     */
    private SinhVienTapThe sinhVienTapThe;
    private boolean isModeAdd;  // Biến để xác định chế độ là thêm mới hay sửa
    private List<SinhVienTapThe> dsSV;
    private String maKhoa="KCNTT";
    private SinhVienTapThe selectedObject;
    public ChiTietDTT(java.awt.Dialog parent, boolean modal, List<SinhVienTapThe> dsSV, String maKhoa,SinhVienTapThe selectedObject) {
        super(parent, modal);
        initComponents(); 
        this.dsSV = dsSV;
        this.maKhoa = maKhoa;
        this.selectedObject = selectedObject;
    }
    
    public ChiTietDTT(java.awt.Dialog parent, boolean modal, List<SinhVienTapThe> dsSV, String maKhoa) {
        super(parent, modal);
        initComponents(); 
        this.dsSV = dsSV;
        this.maKhoa = maKhoa;
    }

    public List<Nganh> dsNganhTheoKhoa() {
        
        List<Nganh> listNganh = FakeData.layNganh_Test();
        List<Nganh> nganhs = new ArrayList<>();
        for (Nganh nganh : listNganh) {
            if (nganh.getMaKhoa().equals(maKhoa)) {
                nganhs.add(nganh);
            }
        }
        return nganhs;
    }
    
    // Hàm để thiết lập chế độ là thêm mới
    public void setAddMode() {
        isModeAdd = true;
        btnThemMoi.setVisible(true);
        btnLuu.setVisible(false);
    }
    // Hàm để thiết lập chế độ là sửa
    public void setEditMode() {
        isModeAdd = false;
        btnThemMoi.setVisible(false);
        btnLuu.setVisible(true);
    }

    public boolean isCheck(){
        if(txtMaSV.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sinh viên!", "Message", JOptionPane.INFORMATION_MESSAGE);
            txtMaSV.requestFocus();
            return false;
        }
        if(txtTenSV.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sinh viên!", "Message", JOptionPane.ERROR_MESSAGE);
            txtTenSV.requestFocus();
            return false;
        }
        
        return true;
    }
    public boolean isCheck_MaSV(){
        String maSV = txtMaSV.getText();
        boolean tonTai = dsSV.stream()
                        .anyMatch(sv -> sv.getMaSV().equals(maSV));
        if(tonTai) {
            JOptionPane.showMessageDialog(this, "Sinh viên đã tồn tại trong danh sách!", "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public SinhVienTapThe getSVTT(){
            return sinhVienTapThe;
    }
    public void setSinhVien(SinhVienTapThe sv){
        txtMaSV.setText(sv.getMaSV());
        txtTenSV.setText(sv.getHoTen());
        for(Nganh nganh: dsNganhTheoKhoa()){
            if(nganh.getTenNganh().equals(sv.getTenNganh())){
                cbbNganhHoc.setSelectedItem(nganh.getTenNganh());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        cbbNganhHoc = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên sinh viên");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã sinh viên");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Ngành học");

        txtMaSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        txtTenSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSVActionPerformed(evt);
            }
        });

        cbbNganhHoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbNganhHoc.setModel(new javax.swing.DefaultComboBoxModel<>());
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Nganh nganh : dsNganhTheoKhoa()) {
            model.addElement(nganh.getTenNganh());
        }
        cbbNganhHoc.setModel(model);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(cbbNganhHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnLuu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThemMoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnQuayLai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuayLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnThemMoi)
                    .addComponent(btnQuayLai))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void txtTenSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSVActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if(isCheck()){
                sinhVienTapThe = new SinhVienTapThe(txtMaSV.getText(),txtTenSV.getText(),cbbNganhHoc.getSelectedItem().toString());
                selectedObject.setMaSV(sinhVienTapThe.getMaSV());
                selectedObject.setHoTen(sinhVienTapThe.getHoTen());
                selectedObject.setTenNganh(sinhVienTapThe.getTenNganh());
            // Đóng cửa sổ dialog
            dispose();
        }else sinhVienTapThe = null;
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        if(isCheck() && isCheck_MaSV()){
            sinhVienTapThe = new SinhVienTapThe(txtMaSV.getText(),txtTenSV.getText(),cbbNganhHoc.getSelectedItem().toString());
            // Đóng cửa sổ dialog
            dispose();
        }else sinhVienTapThe = null;

    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietDTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietDTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietDTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietDTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ChiTietDTT dialog = new ChiTietDTT(new javax.swing.JDialog(), true, );
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JComboBox<String> cbbNganhHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
