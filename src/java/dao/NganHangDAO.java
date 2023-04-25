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
import model.NganHang;
import model.ToKhaiThue;

/**
 *
 * @author Vinh
 */
public class NganHangDAO extends DAO {

    public NganHangDAO() {
        super();
    }

    public ArrayList<NganHang> dsNganHang() {
        String sql = "SELECT * FROM nganhang";
        ArrayList<NganHang> ds = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NganHang temp=new NganHang(rs.getInt("id"), rs.getString("ten"), rs.getString("moTa"));
                ds.add(temp);
            }
        } catch (Exception e) {
            
        }
        return ds;
    }
//    public static void main(String[] args) {
//        NganHangDAO nganHangDAO=new NganHangDAO();
//        System.out.println(nganHangDAO.dsNganHang().size());
//    }
}
