/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.BieuMauTinhThue;
import model.NguoiDung;
import model.ToKhaiThue;

/**
 *
 * @author Vinh
 */
public class ToKhaiThueDAO extends DAO{
    public ToKhaiThueDAO(){
        super();
    }
    
    public ArrayList<ToKhaiThue> danhSachToKhaiChuaDong(int idNguoiDung){
        ArrayList <ToKhaiThue> ds=new ArrayList<>();
        String sql = "SELECT * FROM tokhaithue, nguoidung WHERE idHoaDon IS NULL\n" +
                    "AND idNguoiDung=idNguoiDongThue AND idNguoiDongThue=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idNguoiDung);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ToKhaiThue temp=new ToKhaiThue();
                temp.setId(rs.getInt("id"));
                temp.setKyTinhThue(rs.getString("kyTinhThue"));
                temp.setThoiGianBatDau(rs.getString("thoiGianBatDau"));
                temp.setLoaiToKhai(rs.getString("loaiToKhai"));
                temp.setDoiTuongDong(rs.getString("doiTuongDong"));
                temp.setTienLuong(rs.getInt("tienLuong"));
                temp.setTienDauTu(rs.getInt("tienDauTu"));
                temp.setTienKinhDoanh(rs.getInt("tienKinhDoanh"));
                temp.setTienBatDongSan(rs.getInt("tienBatDongSan"));
                temp.setTienTrungThuong(rs.getInt("tienTrungThuong"));
                temp.setSoNguoiPhuThuoc(rs.getInt("soNguoiPhuThuoc"));
                temp.setTienTuThien(rs.getInt("tienTuThien"));
                temp.setTienDongBaoHiem(rs.getInt("tienDongBaoHiem"));
                temp.setTienHuuTri(rs.getInt("tienHuuTri"));
                temp.setNgayNop(rs.getDate("ngayNop"));
                ds.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public boolean layThongTinToKhaiThue(ToKhaiThue toKhaiThue){
        String sql = "SELECT ten, maSoThue FROM tokhaithue, nguoidung, nguoiyeucau, nguoidongthue\n" +
                    "WHERE tokhaithue.idNguoiDung=nguoidung.idNguoiDongThue\n" +
                    "AND nguoidung.idNguoiDongThue=nguoidongthue.idNguoiYeuCau\n" +
                    "AND nguoidongthue.idNguoiYeuCau=nguoiyeucau.id\n" +
                    "AND tokhaithue.id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, toKhaiThue.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NguoiDung nguoiDung=new NguoiDung();
                nguoiDung.setMaSoThue(rs.getInt("maSoThue"));
                nguoiDung.setTen(rs.getString("ten"));
                toKhaiThue.setNguoiDung(nguoiDung);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
//    public static void main(String[] args) {
//        ToKhaiThueDAO dao=new ToKhaiThueDAO();
////        ToKhaiThue toKhaiThue=new ToKhaiThue();
////        toKhaiThue.setId(1);
////        dao.layThongTinToKhaiThue(toKhaiThue);
////        System.out.println(toKhaiThue.getNguoiDung().getTen());
//        ArrayList <ToKhaiThue> ds=dao.danhSachToKhaiChuaDong(1);
//        BieuMauTinhThue temp=new BieuMauTinhThue(ds.get(0));
//        System.out.println(temp.getToKhaiThue().getDoiTuongDong());
//        System.out.println(temp.getToKhaiThue().getDoiTuongDong().compareTo("Cư trú có hợp đồng >= 3 tháng"));
//    }
}
