package controller;

import dao.ToKhaiThueDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BieuMauTinhThue;
import model.NguoiDung;
import model.ToKhaiThue;

public class TinhThueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        NguoiDung nguoiDung=(NguoiDung) session.getAttribute("nguoiDung");
        if(nguoiDung==null || nguoiDung.getTen()==null){
            session.setAttribute("urlState", "/HeThongTinhThue/TinhThueServlet?action=0");
            String url = "/DangNhapServlet";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        String action=request.getParameter("action");
        if(action.compareTo("0")==0){ //Lần đầu vào trang
            ToKhaiThueDAO toKhaiThueDAO=new ToKhaiThueDAO();
            ArrayList<ToKhaiThue> dsToKhaiThue=toKhaiThueDAO.danhSachToKhaiChuaDong(nguoiDung.getId());
            ArrayList<BieuMauTinhThue> dsBieuMauTinhThue=new ArrayList<>();
            for(int i=0; i<dsToKhaiThue.size(); i++){
                BieuMauTinhThue temp=new BieuMauTinhThue(dsToKhaiThue.get(i));
                dsBieuMauTinhThue.add(temp);
            }
            session.setAttribute("dsBieuMauTinhThue", dsBieuMauTinhThue);
            String url = "/chonKyTinhThue.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else{
            if(action.compareTo("3")==0){ //Chọn trở về
                String url = "/chonKyTinhThue.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            else{ //Chọn xem chi tiết
                ArrayList<BieuMauTinhThue> dsBieuMauTinhThue=(ArrayList<BieuMauTinhThue>) session.getAttribute("dsBieuMauTinhThue");
                int id=Integer.parseInt(request.getParameter("id"));
                for(int i=0; i<dsBieuMauTinhThue.size(); i++){
                    if(id==dsBieuMauTinhThue.get(i).getToKhaiThue().getId()){
                        ToKhaiThueDAO toKhaiThueDAO=new ToKhaiThueDAO();
                        boolean result=toKhaiThueDAO.layThongTinToKhaiThue(dsBieuMauTinhThue.get(i).getToKhaiThue());
                        if(result==true){
                            String url = "/xemChiTietTinhThue.jsp";
                            session.setAttribute("bieuMauTinhThue", dsBieuMauTinhThue.get(i));
                            getServletContext().getRequestDispatcher(url).forward(request, response);
                        }
                        else{
                            String url = "/chonKyTinhThue.jsp";
                            getServletContext().getRequestDispatcher(url).forward(request, response);
                        }
                    }
                }
            }
        }   
    }
}
