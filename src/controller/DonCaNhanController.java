/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.TTDonCaNhan;
import model.TTDonTapThe;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class DonCaNhanController {
    public static void saveDonTapTheInfo(TTDonCaNhan donCaNhan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\data\\DSDonCaNhan.txt", true))) {
            writer.write(donCaNhan.toString());
            writer.newLine();  // Thêm dòng mới để cách biệt giữa các bản ghi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
