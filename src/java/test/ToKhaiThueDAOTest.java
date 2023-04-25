/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DAO;
import dao.ToKhaiThueDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ToKhaiThue;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Vinh
 */
public class ToKhaiThueDAOTest {
    ToKhaiThueDAO toKhaiThueDAO=new ToKhaiThueDAO();
    
    //Người dùng không tồn tại trong hệ thống
    @Test
    public void testDSToKhaiChuaDongException1(){
        int id=-1;
        ArrayList<ToKhaiThue> dsToKhaiThue=toKhaiThueDAO.danhSachToKhaiChuaDong(id);
        Assert.assertNotNull(dsToKhaiThue);
        Assert.assertEquals(0, dsToKhaiThue.size());
        return;
    }
    
    //Người dùng tồn tại trong hệ thống, nhưng không có khai báo thuế trên hệ thống
    @Test
    public void testDSToKhaiChuaDongException2(){
        int id=2;
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            String sql="DELETE FROM tokhaithue WHERE idNguoiDung=2";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ArrayList<ToKhaiThue> dsToKhaiThue=toKhaiThueDAO.danhSachToKhaiChuaDong(id);
            Assert.assertNotNull(dsToKhaiThue);
            Assert.assertEquals(0, dsToKhaiThue.size());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
    
    //Người dùng tồn tại trong hệ thống, nhưng đã đóng hết các khai báo thuế
    @Test
    public void testDSToKhaiChuaDongException3(){
        int id=2;
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            String sql1="INSERT INTO hoadon (soThe, tenChuThe, cvc, thangNamHetHan, tienPhaiDong, trangThai, ngayYeuCau, ngayThanhToan, idNguoiDung, idNganHang) values "
                    + "('0123456789', 'Vinh', '012', '2023-05-03', 0, 1, '2023-04-08', '2023-04-09', 2, 1)";
            PreparedStatement ps=con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idHoaDon=generatedKeys.getInt(1);
                String sql2="INSERT INTO tokhaithue (kyTinhThue, thoiGianBatDau, loaiToKhai, doiTuongDong, tienLuong, tienDauTu, tienKinhDoanh, tienBatDongSan, "
                        + "tienTrungThuong, soNguoiPhuThuoc, tienTuThien, tienDongBaoHiem, tienHuuTri, ngayNop, trangThai, idNguoiDung, idHoaDon)\n" +
                        "VALUES ('Theo tháng', '1/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-01-01', 1, 2, ?), "
                        + "('Theo tháng', '2/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-02-01', 1, 2, ?), "
                        + "('Theo tháng', '3/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-03-01', 1, 2, ?)";
                ps=con.prepareStatement(sql2);
                ps.setInt(1, idHoaDon);
                ps.setInt(2, idHoaDon);
                ps.setInt(3, idHoaDon);
                int rows=ps.executeUpdate();
                if(rows==3){
                    ArrayList<ToKhaiThue> dsToKhaiThue=toKhaiThueDAO.danhSachToKhaiChuaDong(id);
                    Assert.assertNotNull(dsToKhaiThue);
                    Assert.assertEquals(0, dsToKhaiThue.size());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
    
    //Người dùng tồn tại trong hệ thống, còn nợ 1 khai báo thuế chưa đóng
    @Test
    public void testDSToKhaiChuaDongException4(){
        int id=2;
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            String sql1="INSERT INTO hoadon (soThe, tenChuThe, cvc, thangNamHetHan, tienPhaiDong, trangThai, ngayYeuCau, ngayThanhToan, idNguoiDung, idNganHang) values "
                    + "('0123456789', 'Vinh', '012', '2023-05-03', 0, 1, '2023-04-08', '2023-04-09', 2, 1)";
            PreparedStatement ps=con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idHoaDon=generatedKeys.getInt(1);
                String sql2="INSERT INTO tokhaithue (kyTinhThue, thoiGianBatDau, loaiToKhai, doiTuongDong, tienLuong, tienDauTu, tienKinhDoanh, tienBatDongSan, "
                        + "tienTrungThuong, soNguoiPhuThuoc, tienTuThien, tienDongBaoHiem, tienHuuTri, ngayNop, trangThai, idNguoiDung, idHoaDon)\n" +
                        "VALUES ('Theo tháng', '1/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-01-01', 1, 2, ?), "
                        + "('Theo tháng', '2/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-02-01', 1, 2, ?), "
                        + "('Theo tháng', '3/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-03-01', 1, 2, null)";
                ps=con.prepareStatement(sql2);
                ps.setInt(1, idHoaDon);
                ps.setInt(2, idHoaDon);
                int rows=ps.executeUpdate();
                if(rows==3){
                    ArrayList<ToKhaiThue> dsToKhaiThue=toKhaiThueDAO.danhSachToKhaiChuaDong(id);
                    Assert.assertNotNull(dsToKhaiThue);
                    Assert.assertEquals(1, dsToKhaiThue.size());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
    
    //Người dùng tồn tại trong hệ thống, còn nợ nhiều hơn 1 khai báo thuế chưa đóng
    @Test
    public void testDSToKhaiChuaDongException5(){
        int id=2;
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            String sql1="INSERT INTO hoadon (soThe, tenChuThe, cvc, thangNamHetHan, tienPhaiDong, trangThai, ngayYeuCau, ngayThanhToan, idNguoiDung, idNganHang) values "
                    + "('0123456789', 'Vinh', '012', '2023-05-03', 0, 1, '2023-04-08', '2023-04-09', 2, 1)";
            PreparedStatement ps=con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idHoaDon=generatedKeys.getInt(1);
                String sql2="INSERT INTO tokhaithue (kyTinhThue, thoiGianBatDau, loaiToKhai, doiTuongDong, tienLuong, tienDauTu, tienKinhDoanh, tienBatDongSan, "
                        + "tienTrungThuong, soNguoiPhuThuoc, tienTuThien, tienDongBaoHiem, tienHuuTri, ngayNop, trangThai, idNguoiDung, idHoaDon)\n" +
                        "VALUES ('Theo tháng', '1/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-01-01', 1, 2, ?), "
                        + "('Theo tháng', '2/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-02-01', 1, 2, null), "
                        + "('Theo tháng', '3/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-03-01', 1, 2, null)";
                ps=con.prepareStatement(sql2);
                ps.setInt(1, idHoaDon);
                int rows=ps.executeUpdate();
                if(rows==3){
                    ArrayList<ToKhaiThue> dsToKhaiThue=toKhaiThueDAO.danhSachToKhaiChuaDong(id);
                    Assert.assertNotNull(dsToKhaiThue);
                    Assert.assertEquals(2, dsToKhaiThue.size());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
    
    //Lấy thông tin tờ khai không tồn tại trong hệ thống
    @Test
    public void testLayThongTinToKhaiThueException1(){
        ToKhaiThue toKhaiThue=new ToKhaiThue();
        toKhaiThue.setId(-1);
        boolean result=toKhaiThueDAO.layThongTinToKhaiThue(toKhaiThue);
        Assert.assertEquals(result, true);
        Assert.assertNull(toKhaiThue.getNguoiDung());
        return;
    }
    
    //Lấy thông tin tờ khai tồn tại trong hệ thống
    @Test
    public void testLayThongTinToKhaiThueException2(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            String sql="INSERT INTO tokhaithue (kyTinhThue, thoiGianBatDau, loaiToKhai, doiTuongDong, tienLuong, tienDauTu, tienKinhDoanh, tienBatDongSan, "
                        + "tienTrungThuong, soNguoiPhuThuoc, tienTuThien, tienDongBaoHiem, tienHuuTri, ngayNop, trangThai, idNguoiDung)\n" +
                        "VALUES ('Theo tháng', '1/2023', 'Tờ khai lần đầu', 'Cư trú có hợp đồng >= 3 tháng', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2023-01-01', 1, 2)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idToKhaiThue=generatedKeys.getInt(1);
                ToKhaiThue toKhaiThue=new ToKhaiThue();
                toKhaiThue.setId(idToKhaiThue);
                boolean result=toKhaiThueDAO.layThongTinToKhaiThue(toKhaiThue);
                Assert.assertEquals(result, true);
                Assert.assertNotNull(toKhaiThue.getNguoiDung());
                Assert.assertEquals(toKhaiThue.getNguoiDung().getMaSoThue(), 2);
                Assert.assertEquals(toKhaiThue.getNguoiDung().getTen(), "Test");
            }
        } catch (Exception e) {
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
