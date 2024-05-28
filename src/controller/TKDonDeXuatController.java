/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DonDeXuat;
import model.FakeData;

/**
 *
 * @author ADMIN
 */
public class TKDonDeXuatController {
    //Lấy ra danh sách đơn đăng ký

    public static List<DonDeXuat> listDon = FakeData.layDonDeXuat_Test();

    public static DonDeXuat donTheoMaDon(String maDon) {
        for (DonDeXuat x : listDon) {
            if (x.getMaDon().equals(maDon)) {
                return x;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        listDon.forEach(System.out::println);
    }

}
