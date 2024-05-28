/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class TaiKhoan {
    private String maTK;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String maTK, String matKhau) {
        this.maTK = maTK;
        this.matKhau = matKhau;
    }

    public String getMaTK() {
        return maTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }
}
