/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NguoiDungDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.NguoiDung;

/**
 *
 * @author Vinh
 */
public class DangKiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NguoiDung nguoiDung=new NguoiDung();
        HttpSession session=request.getSession();
        session.setAttribute("nguoiDung", nguoiDung);
        String url = "/dangKi.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        NguoiDung nguoiDung=(NguoiDung) session.getAttribute("nguoiDung");
        String matKhau=request.getParameter("matKhau");
        String xacNhanMatKhau=request.getParameter("xacNhanMatKhau");
        nguoiDung.setMaSoThue(Integer.parseInt(request.getParameter("maSoThue")));
        nguoiDung.setEmail(request.getParameter("email"));
        nguoiDung.setMatKhau(request.getParameter("matKhau"));
        nguoiDung.setSoDienThoai(request.getParameter("soDienThoai"));
        session.setAttribute("nguoiDung", nguoiDung);
        if(matKhau.compareTo(xacNhanMatKhau)!=0){
            String thongBao="Nhap sai ma xac nhan!";
            session.setAttribute("thongBao", thongBao);
            String url = "/dangKi.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else{
            NguoiDungDAO nguoiDungDAO=new NguoiDungDAO();
            boolean result=nguoiDungDAO.themTaiKhoan(nguoiDung);
            if(result==false){
                String thongBao="Bạn đã nhập sai thông tin!\nVấn đề có thể bạn đang sử dụng một mã số thuế" +
                        " đã được liên kết với một tài khoản hoặc một mã số thuế không tồn tại!";
                session.setAttribute("thongBao", thongBao);
                String url = "/dangKi.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            else{
                String thongBao="Yêu cầu tạo tài khoản đã được ghi nhận!";
                session.setAttribute("thongBao", thongBao);
                String url = "/index.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
    } 
}
