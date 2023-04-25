/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vinh
 */
public class HoaDon {
    private int id;
    private String soThe;
    private String tenChuThe;
    private String CVC;
    private Date thangNamHetHan;
    private int tienPhaiDong;
    private Boolean trangThai;
    private Date ngayYeuCau;
    private Date ngayThanhToan;
    private NguoiDung nguoiDung;
    private ArrayList <HoaDonChiTiet> dsHoaDonChiTiet;
    private NganHang nganHang;

    public HoaDon(int id, String soThe, String tenChuThe, String CVC, Date thangNamHetHan, int tienPhaiDong, Boolean trangThai, Date ngayYeuCau, Date ngayThanhToan, NguoiDung nguoiDung, ArrayList<HoaDonChiTiet> dsHoaDonChiTiet, NganHang nganHang) {
        this.id = id;
        this.soThe = soThe;
        this.tenChuThe = tenChuThe;
        this.CVC = CVC;
        this.thangNamHetHan = thangNamHetHan;
        this.tienPhaiDong = tienPhaiDong;
        this.trangThai = trangThai;
        this.ngayYeuCau = ngayYeuCau;
        this.ngayThanhToan = ngayThanhToan;
        this.nguoiDung = nguoiDung;
        this.dsHoaDonChiTiet = dsHoaDonChiTiet;
        this.nganHang = nganHang;
    }

    public HoaDon(){
        dsHoaDonChiTiet=new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public String getTenChuThe() {
        return tenChuThe;
    }

    public void setTenChuThe(String tenChuThe) {
        this.tenChuThe = tenChuThe;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public Date getThangNamHetHan() {
        return thangNamHetHan;
    }

    public void setThangNamHetHan(Date thangNamHetHan) {
        this.thangNamHetHan = thangNamHetHan;
    }

    public int getTienPhaiDong() {
        return tienPhaiDong;
    }
    
    public void resertTrangThai(){
        for(int i=0; i<dsHoaDonChiTiet.size(); i++){
            dsHoaDonChiTiet.get(i).setTrangThai(false);
        }
    }

    public void setTienPhaiDong(int tienPhaiDong) {
        this.tienPhaiDong = tienPhaiDong;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayYeuCau() {
        return ngayYeuCau;
    }

    public void setNgayYeuCau(Date ngayYeuCau) {
        this.ngayYeuCau = ngayYeuCau;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public ArrayList<HoaDonChiTiet> getDsHoaDonChiTiet() {
        return dsHoaDonChiTiet;
    }

    public void setDsHoaDonChiTiet(ArrayList<HoaDonChiTiet> dsHoaDonChiTiet) {
        this.dsHoaDonChiTiet = dsHoaDonChiTiet;
    }

    public NganHang getNganHang() {
        return nganHang;
    }

    public void setNganHang(NganHang nganHang) {
        this.nganHang = nganHang;
    }
    
    
}
