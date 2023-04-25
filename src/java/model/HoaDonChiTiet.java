/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vinh
 */
public class HoaDonChiTiet extends BieuMauTinhThue{
    private boolean trangThai;
    
    public HoaDonChiTiet(){
        super();
    }
    
    public HoaDonChiTiet(ToKhaiThue toKhaiThue) {
        super(toKhaiThue);
        trangThai=false;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public ToKhaiThue getToKhaiThue() {
        return toKhaiThue;
    }

    public void setToKhaiThue(ToKhaiThue toKhaiThue) {
        this.toKhaiThue = toKhaiThue;
    }

    public long getTongTienTruocThue() {
        return tongTienTruocThue;
    }

    public void setTongTienTruocThue(int tongTienTruocThue) {
        this.tongTienTruocThue = tongTienTruocThue;
    }

    public long getTongTienDuocMienGiam() {
        return tongTienDuocMienGiam;
    }

    public void setTongTienDuocMienGiam(int tongTienDuocMienGiam) {
        this.tongTienDuocMienGiam = tongTienDuocMienGiam;
    }

    public long getTongTienThuePhaiDong() {
        return tongTienThuePhaiDong;
    }

    public void setTongTienThuePhaiDong(int tongTienThuePhaiDong) {
        this.tongTienThuePhaiDong = tongTienThuePhaiDong;
    }
    
   
}
