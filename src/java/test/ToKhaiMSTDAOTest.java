/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Vinh
 */
import dao.DAO;
import dao.ToKhaiMSTDAO;
import java.sql.Connection;
import java.util.Date;
import model.DiaChi;
import model.GiayToCaNhan;
import model.NguoiYeuCau;
import model.ToKhaiDangKiMST;
import org.junit.Assert;
import org.junit.Test;

public class ToKhaiMSTDAOTest {
    ToKhaiMSTDAO toKhaiDao=new ToKhaiMSTDAO();
    
    @Test
    public void testThemToKhaiException1(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            ToKhaiDangKiMST toKhai=new ToKhaiDangKiMST();
            toKhai.setMaSoThueCoQuanChiTra("0123456");
            toKhai.setNgayNop(new Date());
            toKhai.setTrangThai(Boolean.FALSE);
            NguoiYeuCau nguoiYeuCau=new NguoiYeuCau();
            DiaChi diaChi=new DiaChi();
            diaChi.setQuanHuyen("Bac Tu Liem");
            diaChi.setQuocGia("Ha Noi");
            diaChi.setSoNha("12");
            nguoiYeuCau.setDiaChi(diaChi);
            nguoiYeuCau.setDiaChiCuTru("Ha Noi");
            nguoiYeuCau.setDienThoai("0123456789");
            nguoiYeuCau.setEmail("vinh@gmail.com");
            GiayToCaNhan giayTo=new GiayToCaNhan();
            giayTo.setCoQuanCap("Cong ty X");
            giayTo.setLoai("CCCD");
            giayTo.setNgayCap(new Date());
            giayTo.setSoGiayTo("123456789");
            nguoiYeuCau.setGiayTo(giayTo);
            nguoiYeuCau.setGioiTinh("nam");
            nguoiYeuCau.setNgayThangNamSinh(new Date());
            nguoiYeuCau.setQuocTich("Viet Nam");
            nguoiYeuCau.setTen("Vinh");
            toKhai.setNguoiYeuCau(nguoiYeuCau);
            boolean result=toKhaiDao.themToKhai(toKhai);
            Assert.assertNotEquals(result, false);
            Assert.assertNotEquals(toKhai.getId(), 0);
            Assert.assertNotEquals(toKhai.getNguoiYeuCau().getDiaChi().getId(), 0);
            Assert.assertNotEquals(toKhai.getNguoiYeuCau().getGiayTo().getId(), 0);
            Assert.assertNotEquals(toKhai.getNguoiYeuCau().getId(), 0);
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
        return ;
    }
    @Test
    public void testThemToKhaiException2(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            ToKhaiDangKiMST toKhai=new ToKhaiDangKiMST();
            toKhai.setNgayNop(new Date());
            toKhai.setTrangThai(Boolean.FALSE);
            NguoiYeuCau nguoiYeuCau=new NguoiYeuCau();
            nguoiYeuCau.setDiaChiCuTru("Ha Noi");
            nguoiYeuCau.setDienThoai("0123456789");
            nguoiYeuCau.setEmail("vinh@gmail.com");
            GiayToCaNhan giayTo=new GiayToCaNhan();
            giayTo.setCoQuanCap("Cong ty X");
            giayTo.setLoai("CCCD");
            giayTo.setNgayCap(new Date());
            giayTo.setSoGiayTo("123456789");
            nguoiYeuCau.setGiayTo(giayTo);
            nguoiYeuCau.setGioiTinh("nam");
            nguoiYeuCau.setNgayThangNamSinh(new Date());
            nguoiYeuCau.setQuocTich("Viet Nam");
            nguoiYeuCau.setTen("Vinh");
            toKhai.setNguoiYeuCau(nguoiYeuCau);
            boolean result=toKhaiDao.themToKhai(toKhai);
            Assert.assertNotEquals(result, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return ;
    }
    
    @Test
    public void testThemToKhaiException3(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            ToKhaiDangKiMST toKhai=new ToKhaiDangKiMST();
            toKhai.setMaSoThueCoQuanChiTra("0123456");
            toKhai.setNgayNop(new Date());
            toKhai.setTrangThai(Boolean.FALSE);
            NguoiYeuCau nguoiYeuCau=new NguoiYeuCau();
            DiaChi diaChi=new DiaChi();
            diaChi.setQuanHuyen("Bac Tu Liem");
            diaChi.setQuocGia("Ha Noi");
            diaChi.setSoNha("12");
            nguoiYeuCau.setDiaChi(diaChi);
            nguoiYeuCau.setDiaChiCuTru("Ha Noi");
            nguoiYeuCau.setDienThoai("0123456789");
            nguoiYeuCau.setEmail("vinh@gmail.com");
            nguoiYeuCau.setGioiTinh("nam");
            nguoiYeuCau.setNgayThangNamSinh(new Date());
            nguoiYeuCau.setQuocTich("Viet Nam");
            nguoiYeuCau.setTen("Vinh");
            toKhai.setNguoiYeuCau(nguoiYeuCau);
            boolean result=toKhaiDao.themToKhai(toKhai);
            Assert.assertNotEquals(result, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                //con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return ;
    }
    
    @Test
    public void testThemToKhaiException4(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            ToKhaiDangKiMST toKhai=new ToKhaiDangKiMST();
            toKhai.setMaSoThueCoQuanChiTra("0123456");
            toKhai.setNgayNop(new Date());
            toKhai.setTrangThai(Boolean.FALSE);
            boolean result=toKhaiDao.themToKhai(toKhai);
            Assert.assertNotEquals(result, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                //con.setAutoCommit(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return ;
    }
}
