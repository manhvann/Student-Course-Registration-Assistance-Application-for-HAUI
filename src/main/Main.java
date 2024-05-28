/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.DonTapTheController;
import view.dangnhap.DangNhap;
import view.sinhvien.DonTapThe;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class Main {
    public static void main(String[] args) {
        DangNhap dangNhap = new DangNhap();
        // Hiển thị cửa sổ dangNhap
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dangNhap.setVisible(true);
            }
        });
    }
}
