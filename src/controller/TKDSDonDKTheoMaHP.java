/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FakeData;
import model.Nganh;
import model.TTDonDangKy;

/**
 *
 * @author Le Thi Ngoc
 */
public class TKDSDonDKTheoMaHP {
    //Lấy ra danh sách đơn đăng ký
    static List<TTDonDangKy> listDon = new ArrayList<>(FakeData.taoDSDonDangKy_Test());
    static Map<String, List<TTDonDangKy>> mapDon = new HashMap<>();
    
    static {
        tongHopTheoMaHP();
    }
    
    public static void tongHopTheoMaHP() {
        for (TTDonDangKy don : listDon) {
            if(don.getTrangThai().equals("Chưa duyệt")){
                String maHP = don.getMaHP();
                if (!mapDon.containsKey(maHP)) {
                    mapDon.put(maHP, new ArrayList<>());
                }
                mapDon.get(maHP).add(don);
            }
        }
    }
    
    public static List<TTDonDangKy> dsDonTheoMaHP(String mahp){
        List<TTDonDangKy> dons = new ArrayList<>();
        for (Map.Entry<String, List<TTDonDangKy>> entry : mapDon.entrySet()) {
            if(entry.getKey().equals(mahp)){
                List<TTDonDangKy> danhSachTheoMaHP = entry.getValue();
                for (TTDonDangKy don : danhSachTheoMaHP) {
                    if(don.getMaHP().equals(mahp)){
                        dons.add(don);
                    }
                }
            }
        }
        return dons;
    }
    
    public static void main(String[] args) {
        FakeData.taoDSDonDangKy_Test().forEach(System.out::println);
        tongHopTheoMaHP();
        System.out.println("Kết quả tìm kiếm");
        dsDonTheoMaHP("IT6017").forEach(System.out::println);
    }
}
