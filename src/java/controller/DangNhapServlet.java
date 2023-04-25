package controller;

import dao.NguoiDungDAO;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.NguoiDung;

public class DangNhapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        String maXacNhanHeThong = "";
        for (int i = 0; i < length; i++) {
           maXacNhanHeThong=maXacNhanHeThong+characters.charAt(random.nextInt(characters.length()));
        }
        NguoiDung nguoiDung=new NguoiDung();
        HttpSession session=request.getSession();
        session.setAttribute("maXacNhanHeThong", maXacNhanHeThong);
        session.setAttribute("nguoiDung", nguoiDung);
        String url = "/dangNhap.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String maXacNhanHeThong=(String) session.getAttribute("maXacNhanHeThong");
        NguoiDung nguoiDung=(NguoiDung) session.getAttribute("nguoiDung");
        nguoiDung.setMaSoThue(Integer.parseInt(request.getParameter("maSoThue")));
        nguoiDung.setMatKhau(request.getParameter("matKhau"));
        session.setAttribute("nguoiDung", nguoiDung);
        if(maXacNhanHeThong.compareTo(request.getParameter("maXacNhan"))!=0){
            String thongBao="Nhập sai mã xác nhận!";
            session.setAttribute("thongBao", thongBao);
            String url = "/dangNhap.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else{
            NguoiDungDAO nguoiDungDAO=new NguoiDungDAO();
            boolean result=nguoiDungDAO.kiemTraDangNhap(nguoiDung);
            if(result==true){
                String thongBao="Xin chào "+nguoiDung.getTen()+"!";
                session.setAttribute("thongBao", thongBao);
                String url = (String) session.getAttribute("urlState");
                session.setAttribute("nguoiDung", nguoiDung);
                response.sendRedirect(url);
            }
            else{
                String thongBao="Sai mã số thuế hoặc sai mật khẩu!";
                session.setAttribute("thongBao", thongBao);
                String url = "/dangNhap.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
    }
    
}
