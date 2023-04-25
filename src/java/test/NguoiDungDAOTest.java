/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DAO;
import dao.NguoiDungDAO;
import java.sql.Connection;
import org.junit.Assert;
import model.NguoiDung;

/**
 *
 * @author Vinh
 */
import org.junit.Test;
public class NguoiDungDAOTest {
    NguoiDungDAO nguoiDungDAO=new NguoiDungDAO();
    
    @Test
    public void testDangNhapException1(){
        NguoiDung nguoiDung=new NguoiDung();
        nguoiDung.setMaSoThue(2);
        nguoiDung.setMatKhau("test123");
        boolean result=nguoiDungDAO.kiemTraDangNhap(nguoiDung);
        Assert.assertEquals(result, true);
        Assert.assertNotNull(nguoiDung.getTen());
        Assert.assertNotEquals(nguoiDung.getId(), 0);
        
    }
    
    @Test
    public void testDangNhapException2(){
        NguoiDung nguoiDung=new NguoiDung();
        nguoiDung.setMaSoThue(2);
        nguoiDung.setMatKhau("test12");
        boolean result=nguoiDungDAO.kiemTraDangNhap(nguoiDung);
        Assert.assertEquals(result, false);
        Assert.assertNull(nguoiDung.getTen());   
    }
    
   
    
    @Test
    public void testDangKiException1(){
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setMaSoThue(23);
            nguoiDung.setEmail("Vinh@gmail.com");
            nguoiDung.setDienThoai("0123456789");
            nguoiDung.setMatKhau("test12");
            boolean result=nguoiDungDAO.themTaiKhoan(nguoiDung);
            Assert.assertEquals(result, true);
        }catch (Exception e) {
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
    public void testDangKiException2(){
        Connection con=DAO.con;
        try{
            con.setAutoCommit(false);
            NguoiDung nguoiDung=new NguoiDung();
            nguoiDung.setMaSoThue(-1);
            nguoiDung.setEmail("Vinh@gmail.com");
            nguoiDung.setDienThoai("0123456789");
            nguoiDung.setMatKhau("test12");
            boolean result=nguoiDungDAO.kiemTraDangNhap(nguoiDung);
            Assert.assertEquals(result, false);
        }catch (Exception e) {
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
    public void testDangNhapException3(){
        NguoiDung nguoiDung=new NguoiDung();
        nguoiDung.setMaSoThue(26);
        nguoiDung.setMatKhau("test123");
        boolean result=nguoiDungDAO.kiemTraDangNhap(nguoiDung);
        Assert.assertEquals(result, false);
        
    }
}
