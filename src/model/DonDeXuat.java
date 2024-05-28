/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Le Thi Ngoc
 */

public class DonDeXuat {
    private String maDon;
    private String cauHoi1;
    private String cauHoi2;
    private String cauHoi3;
    private String cauHoi4;
    private String gopY;

    public DonDeXuat() {
    }

    
    public DonDeXuat(String maDon, String cauHoi1, String cauHoi2, String cauHoi3, String cauHoi4, String gopY) {
        this.maDon = maDon;
        this.cauHoi1 = cauHoi1;
        this.cauHoi2 = cauHoi2;
        this.cauHoi3 = cauHoi3;
        this.cauHoi4 = cauHoi4;
        this.gopY = gopY;
    }

    public String getMaDon() {
        return maDon;
    }

    public void setMaDon(String maDon) {
        this.maDon = maDon;
    }

    public String getCauHoi1() {
        return cauHoi1;
    }

    public void setCauHoi1(String cauHoi1) {
        this.cauHoi1 = cauHoi1;
    }

    public String getCauHoi2() {
        return cauHoi2;
    }

    public void setCauHoi2(String cauHoi2) {
        this.cauHoi2 = cauHoi2;
    }

    public String getCauHoi3() {
        return cauHoi3;
    }

    public void setCauHoi3(String cauHoi3) {
        this.cauHoi3 = cauHoi3;
    }

    public String getCauHoi4() {
        return cauHoi4;
    }

    public void setCauHoi4(String cauHoi4) {
        this.cauHoi4 = cauHoi4;
    }

    public String getGopY() {
        return gopY;
    }

    public void setGopY(String gopY) {
        this.gopY = gopY;
    }


 public static List<DonDeXuat> readDSDonFromFile(String filePath) {
        List<DonDeXuat> dsDon = new ArrayList<>();

        try {
            FileReader rd = new FileReader(filePath);
            BufferedReader br = new BufferedReader(rd);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] field = line.split(",");
                String maDon = field[0];
                String cauHoi1 = field[1];
                String cauHoi2 = field[2];
                String cauHoi3 = field[3];
                String cauHoi4 = field[4];
                String gopY = field[5];
                DonDeXuat ddx = new DonDeXuat( maDon, cauHoi1, cauHoi2, cauHoi3, cauHoi4, gopY);
                dsDon.add(ddx);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            JOptionPane.showInputDialog("Lỗi đọc file");
        }
        return dsDon;
    }
    
     


    @Override
    public String toString() {
        return "DonDeXuat{" + "maDon=" + maDon + ", cauHoi1=" + cauHoi1 + ", cauHoi2=" + cauHoi2 + ", cauHoi3=" + cauHoi3 + ", cauHoi4=" + cauHoi4 + ", gopY=" + gopY + '}';
    }

}
