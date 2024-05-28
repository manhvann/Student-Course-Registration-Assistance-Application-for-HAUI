/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class LuuData {
    
    public static void LuuDSDonTapThe(List<TTDonTapThe> listTTDonTapThe){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ten_file.txt"))) {
            for (TTDonTapThe ttDon : listTTDonTapThe) {
                writer.write(ttDon.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
