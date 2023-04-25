/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Vinh
 */
public class NguoiDongThue extends NguoiYeuCau{
    
    protected int maSoThue;
    
    public NguoiDongThue(int id, String ten, String email, Date ngayThangNamSinh, String gioiTinh, String quocTich, String diaChiCuTru, String dienThoai, GiayToCaNhan giayTo, DiaChi diaChi, int maSoThue) {
        super(id, ten, email, ngayThangNamSinh, gioiTinh, quocTich, diaChiCuTru, dienThoai, giayTo, diaChi);
        this.maSoThue=maSoThue;
    }
    
    public NguoiDongThue(){
        
    }

    public int getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(int maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayThangNamSinh() {
        return ngayThangNamSinh;
    }

    public void setNgayThangNamSinh(Date ngayThangNamSinh) {
        this.ngayThangNamSinh = ngayThangNamSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getDiaChiCuTru() {
        return diaChiCuTru;
    }

    public void setDiaChiCuTru(String diaChiCuTru) {
        this.diaChiCuTru = diaChiCuTru;
    }

    public GiayToCaNhan getGiayTo() {
        return giayTo;
    }

    public void setGiayTo(GiayToCaNhan giayTo) {
        this.giayTo = giayTo;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
