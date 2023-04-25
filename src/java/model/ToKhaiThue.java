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
public class ToKhaiThue {
    private int id;
    private String kyTinhThue;
    private String thoiGianBatDau;
    private String loaiToKhai;
    private String doiTuongDong;
    private int tienLuong;
    private int tienDauTu;
    private int tienKinhDoanh;
    private int tienBatDongSan;
    private int tienTrungThuong;
    private int soNguoiPhuThuoc;
    private int tienTuThien;
    private int tienDongBaoHiem;
    private int tienHuuTri;
    private Date ngayNop;
    private Boolean trangThai;
    private NguoiDung nguoiDung;
    
    public ToKhaiThue(int id, String kyTinhThue, String thoiGianBatDau, String loaiToKhai, int tienLuong, int tienDauTu, int tienKinhDoanh, int tienBatDongSan, int tienTrungThuong, int soNguoiPhuThuoc, int tienTuThien, int tienDongBaoHiem, int tienHuuTri, Date ngayNop, Boolean trangThai, NguoiDung nguoiDung) {
        this.id = id;
        this.kyTinhThue = kyTinhThue;
        this.thoiGianBatDau = thoiGianBatDau;
        this.loaiToKhai = loaiToKhai;
        this.doiTuongDong = "TTNCN voi CN";
        this.tienLuong = tienLuong;
        this.tienDauTu = tienDauTu;
        this.tienKinhDoanh = tienKinhDoanh;
        this.tienBatDongSan = tienBatDongSan;
        this.tienTrungThuong = tienTrungThuong;
        this.soNguoiPhuThuoc = soNguoiPhuThuoc;
        this.tienTuThien = tienTuThien;
        this.tienDongBaoHiem = tienDongBaoHiem;
        this.tienHuuTri = tienHuuTri;
        this.ngayNop = ngayNop;
        this.trangThai = trangThai;
        this.nguoiDung = nguoiDung;
    }

    public ToKhaiThue(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKyTinhThue() {
        return kyTinhThue;
    }

    public void setKyTinhThue(String kyTinhThue) {
        this.kyTinhThue = kyTinhThue;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getLoaiToKhai() {
        return loaiToKhai;
    }

    public void setLoaiToKhai(String loaiToKhai) {
        this.loaiToKhai = loaiToKhai;
    }

    public String getDoiTuongDong() {
        return doiTuongDong;
    }

    public void setDoiTuongDong(String doiTuongDong) {
        this.doiTuongDong = doiTuongDong;
    }

    public int getTienLuong() {
        return tienLuong;
    }

    public void setTienLuong(int tienLuong) {
        this.tienLuong = tienLuong;
    }

    public int getTienDauTu() {
        return tienDauTu;
    }

    public void setTienDauTu(int tienDauTu) {
        this.tienDauTu = tienDauTu;
    }

    public int getTienKinhDoanh() {
        return tienKinhDoanh;
    }

    public void setTienKinhDoanh(int tienKinhDoanh) {
        this.tienKinhDoanh = tienKinhDoanh;
    }

    public int getTienBatDongSan() {
        return tienBatDongSan;
    }

    public void setTienBatDongSan(int tienBatDongSan) {
        this.tienBatDongSan = tienBatDongSan;
    }

    public int getTienTrungThuong() {
        return tienTrungThuong;
    }

    public void setTienTrungThuong(int tienTrungThuong) {
        this.tienTrungThuong = tienTrungThuong;
    }

    public int getSoNguoiPhuThuoc() {
        return soNguoiPhuThuoc;
    }

    public void setSoNguoiPhuThuoc(int soNguoiPhuThuoc) {
        this.soNguoiPhuThuoc = soNguoiPhuThuoc;
    }

    public int getTienTuThien() {
        return tienTuThien;
    }

    public void setTienTuThien(int tienTuThien) {
        this.tienTuThien = tienTuThien;
    }

    public int getTienDongBaoHiem() {
        return tienDongBaoHiem;
    }

    public void setTienDongBaoHiem(int tienDongBaoHiem) {
        this.tienDongBaoHiem = tienDongBaoHiem;
    }

    public int getTienHuuTri() {
        return tienHuuTri;
    }

    public void setTienHuuTri(int tienHuuTri) {
        this.tienHuuTri = tienHuuTri;
    }

    public Date getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
    
}
