/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.NguoiDung;

/**
 *
 * @author Vinh
 */
public class NguoiDungDAO extends DAO{
    public NguoiDungDAO() {
        super();
    }
    
    public boolean kiemTraDangNhap(NguoiDung nguoiDung){
        boolean result = false;
        String sql = "SELECT nyc.ten, nyc.id\n" +
                    "FROM NguoiDung nd, NguoiDongThue ndt, NguoiYeuCau nyc\n" +
                    "WHERE ndt.maSoThue = ? AND nd.matKhau = ? AND nd.trangThaiKichHoat=1\n" +
                    "AND nd.idNguoiDongThue=ndt.idNguoiYeuCau\n" +
                    "AND ndt.idNguoiYeuCau=id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nguoiDung.getMaSoThue());
            ps.setString(2, nguoiDung.getMatKhau());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nguoiDung.setTen(rs.getString("ten"));
                nguoiDung.setId(rs.getInt("id"));
                result = true;
            }
        } catch (SQLException e) {
        }
        return result;
    }
    
    public boolean themTaiKhoan(NguoiDung nguoiDung){
        String sqlNguoiDongThue = "SELECT idNguoiYeuCau FROM nguoidongthue WHERE maSoThue=?";
        String sql = "INSERT INTO nguoidung (idNguoiDongThue, email, matKhau, soDienThoai, trangThaiKichHoat) VALUES(?, ?, ?, ?, ?)";
        boolean result = true;
        try {
//            con.setAutoCommit(false);
            PreparedStatement ps1 = con.prepareStatement(sqlNguoiDongThue, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1, nguoiDung.getMaSoThue());
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                nguoiDung.setId(rs1.getInt("idNguoiYeuCau"));
                PreparedStatement ps2 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps2.setInt(1, nguoiDung.getId());
                ps2.setString(2, nguoiDung.getEmail());
                ps2.setString(3, nguoiDung.getMatKhau());
                ps2.setString(4, nguoiDung.getSoDienThoai());
                ps2.setBoolean(5, false);
                ps2.executeUpdate();
                ResultSet generatedKeys = ps2.getGeneratedKeys();
            }
//            con.commit();
        } catch (Exception e1) {
            result = false;
//            try{
//                con.rollback();
//            }
//            catch(SQLException e2){
//                e2.printStackTrace();
//            }
            e1.printStackTrace();
        }finally{
//            try{
//                con.setAutoCommit(true);
//            }catch(Exception e3){
//                e3.printStackTrace();
//            }
        }
        return result;
    }
//    public static void main(String[] args) {
//        NguoiDungDAO nguoiDungDAO=new NguoiDungDAO();
//        NguoiDung nguoiDung=new NguoiDung();
//        nguoiDung.setMaSoThue(1);
//        nguoiDung.setMatKhau("vinh123");
//        System.out.println(nguoiDungDAO.kiemTraDangNhap(nguoiDung));
//    }
}
