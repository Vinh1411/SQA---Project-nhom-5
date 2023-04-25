package dao;

import static dao.DAO.con;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.HoaDon;
import model.HoaDonChiTiet;

/**
 *
 * @author Vinh
 */
public class HoaDonDAO extends DAO{
    public HoaDonDAO(){
        super();
    }
    
    public boolean themHoaDon(HoaDon hoaDon){
        String sqlHoaDon = "INSERT INTO hoadon (soThe, tenChuThe, cvc, thangNamHetHan, tienPhaiDong, trangThai, ngayYeuCau, idNguoiDung, idNganHang) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlHoaDonChiTiet = "UPDATE tokhaithue SET idHoaDon=? WHERE id=?";
        boolean result = true;
        try {
            //con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlHoaDon, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hoaDon.getSoThe());
            ps.setString(2, hoaDon.getTenChuThe());
            ps.setString(3, hoaDon.getCVC());
            ps.setDate(4, new java.sql.Date(hoaDon.getThangNamHetHan().getTime()));
            ps.setInt(5, hoaDon.getTienPhaiDong());
            ps.setBoolean(6, false);
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(7, sqlDate);
            ps.setInt(8, hoaDon.getNguoiDung().getId());
            ps.setInt(9, hoaDon.getNganHang().getId());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                hoaDon.setId(generatedKeys.getInt(1));
                if(hoaDon.getDsHoaDonChiTiet()==null || hoaDon.getDsHoaDonChiTiet().size()==0){
                    result=false;
                    con.rollback();
                }else{
                    for (HoaDonChiTiet hoaDonChiTiet : hoaDon.getDsHoaDonChiTiet()) {
                        if(hoaDonChiTiet.isTrangThai()==true){
                            ps = con.prepareStatement(sqlHoaDonChiTiet);
                            ps.setInt(1, hoaDon.getId());
                            ps.setInt(2, hoaDonChiTiet.getToKhaiThue().getId());
                            ps.executeUpdate();
                        }
                    }
                    //con.commit();
                }
            }
        } catch (Exception e1) {
            result = false;
//            System.out.println("Cau lenh co van de");
//            try{
//                con.rollback();
//            }
//            catch(SQLException e2){
//                e2.printStackTrace();
//            }
//            e1.printStackTrace();
        }finally{
            try{
                //con.setAutoCommit(true);
            }catch(Exception e3){
//                System.out.println("Khong the rollback");
//                e3.printStackTrace();
            }
        }
        return result;
    }
}
