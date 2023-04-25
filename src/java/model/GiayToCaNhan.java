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
public class GiayToCaNhan {
    private int id;
    private String loai;
    private Date ngayCap;
    private String soGiayTo;
    private String duongDanAnh;
    private String coQuanCap;

    public GiayToCaNhan(int id, String loai, Date ngayCap, String soGiayTo, String duongDanAnh, String coQuanCap) {
        this.id = id;
        this.loai = loai;
        this.ngayCap = ngayCap;
        this.soGiayTo = soGiayTo;
        this.duongDanAnh = duongDanAnh;
        this.coQuanCap = coQuanCap;
    }

    public GiayToCaNhan() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getSoGiayTo() {
        return soGiayTo;
    }

    public void setSoGiayTo(String soGiayTo) {
        this.soGiayTo = soGiayTo;
    }

    public String getDuongDanAnh() {
        return duongDanAnh;
    }

    public void setDuongDanAnh(String duongDanAnh) {
        this.duongDanAnh = duongDanAnh;
    }

    public String getCoQuanCap() {
        return coQuanCap;
    }

    public void setCoQuanCap(String coQuanCap) {
        this.coQuanCap = coQuanCap;
    }
    
    
}
