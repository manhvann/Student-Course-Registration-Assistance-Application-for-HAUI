/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.TKDSDonDKTheoMaHP.listDon;
import static controller.TKDSDonDKTheoMaHP.mapDon;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FakeData;
import model.TTDonCaNhan;
import model.TTDonDangKy;
import model.TTDonTapThe;

/**
 *
 * @author Le Thi Ngoc
 */
public class DuyetDon {
    public static int maxSV = 65;
    public static int minSV = 5;
    public static int soLuongLopDuocMo;
    public static Map<String, TTDonCaNhan> mapDonCaNhan = new HashMap<>();
    public static Map<String, TTDonTapThe> mapDonTapThe = new HashMap<>();
    
    public DuyetDon(List<TTDonDangKy> dsDon){
        try{
            soLuongLopDuocMo = thongKeSoLuongLop(dsDon);
            System.out.println(soLuongLopDuocMo);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        readListToMap();
        duyet(dsDon);
    }

    public int getSoLuongLopDuocMo() {
        return soLuongLopDuocMo;
    }
    
    public static int thongKeSoLuongLop(List<TTDonDangKy> dsDon) throws Exception{
        int tongSV = 0;
        int soLuongLopDuocMo = 0;
        
        for(TTDonDangKy don : dsDon){
            tongSV += don.getSoLuongSV();
            if(tongSV >= minSV){
                soLuongLopDuocMo++;
                tongSV = 0;
            }
        }
        if(soLuongLopDuocMo == 0)
            throw new Exception("Không có lớp nào được mở");
        return soLuongLopDuocMo;
    }
    
    public static void duyet(List<TTDonDangKy> dsDon){
        for(TTDonDangKy don : dsDon){
            if(don.getLoaiDon().equals("Cá nhân")){
                for(Map.Entry<String, TTDonCaNhan> entry : mapDonCaNhan.entrySet()){
                    if(entry.getKey().equals(don.getMaDon())){
                        if(soLuongLopDuocMo != 0)   
                            entry.getValue().setTrangThai("Có " + soLuongLopDuocMo + " lớp được mở");
                        else
                            entry.getValue().setTrangThai("Không có lớp nào được mở");
                        mapDonCaNhan.put(entry.getKey(), entry.getValue());
                    }
                }
            }else{
                for(Map.Entry<String, TTDonTapThe> entry : mapDonTapThe.entrySet()){
                    if(entry.getKey().equals(don.getMaDon())){
                        if(soLuongLopDuocMo != 0)
                            entry.getValue().setTrangThai("Có " + soLuongLopDuocMo + " lớp được mở");
                        else
                            entry.getValue().setTrangThai("Không có lớp nào được mở");
                        mapDonTapThe.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        capNhatFileCaNhan();
        capNhatFileTapThe();
    }
    
    public static void readListToMap(){
        //Tạo dánh sách map với key là mã đơn
        for (TTDonCaNhan don : FakeData.layDSDonCaNhan_Test()) {
            String maDon = don.getMaDonCaNhan();
            mapDonCaNhan.put(maDon, don);
        }
        
        for (TTDonTapThe don : FakeData.layDSDonTapThe_Test()) {
            String maDon = don.getMaDonTapThe();
            mapDonTapThe.put(maDon, don);
        }
    }
    public static void capNhatFileCaNhan(){
        String pathFile = "src\\data\\DSDonCaNhan.txt";
        //Cập nhật danh sách vào file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))) {
            // Ghi dữ liệu vào file
            for (TTDonCaNhan value : mapDonCaNhan.values()) {
                System.out.println(value.toString());
                writer.write(value.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void capNhatFileTapThe(){
        String pathFile = "src\\data\\DSDonTapThe.txt";
        //Cập nhật danh sách vào file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))) {
            // Ghi dữ liệu vào file
            for (TTDonTapThe value : mapDonTapThe.values()) {
                System.out.println(value.toString());
                writer.write(value.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        for(TTDonTapThe don : FakeData.layDSDonTapThe_Test()){
            System.out.println(don.getLyDo());
        }
        
    }
}
