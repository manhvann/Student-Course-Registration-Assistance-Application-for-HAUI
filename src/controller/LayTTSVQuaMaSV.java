/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

/**
 *
 * @author ADMIN
 */
public class LayTTSVQuaMaSV {
    public static List<SinhVien> readDSSVFromFile(String filePath) {
        List<SinhVien> ds = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    SinhVien sv = new SinhVien();
                    sv.setMaTK(parts[0]);
                    sv.setMaNganh(parts[1]);
                    ds.add(sv);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần
        }
        return ds;
    }
    static List<SinhVien> listDon = readDSSVFromFile("src\\data\\TaiKhoanSV.txt");

    public static String layMaNganh(String maSV) {
        for (SinhVien x : listDon) {
            
        }
        return null;
    }
}
