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
public class ToKhaiDangKiMST {
    private int id;
    private String maSoThueCoQuanChiTra;
    private Date ngayNop;
    private Boolean trangThai;
    private NguoiYeuCau nguoiYeuCau;

    public ToKhaiDangKiMST(int id, String maSoThueCoQuanChiTra, Date ngayNop, Boolean trangThai, NguoiYeuCau nguoiYeuCau) {
        this.id = id;
        this.maSoThueCoQuanChiTra = maSoThueCoQuanChiTra;
        this.ngayNop = ngayNop;
        this.trangThai = trangThai;
        this.nguoiYeuCau = nguoiYeuCau;
    }

    public ToKhaiDangKiMST() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSoThueCoQuanChiTra() {
        return maSoThueCoQuanChiTra;
    }

    public void setMaSoThueCoQuanChiTra(String maSoThueCoQuanChiTra) {
        this.maSoThueCoQuanChiTra = maSoThueCoQuanChiTra;
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

    public NguoiYeuCau getNguoiYeuCau() {
        return nguoiYeuCau;
    }

    public void setNguoiYeuCau(NguoiYeuCau nguoiYeuCau) {
        this.nguoiYeuCau = nguoiYeuCau;
    }
    
    
}
