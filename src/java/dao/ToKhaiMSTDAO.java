package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ToKhaiDangKiMST;

/**
 *
 * @author Vinh
 */
public class ToKhaiMSTDAO extends DAO{
    public ToKhaiMSTDAO(){
        super();
    }
    public boolean themToKhai(ToKhaiDangKiMST toKhai){
        String sqlDiaChi = "INSERT INTO diaChi (soNha, quocGia, thanhPho, quanHuyen) VALUES(?, 'Viet Nam', ?, ?)";
        String sqlGiayTo = "INSERT INTO giaytocanhan (loai, ngayCap, soGiayTo, coQuanCap) VALUES (?, ?, ?, ?)";
        String sqlNguoiYeuCau = "INSERT INTO nguoiyeucau (ten, email, ngayThangNamSinh, gioiTinh, quocTich, diaChiCuTru, dienThoai, idGiayToCaNhan, idDiaChi)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlToKhai = "INSERT INTO tokhaidangkimst (maSoThuCoQuanChiTra, ngayNop, trangThai, idNguoiYeuCau)\n"
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement ps;
        boolean result = true;
        try {
            //con.setAutoCommit(false);
            ps = con.prepareStatement(sqlDiaChi, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, toKhai.getNguoiYeuCau().getDiaChi().getSoNha());
            ps.setString(2, toKhai.getNguoiYeuCau().getDiaChi().getThanhPho());
            ps.setString(3, toKhai.getNguoiYeuCau().getDiaChi().getQuanHuyen());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                toKhai.getNguoiYeuCau().getDiaChi().setId(generatedKeys.getInt(1));
                ps = con.prepareStatement(sqlGiayTo, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, toKhai.getNguoiYeuCau().getGiayTo().getLoai());
                java.util.Date utilDate = toKhai.getNguoiYeuCau().getGiayTo().getNgayCap();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                ps.setDate(2, sqlDate);
                ps.setString(3, toKhai.getNguoiYeuCau().getGiayTo().getSoGiayTo());
                ps.setString(4, toKhai.getNguoiYeuCau().getGiayTo().getCoQuanCap());
                ps.executeUpdate();
                generatedKeys = ps.getGeneratedKeys();
                if(generatedKeys.next()){
                    toKhai.getNguoiYeuCau().getGiayTo().setId(generatedKeys.getInt(1));
                    ps = con.prepareStatement(sqlNguoiYeuCau, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, toKhai.getNguoiYeuCau().getTen());
                    ps.setString(2, toKhai.getNguoiYeuCau().getEmail());
                    utilDate = toKhai.getNguoiYeuCau().getNgayThangNamSinh();
                    sqlDate = new java.sql.Date(utilDate.getTime());
                    ps.setDate(3, sqlDate);
                    ps.setString(4, toKhai.getNguoiYeuCau().getGioiTinh());
                    ps.setString(5, "Viet Nam");
                    ps.setString(6, toKhai.getNguoiYeuCau().getDiaChiCuTru());
                    ps.setString(7, toKhai.getNguoiYeuCau().getDienThoai());
                    ps.setInt(8, toKhai.getNguoiYeuCau().getGiayTo().getId());
                    ps.setInt(9, toKhai.getNguoiYeuCau().getDiaChi().getId());
                    ps.executeUpdate();
                    generatedKeys = ps.getGeneratedKeys();
                    if(generatedKeys.next()){
                        toKhai.getNguoiYeuCau().setId(generatedKeys.getInt(1));
                        ps = con.prepareStatement(sqlToKhai, Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, toKhai.getMaSoThueCoQuanChiTra());
                        utilDate = toKhai.getNgayNop();
                        sqlDate = new java.sql.Date(utilDate.getTime());
                        ps.setDate(2, sqlDate);
                        ps.setBoolean(3, toKhai.getTrangThai());
                        ps.setInt(4, toKhai.getNguoiYeuCau().getId());
                        ps.executeUpdate();
                        generatedKeys = ps.getGeneratedKeys();
                        if(generatedKeys.next()){
                            toKhai.setId(generatedKeys.getInt(1));
                            //con.commit();
                        }
                    }
                }
            }
        } catch (Exception e1) {
            result = false;
//            try{
//                con.rollback();
//            }
//            catch(SQLException e2){
//                e2.printStackTrace();
//            }
//            e1.printStackTrace();
        }finally{
//            try{
//               con.setAutoCommit(true);
//            }catch(Exception e3){
//                e3.printStackTrace();
//            }
        }
        return result;
    }
}
