package model;

public class SinhVienTapThe {
    private String maSV;
    private String hoTen;
    private String tenNganh;

    public SinhVienTapThe() {
    }

    public SinhVienTapThe(String maSV, String hoTen, String tenNganh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tenNganh = tenNganh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    @Override
    public String toString() {
        return  maSV + "," + hoTen + "," + tenNganh;
    }
    
}
