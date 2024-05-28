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
public class TTDonTapThe {
    private String maDonTapThe;
    private String maSV;
    private String tenHP;
    private String maHP;
    private String lyDo;
    private List<SinhVienTapThe> dsSV;
    private String trangThai;

    public TTDonTapThe() {
    }

    public TTDonTapThe(String maDonTapThe,String maSV, String maHP, String tenHP, String lyDo, List<SinhVienTapThe> dsSV, String trangThai) {
        this.maDonTapThe = maDonTapThe;
        this.maSV = maSV;
        this.tenHP = tenHP;
        this.maHP = maHP;
        this.lyDo = lyDo;
        this.dsSV = dsSV;
        this.trangThai = trangThai;
    }

    public String getMaDonTapThe() {
        return maDonTapThe;
    }

    public void setMaDonTapThe(String maDonTapThe) {
        this.maDonTapThe = maDonTapThe;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }


    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public List<SinhVienTapThe> getDsSV() {
        return dsSV;
    }

    public void setDsSV(List<SinhVienTapThe> dsSV) {
        this.dsSV = dsSV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
     public void addSinhVienTapThe(SinhVienTapThe sinhVienTapThe) {
        dsSV.add(sinhVienTapThe);
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(maDonTapThe).append(",")
                .append(maSV).append(",")
                .append(maHP).append(",")
                .append(tenHP).append(",")
                .append(lyDo);
        for (SinhVienTapThe sv:dsSV){
            result.append(",").append(sv.toString());
        }

        result.append(",").append(trangThai);
        return result.toString();
    }
}
