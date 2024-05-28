/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class Nganh {
    private String maNganh;
    private String tenNganh;
    private String maKhoa;
    private int soLopHP;

    public Nganh() {
    }

    public Nganh(String maNganh, String tenNganh, String maKhoa) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maKhoa = maKhoa;
        this.soLopHP = laySoLopHPTheoNganh(maNganh, FakeData.layHocPhan_Test());
    }
    
     public static int laySoLopHPTheoNganh(String maNganh, List<HocPhan> dsHocPhan){
        int soHP = 0;
        for(HocPhan hp : dsHocPhan){
            if(hp.getMaNganh().equals(maNganh)){
                soHP++;
            }
        }
        return soHP;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public int getSoLopHP() {
        return soLopHP;
    }

    public void setSoLopHP(int soLopHP) {
        this.soLopHP = soLopHP;
    }

    @Override
    public String toString() {
        return maNganh + "," + tenNganh + "," + maKhoa;
    }
    
}
