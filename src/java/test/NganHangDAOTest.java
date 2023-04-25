/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DAO;
import dao.NganHangDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NganHang;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Vinh
 */
public class NganHangDAOTest {
    NganHangDAO nganHangDAO=new NganHangDAO();
    
    //Bỏ qua vòng lặp
    @Test
    public void testLayToanBoNganHangException1(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            String sql = "DELETE FROM nganhang";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ArrayList<NganHang> ds = new ArrayList<>();
            ArrayList <NganHang> listNganHang=nganHangDAO.dsNganHang();
            Assert.assertNotNull(listNganHang);
            Assert.assertEquals(0, listNganHang.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return ;
    }
    
    //Thực hiện vòng lặp 1 lần
    @Test
    public void testLayToanBoNganHangException2(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            String sql = "DELETE FROM nganhang";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            sql="INSERT INTO nganhang (ten, moTa) values ('scb', 'ngan hang cong thuong')";
            ps=con.prepareStatement(sql);
            int rowsAffected = ps.executeUpdate(sql);
            if(rowsAffected == 1){
                ArrayList<NganHang> ds = new ArrayList<>();
                ArrayList <NganHang> listNganHang=nganHangDAO.dsNganHang();
                Assert.assertNotNull(listNganHang);
                Assert.assertEquals(1, listNganHang.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return ;
    }
    
    //Thực hiện vòng lặp k lần (k=3)
    @Test
    public void testLayToanBoNganHangException3(){
        Connection con=DAO.con;
        try {
            con.setAutoCommit(false);
            String sql = "DELETE FROM nganhang";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            sql="INSERT INTO nganhang (ten, moTa) values ('scb', 'ngan hang cong thuong'), "
                    + "('mb', 'ngan hang quan doi'), "
                    + "('tcb', 'ngan hang doanh nghiep')";
            ps=con.prepareStatement(sql);
            int rowsAffected = ps.executeUpdate(sql);
            if(rowsAffected == 3){
                ArrayList<NganHang> ds = new ArrayList<>();
                ArrayList <NganHang> listNganHang=nganHangDAO.dsNganHang();
                Assert.assertNotNull(listNganHang);
                Assert.assertEquals(3, listNganHang.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return ;
    }
}
