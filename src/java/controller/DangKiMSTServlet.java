/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ToKhaiMSTDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DiaChi;
import model.GiayToCaNhan;
import model.NguoiDung;
import model.NguoiYeuCau;
import model.ToKhaiDangKiMST;

/**
 *
 * @author Vinh
 */
public class DangKiMSTServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action.compareTo("0") == 0) { //Vao lan dau trang 1
            GiayToCaNhan giayTo = new GiayToCaNhan();
            DiaChi diaChi = new DiaChi();
            NguoiYeuCau nguoiYeuCau = new NguoiYeuCau();
            nguoiYeuCau.setGiayTo(giayTo);
            nguoiYeuCau.setDiaChi(diaChi);
            ToKhaiDangKiMST toKhai = new ToKhaiDangKiMST();
            toKhai.setNguoiYeuCau(nguoiYeuCau);
            session.setAttribute("toKhai", toKhai);
            String url = "/dangKiMST1.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            if (action.compareTo("1") == 0) { //nut tiep tuc tren trang 1
                ToKhaiDangKiMST toKhai = (ToKhaiDangKiMST) session.getAttribute("toKhai");
                toKhai.getNguoiYeuCau().setTen(request.getParameter("ten"));
                toKhai.getNguoiYeuCau().getGiayTo().setLoai(request.getParameter("loaiGiayTo"));
                toKhai.getNguoiYeuCau().getGiayTo().setSoGiayTo(request.getParameter("soGiayTo"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = formatter.parse(request.getParameter("ngayCap"));
                    toKhai.getNguoiYeuCau().getGiayTo().setNgayCap(date);
                } catch (ParseException ex) {
                    Logger.getLogger(DangKiMSTServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                toKhai.getNguoiYeuCau().setEmail(request.getParameter("email"));
                session.setAttribute("toKhai", toKhai);
                String url = "/dangKiMST2.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } else {
                if (action.compareTo("2") == 0) { //nut quay ve trang 1
                    String url = "/index.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                } else { //nut quay ve o trang 2
                    String url = "/dangKiMST1.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);

                }
            }

        }

//        String url = "/dangKiMS.jsp";
//        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ToKhaiDangKiMST toKhai = (ToKhaiDangKiMST) session.getAttribute("toKhai");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(request.getParameter("ngaySinh"));
            toKhai.getNguoiYeuCau().setNgayThangNamSinh(date);
        } catch (ParseException ex) {
            Logger.getLogger(DangKiMSTServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        toKhai.getNguoiYeuCau().setGioiTinh(request.getParameter("gioiTinh"));
        toKhai.getNguoiYeuCau().getGiayTo().setCoQuanCap(request.getParameter("coQuanCap"));
        toKhai.getNguoiYeuCau().getDiaChi().setSoNha(request.getParameter("soNha"));
        toKhai.getNguoiYeuCau().getDiaChi().setThanhPho(request.getParameter("thanhPho"));
        toKhai.getNguoiYeuCau().getDiaChi().setQuanHuyen(request.getParameter("quanHuyen"));
        toKhai.getNguoiYeuCau().setDiaChiCuTru(request.getParameter("diaChiCuTru"));
        toKhai.getNguoiYeuCau().setDienThoai(request.getParameter("dienThoai"));
        toKhai.setMaSoThueCoQuanChiTra(request.getParameter("coQuanChiTra"));
        toKhai.setNgayNop(new Date());
        toKhai.setTrangThai(false);
        ToKhaiMSTDAO toKhaiDAO=new ToKhaiMSTDAO();
        boolean result=toKhaiDAO.themToKhai(toKhai);
        session.setAttribute("toKhai", toKhai);
        if(result==true){
            String thongBao="Nộp tờ khai thành công!";
            session.setAttribute("thongBao", thongBao);
            String url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else{
            String url = "/dangKiMST2.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        
    }
}
