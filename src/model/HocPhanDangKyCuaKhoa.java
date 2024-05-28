/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NGUYEN VAN MANH
 */
public class HocPhanDangKyCuaKhoa {
    private String maHP;
    private String tenHP;

    public HocPhanDangKyCuaKhoa() {
    }

    public HocPhanDangKyCuaKhoa(String maHP, String tenHP) {
        this.maHP = maHP;
        this.tenHP = tenHP;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.maHP);
        hash = 37 * hash + Objects.hashCode(this.tenHP);
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
        final HocPhanDangKyCuaKhoa other = (HocPhanDangKyCuaKhoa) obj;
        if (!Objects.equals(this.maHP, other.maHP)) {
            return false;
        }
        return Objects.equals(this.tenHP, other.tenHP);
    }

public static List<HocPhanDangKyCuaKhoa> readHocPhanFromFile(String filePath) {
        List<HocPhanDangKyCuaKhoa> danhSachHocPhan = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    HocPhanDangKyCuaKhoa hocPhan = new HocPhanDangKyCuaKhoa();
                    hocPhan.setMaHP(parts[0]);
                    hocPhan.setTenHP(parts[1]);

                    danhSachHocPhan.add(hocPhan);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần
        }

        return danhSachHocPhan;
    }


    
    @Override
    public String toString() {
        return "HocPhanDangKyCuaKhoa{" + "maHP=" + maHP + ", tenHP=" + tenHP + '}';
    }
    
    
}
