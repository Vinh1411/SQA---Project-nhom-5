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
public class DiaChi {
    private int id;
    private String soNha;
    private String quocGia;
    private String thanhPho;
    private String quanHuyen;

    public DiaChi(int id, String soNha, String quocGia, String thanhPho, String quanHuyen) {
        this.id = id;
        this.soNha = soNha;
        this.quocGia = quocGia;
        this.thanhPho = thanhPho;
        this.quanHuyen = quanHuyen;
    }

    public DiaChi() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }
    
}
