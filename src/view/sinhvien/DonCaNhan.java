/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.sinhvien;

import controller.DonCaNhanController;
import controller.DonTapTheController;
import controller.TKDSDonTheoSV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.FakeData;
import model.HocPhanDangKyCuaKhoa;
import model.SinhVienTapThe;
import model.TTDonCaNhan;
import model.TTDonDangKy;
import model.TTDonTapThe;

/**
 *
 * @author Le Thi Ngoc
 */
public class DonCaNhan extends javax.swing.JDialog {

    //mã sinh viên là sinh viên đang đăng nhập
    private String maDonCaNhan;
    String maSV = FakeData.layMaSV_Test();
    private String tenHP;
    private String maHP;
    private String lyDo;
    private String trangThai = "Chưa duyệt";
    private String maNganh = "HTTT";
    List<HocPhanDangKyCuaKhoa> danhSachHocPhan = FakeData.layHocPhantheoNganh(maNganh);
    TTDonCaNhan dcn = new TTDonCaNhan(maDonCaNhan, maSV, maHP, tenHP, lyDo, trangThai);

    public List<HocPhanDangKyCuaKhoa> getDanhSachHocPhan() {
        return danhSachHocPhan;
    }

    public void setDanhSachHocPhan(List<HocPhanDangKyCuaKhoa> danhSachHocPhan) {
        this.danhSachHocPhan = danhSachHocPhan;
    }

    /**
     * Creates new form DonCaNhan
     *
     * @param parent
     * @param modal
     */
    public DonCaNhan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private static String generateCode(String currentCode) {
        // Hàm này sẽ sinh mã mới từ mã hiện tại, ví dụ: DTT001 -> DTT002
        String prefix = currentCode.substring(0, currentCode.length() - 3);  //DTT
        int suffix = Integer.parseInt(currentCode.substring(currentCode.length() - 3)); //001
        int newSuffix = suffix + 1;
        return String.format("%s%03d", prefix, newSuffix);
    }

    private static String loadLastCodeFromFile() {
        String lastCode = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\data\\DSDonCaNhan.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Kiểm tra xem dòng có rỗng không
                    lastCode = line.split(",")[0]; // Lấy mã ở cột đầu tiên, tách các cột bằng dấu phẩy
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastCode;
    }

    private String MaDon() {
        String currentCode = loadLastCodeFromFile();
        if (currentCode == null) {
            // Nếu không có mã trong file, khởi tạo mã ban đầu
            currentCode = "DCN001";
        }
        // Sinh mã mới
        String newCode = generateCode(currentCode);
        return newCode;
    }

    public boolean checkDonHopLe() {
        List<TTDonCaNhan> ds = TTDonCaNhan.readDonFromFile("src/Data/DSDonCaNhan.txt");
        //List<TTDonCaNhan> ds = FakeData.listDonCaNhan;

        String maHP = txtMaHP.getText();

        // Kiểm tra đơn đã tồn tại 
        Iterator<TTDonCaNhan> itr = ds.iterator();
        while (itr.hasNext()) {
            TTDonCaNhan x = itr.next();
            if (x.getMaHP().equals(maHP) && maSV.equals(x.getMaSV())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkDonHopLe_FileDSDonTapThe() {
        String maSV = FakeData.layMaSV_Test();
        String maHP = txtMaHP.getText();

        // Kiểm tra đơn tập thể đã tồn tại
        List<TTDonTapThe> listDTT = FakeData.layDSDonTapThe_Test();
        for (TTDonTapThe x : listDTT) {
            if (x.getMaSV().equals(maSV) && x.getMaHP().equals(maHP)) {
                return false; // Đơn tập thể đã tồn tại
            }
        }

        // Kiểm tra mã học phần đã tồn tại cho sinh viên trong danh sách đơn tập thể
        for (TTDonTapThe x : listDTT) {
            if (x.getMaHP().equals(maHP)) {
                for (SinhVienTapThe sVTT_DaDK : x.getDsSV()) {
                    if (sVTT_DaDK.getMaSV().equals(maSV)) {
                        return false; // Mã sinh viên và mã học phần đã tồn tại
                    }
                }
            }
        }

        return true;
    }

//    private void themDon() {
//
//        dcn.setTenHP((String) cboTenHP.getSelectedItem()); 
//        dcn.setMaHP(txtMaHP.getText());
//        dcn.setLyDo(txtLyDo.getText());
//
//        if (dcn.getTenHP().trim().equals("") || dcn.getMaHP().trim().equals("") || dcn.getLyDo().trim().equals("")) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.",
//                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            return;
//        } else {
//            if (checkDonHopLe()) {
//                dcn.setMaDonCaNhan(MaDon());
//                String filePath = "src/Data/DSDonCaNhan.txt";
//                try {
//                    // Khởi tạo FileWriter với đường dẫn tới tệp tin và true để cho phép ghi thêm
//                    FileWriter fileWriter = new FileWriter(filePath, true);
//
//                    // Khởi tạo BufferedWriter
//                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                    // Ghi dữ liệu vào tệp tin
//                    bufferedWriter.write(dcn.toString());
//                    bufferedWriter.newLine(); // Thêm dòng mới sau mỗi dữ liệu
//
//                    // Đóng BufferedWriter
//                    bufferedWriter.close();
//                    JOptionPane.showMessageDialog(this, "Thêm đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                    System.out.println("Đã thêm dữ liệu vào tệp tin thành công.");
//
//                    cboTenHP.setSelectedIndex(-1);
//                    txtMaHP.setText("");
//                    txtLyDo.setText("");
//                } catch (IOException e) {
//                    System.out.println("Đã xảy ra lỗi khi thêm dữ liệu vào tệp tin: " + e.getMessage());
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Đơn đã tồn tại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
//
//    }
//    
    public boolean setResults() {
        this.maDonCaNhan = MaDon();
        this.maSV = FakeData.layMaSV_Test();
        this.tenHP = cboTenHP.getSelectedItem().toString();
        this.maHP = txtMaHP.getText();
        this.lyDo = txtLyDo.getText();
        this.trangThai = "Chưa duyệt";
        if (this.lyDo.isEmpty() || this.lyDo.trim().equals("") || this.maHP.isEmpty() || this.maHP.trim().equals("")) {
            return false;
        }
        return true;
    }

    public void reloadForm() {
        cboTenHP.setSelectedIndex(0);
        txtMaHP.setText("");
        txtLyDo.setText("");

    }
    public void showRegistrationSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTenHP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLyDo = new javax.swing.JTextArea();
        btnThoat = new javax.swing.JButton();
        btnGui = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboTenHP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboTenHP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTenHP.setName("cbbTenHP"); // NOI18N
        cboTenHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenHPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã học phần");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Lý do mở lớp");

        txtMaHP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaHP.setName("txtMaHP"); // NOI18N

        txtLyDo.setColumns(20);
        txtLyDo.setRows(5);
        txtLyDo.setName("txtLyDo"); // NOI18N
        jScrollPane1.setViewportView(txtLyDo);

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setName("btnThoat"); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnGui.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnGui.setText("Gửi đơn");
        btnGui.setName("btnGuiDon"); // NOI18N
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên học phần");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboTenHP, 0, 239, Short.MAX_VALUE)
                                    .addComponent(txtMaHP)))
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnGui)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboTenHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnGui))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        // Tạo DefaultComboBoxModel từ danh sách tên học phần
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (HocPhanDangKyCuaKhoa hocPhan : danhSachHocPhan) {
            model.addElement(hocPhan.getTenHP());
        }
        // Thiết lập mô hình cho JComboBox
        cboTenHP.setModel(model);
        cboTenHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenHPActionPerformed(evt);
            }
        });
        cboTenHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Lấy tên học phần được chọn
                String selectedTenHP = (String) cboTenHP.getSelectedItem();

                // Tìm học phần tương ứng trong danh sách
                for (HocPhanDangKyCuaKhoa hocPhan : danhSachHocPhan) {
                    if (hocPhan.getTenHP().equals(selectedTenHP)) {
                        // Gán mã học phần vào txtMaHP
                        txtMaHP.setText(hocPhan.getMaHP());
                        break;
                    }
                }
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTenHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenHPActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            dispose(); //Đóng giao diện hiện tại
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        // TODO add your handling code here:
        //this.themDon();
        if (!this.setResults()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        } else {
            try {
                if (checkDonHopLe() && checkDonHopLe_FileDSDonTapThe()) {
                   TTDonCaNhan donCaNhan = new TTDonCaNhan(maDonCaNhan,maSV,maHP,tenHP,lyDo,trangThai);

                    // Gọi phương thức lưu trữ trong model
                    DonCaNhanController.saveDonTapTheInfo(donCaNhan);

                    // Hiển thị thông báo đăng ký thành công hoặc xử lý khác tùy ý
                    this.showRegistrationSuccessMessage();
                    reloadForm();
                    
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Bạn đã đăng ký mở lớp học phần này rồi.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnGuiActionPerformed

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
            java.util.logging.Logger.getLogger(DonCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DonCaNhan dialog = new DonCaNhan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGui;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboTenHP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLyDo;
    private javax.swing.JTextField txtMaHP;
    // End of variables declaration//GEN-END:variables
}
