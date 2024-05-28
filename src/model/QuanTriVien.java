/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NGUYEN VAN MANH
 */

public class QuanTriVien{
    private String maQTV;
    private String tenQTV;
    
    public QuanTriVien() {
    }

    public QuanTriVien(String tenQTV) {
        this.tenQTV = tenQTV;
    }

    public QuanTriVien(String maQTV, String tenQTV) {
        this.maQTV = maQTV;
        this.tenQTV = tenQTV;
    }


    public String getMaQTV() {
        return maQTV;
    }


    public String getTenQTV() {
        return tenQTV;
    }

    public void setMaQTV(String maQTV) {
        this.maQTV = maQTV;
    }

    public void setTenQTV(String tenQTV) {
        this.tenQTV = tenQTV;
    }
}
