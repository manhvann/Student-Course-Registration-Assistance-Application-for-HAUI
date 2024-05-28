/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.SinhVienTapThe;
import model.TTDonTapThe;
import view.sinhvien.DonTapThe;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class DonTapTheController {
    public static void saveDonTapTheInfo(TTDonTapThe donTapThe) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\data\\DSDonTapThe.txt", true))) {
            writer.write(donTapThe.toString());
            writer.newLine();  // Thêm dòng mới để cách biệt giữa các bản ghi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
