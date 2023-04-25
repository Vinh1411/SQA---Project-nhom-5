/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DAO;
import dao.HoaDonDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.BieuMauTinhThue;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NganHang;
import model.NguoiDung;
import model.ToKhaiThue;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Vinh
 */
public class HoaDonDAOTest {
    HoaDonDAO hoaDonDAO=new HoaDonDAO();
    
    //Hoa don sai thong tin, nguoi dung khong ton tai
    @Test
    public void testThemHoaDonException1(){
        Connection con=DAO.con;
        try{
            HoaDon hoaDon=new HoaDon();
            hoaDon.setSoThe("0123456789");
            hoaDon.setTenChuThe("Vinh");
            hoaDon.setCVC("123");
            hoaDon.setThangNamHetHan(new Date());
            hoaDon.setTienPhaiDong(0);
            hoaDon.setTrangThai(Boolean.TRUE);
            hoaDon.setNgayYeuCau(new Date());
            hoaDon.setNgayThanhToan(new Date());
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setId(-1);
            hoaDon.setNguoiDung(nguoiDung);
            NganHang nganHang=new NganHang(1, "scb", "ngan hang cong thuong");
            hoaDon.setNganHang(nganHang);
            con.setAutoCommit(false);
            String sql="DELETE FROM hoadon";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
            boolean result=hoaDonDAO.themHoaDon(hoaDon);
            sql="SELECT COUNT(*) AS COUNT FROM hoadon";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Assert.assertEquals(rs.getInt("COUNT"), 0);
            }
            Assert.assertEquals(result, false);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return;
    }
    
    //Hoa don sai thong tin, ngan hang khong ton tai
    @Test
    public void testThemHoaDonException2(){
        Connection con=DAO.con;
        try{
            HoaDon hoaDon=new HoaDon();
            hoaDon.setSoThe("0123456789");
            hoaDon.setTenChuThe("Vinh");
            hoaDon.setCVC("123");
            hoaDon.setThangNamHetHan(new Date());
            hoaDon.setTienPhaiDong(0);
            hoaDon.setTrangThai(Boolean.TRUE);
            hoaDon.setNgayYeuCau(new Date());
            hoaDon.setNgayThanhToan(new Date());
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setId(2);
            hoaDon.setNguoiDung(nguoiDung);
            NganHang nganHang=new NganHang(-1, "scb", "ngan hang cong thuong");
            hoaDon.setNganHang(nganHang);
            con.setAutoCommit(false);
            String sql="DELETE FROM hoadon";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
            boolean result=hoaDonDAO.themHoaDon(hoaDon);
            sql="SELECT COUNT(*) AS COUNT FROM hoadon";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Assert.assertEquals(rs.getInt("COUNT"), 0);
            }
            Assert.assertEquals(result, false);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return;
    }
    
    //Hóa đơn không thanh toán cho bất kỳ một kỳ thuế nào
    @Test
    public void testThemHoaDonException3(){
        Connection con=DAO.con;
        try{
            HoaDon hoaDon=new HoaDon();
            hoaDon.setSoThe("0123456789");
            hoaDon.setTenChuThe("Vinh");
            hoaDon.setCVC("123");
            hoaDon.setThangNamHetHan(new Date());
            hoaDon.setTienPhaiDong(0);
            hoaDon.setTrangThai(Boolean.TRUE);
            hoaDon.setNgayYeuCau(new Date());
            hoaDon.setNgayThanhToan(new Date());
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setId(2);
            hoaDon.setNguoiDung(nguoiDung);
            NganHang nganHang=new NganHang(1, "scb", "ngan hang cong thuong");
            hoaDon.setNganHang(nganHang);
            con.setAutoCommit(false);
            String sql="DELETE FROM hoadon";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
            boolean result=hoaDonDAO.themHoaDon(hoaDon);
            sql="SELECT COUNT(*) AS COUNT FROM hoadon";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Assert.assertEquals(rs.getInt("COUNT"), 0);
            }
            Assert.assertEquals(result, false);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return;
    }
     
    //Hóa đơn thanh toán cho 1 kỳ tính thuế.
    @Test
    public void testThemHoaDonException4(){
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            HoaDon hoaDon=new HoaDon();
            hoaDon.setSoThe("0123456789");
            hoaDon.setTenChuThe("Vinh");
            hoaDon.setCVC("123");
            hoaDon.setThangNamHetHan(new Date());
            hoaDon.setTienPhaiDong(0);
            hoaDon.setTrangThai(Boolean.TRUE);
            hoaDon.setNgayYeuCau(new Date());
            hoaDon.setNgayThanhToan(new Date());
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setId(2);
            hoaDon.setNguoiDung(nguoiDung);
            NganHang nganHang=new NganHang(1, "scb", "ngan hang cong thuong");
            hoaDon.setNganHang(nganHang);
            ArrayList <HoaDonChiTiet> dsHoaDonChiTiet=new ArrayList<>();
            String sql="INSERT INTO tokhaithue (kyTinhThue, thoiGianBatDau, loaiToKhai, doiTuongDong, tienLuong, tienDauTu, tienKinhDoanh, tienBatDongSan, "
                        + "tienTrungThuong, soNguoiPhuThuoc, tienTuThien, tienDongBaoHiem, tienHuuTri, ngayNop, trangThai, idNguoiDung)\n" +
                        "VALUES ('Theo tháng', '1/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-01-01', 1, 2)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            ToKhaiThue toKhaiThue=new ToKhaiThue();
            if (generatedKeys.next()) {
                toKhaiThue.setId(generatedKeys.getInt(1));
                HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet();
                hoaDonChiTiet.setToKhaiThue(toKhaiThue);
                hoaDonChiTiet.setTrangThai(true);
                dsHoaDonChiTiet.add(hoaDonChiTiet);
                hoaDon.setDsHoaDonChiTiet(dsHoaDonChiTiet);
                boolean result=hoaDonDAO.themHoaDon(hoaDon);
                Assert.assertEquals(result, true);
                sql="SELECT id FROM hoadon ORDER BY ngayYeuCau DESC LIMIT 1";
                ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery(sql);
                if(rs.next()){
                    Assert.assertEquals(hoaDon.getId(), rs.getInt("id"));
                    sql="SELECT idHoaDon FROM tokhaithue WHERE id="+toKhaiThue.getId();
                    ps=con.prepareStatement(sql);
                    rs=ps.executeQuery(sql);
                    if(rs.next()){
                        Assert.assertEquals(hoaDon.getId(), rs.getInt("idHoaDon"));
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return;
    }
    
    
    //Hóa đơn thanh toán cho nhiều hơn 1 kỳ tính thuế.
    @Test
    public void testThemHoaDonException5(){
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            HoaDon hoaDon=new HoaDon();
            hoaDon.setSoThe("0123456789");
            hoaDon.setTenChuThe("Vinh");
            hoaDon.setCVC("123");
            hoaDon.setThangNamHetHan(new Date());
            hoaDon.setTienPhaiDong(0);
            hoaDon.setTrangThai(Boolean.TRUE);
            hoaDon.setNgayYeuCau(new Date());
            hoaDon.setNgayThanhToan(new Date());
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setId(2);
            hoaDon.setNguoiDung(nguoiDung);
            NganHang nganHang=new NganHang(1, "scb", "ngan hang cong thuong");
            hoaDon.setNganHang(nganHang);
            ArrayList <HoaDonChiTiet> dsHoaDonChiTiet=new ArrayList<>();
            String sql="INSERT INTO tokhaithue (kyTinhThue, thoiGianBatDau, loaiToKhai, doiTuongDong, tienLuong, tienDauTu, tienKinhDoanh, tienBatDongSan, "
                        + "tienTrungThuong, soNguoiPhuThuoc, tienTuThien, tienDongBaoHiem, tienHuuTri, ngayNop, trangThai, idNguoiDung)\n" +
                        "VALUES ('Theo tháng', '1/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-01-01', 1, 2), "
                    + "('Theo tháng', '2/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-02-01', 1, 2)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            while (generatedKeys.next()) {
                ToKhaiThue toKhaiThue=new ToKhaiThue();
                toKhaiThue.setId(generatedKeys.getInt(1));
                HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet();
                hoaDonChiTiet.setToKhaiThue(toKhaiThue);
                hoaDonChiTiet.setTrangThai(true);
                dsHoaDonChiTiet.add(hoaDonChiTiet);
                hoaDon.setDsHoaDonChiTiet(dsHoaDonChiTiet);
            }
            boolean result=hoaDonDAO.themHoaDon(hoaDon);
            Assert.assertEquals(result, true);
            sql="SELECT id FROM hoadon ORDER BY ngayYeuCau DESC LIMIT 1";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery(sql);
            if(rs.next()){
                Assert.assertEquals(hoaDon.getId(), rs.getInt("id"));
                for(int i=0; i<hoaDon.getDsHoaDonChiTiet().size(); i++){
                    sql="SELECT idHoaDon FROM tokhaithue WHERE id="+hoaDon.getDsHoaDonChiTiet().get(i).getToKhaiThue().getId();
                    ps=con.prepareStatement(sql);
                    rs=ps.executeQuery(sql);
                    if(rs.next()){
                        Assert.assertEquals(hoaDon.getId(), rs.getInt("idHoaDon"));
                    }
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return;
    }
}
