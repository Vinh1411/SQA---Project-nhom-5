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
public class NguoiYeuCau {
    private int id;
    protected String ten;
    private String email;
    protected Date ngayThangNamSinh;
    protected String gioiTinh;
    protected String quocTich;
    protected String diaChiCuTru;
    private String dienThoai;
    protected GiayToCaNhan giayTo;
    protected DiaChi diaChi;

    public NguoiYeuCau(){
        
    }
    
    public NguoiYeuCau(int id, String ten, String email, Date ngayThangNamSinh, String gioiTinh, String quocTich, String diaChiCuTru, String dienThoai, GiayToCaNhan giayTo, DiaChi diaChi) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.ngayThangNamSinh = ngayThangNamSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.diaChiCuTru = diaChiCuTru;
        this.dienThoai = dienThoai;
        this.giayTo = giayTo;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
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
