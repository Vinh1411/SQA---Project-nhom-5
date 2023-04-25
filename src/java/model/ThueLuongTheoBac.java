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
public class ThueLuongTheoBac {
    private long soTien;
    private long tienPhaiDong;

    public ThueLuongTheoBac(long soTien, long tienPhaiDong) {
        this.soTien = soTien;
        this.tienPhaiDong = tienPhaiDong;
    }

    
    
    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public long getTienPhaiDong() {
        return tienPhaiDong;
    }

    public void setTienPhaiDong(long tienPhaiDong) {
        this.tienPhaiDong = tienPhaiDong;
    }
    
}
