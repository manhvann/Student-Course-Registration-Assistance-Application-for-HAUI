/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private int soNganh;
    
    public Khoa() {
    }

    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.soNganh = laySoNganhTheoKhoa(this.maKhoa, FakeData.layNganh_Test());
    }
    
    public static int laySoNganhTheoKhoa(String maKhoa, List<Nganh> dsNganh){
        int soNganh = 0;
        for(Nganh hp : dsNganh){
            if(hp.getMaKhoa().equals(maKhoa)){
                soNganh++;
            }
        }
        return soNganh;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public int getSoNganh() {
        return soNganh;
    }

    public void setSoNganh(int soNganh) {
        this.soNganh = soNganh;
    }

    @Override
    public String toString() {
        return maKhoa + "," + tenKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.maKhoa);
        hash = 47 * hash + Objects.hashCode(this.tenKhoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Khoa other = (Khoa) obj;
        if (!Objects.equals(this.maKhoa, other.maKhoa)) {
            return false;
        }
        return Objects.equals(this.tenKhoa, other.tenKhoa);
    }
    
}
