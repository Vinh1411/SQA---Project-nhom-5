package controller;

import dao.HoaDonDAO;
import dao.NganHangDAO;
import dao.ToKhaiThueDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NganHang;
import model.NguoiDung;
import model.ToKhaiThue;


public class DongThueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        NguoiDung nguoiDung=(NguoiDung) session.getAttribute("nguoiDung");
        if(nguoiDung==null || nguoiDung.getTen()==null){
            session.setAttribute("urlState", "/HeThongTinhThue/DongThueServlet?action=0");
            String url = "/DangNhapServlet";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        String action = request.getParameter("action");
        //Hiển thị lần đầu
        if (action.compareTo("0") == 0) {
            ToKhaiThueDAO toKhaiThueDAO = new ToKhaiThueDAO();
            ArrayList<ToKhaiThue> dsToKhaiThue = toKhaiThueDAO.danhSachToKhaiChuaDong(nguoiDung.getId());
            HoaDon hoaDon = new HoaDon();
            for (int i = 0; i < dsToKhaiThue.size(); i++) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(dsToKhaiThue.get(i));
                hoaDon.getDsHoaDonChiTiet().add(hoaDonChiTiet);
            }
            hoaDon.setNguoiDung(nguoiDung);
            session.setAttribute("hoaDon", hoaDon);
            String url = "/chonKyDeDong.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else { //Hiển thị khi được click tiếp tục
            if (action.compareTo("1") == 0) {
                if(request.getParameter("submit").compareTo("Tiếp tục")==0){
                    HoaDon hoaDon = (HoaDon) session.getAttribute("hoaDon");
                    hoaDon.resertTrangThai();
                    String[] dsIdToKhai = request.getParameterValues("dsIdToKhai");
                    if (dsIdToKhai != null) {
                        for (int i = 0; i < dsIdToKhai.length; i++) {
                            int id = Integer.parseInt(dsIdToKhai[i].substring(0, dsIdToKhai[i].length()));
                            for (int j = 0; j < hoaDon.getDsHoaDonChiTiet().size(); j++) {
                                if (id == hoaDon.getDsHoaDonChiTiet().get(j).getToKhaiThue().getId()) {
                                    hoaDon.getDsHoaDonChiTiet().get(j).setTrangThai(true);
                                    break;
                                }
                            }
                        }
                    }
                    else{
                        String thongBao="Bạn chưa chọn 1 kỳ để đóng!";
                        session.setAttribute("thongBao", thongBao);
                        session.setAttribute("hoaDon", hoaDon);
                        String url = "/chonKyDeDong.jsp";
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                    }
                    ArrayList<NganHang> dsNganHang = (ArrayList<NganHang>) session.getAttribute("dsNganHang");
                    if (dsNganHang == null) {
                        NganHangDAO nganHangDAO = new NganHangDAO();
                        dsNganHang = nganHangDAO.dsNganHang();
                        session.setAttribute("dsNganHang", dsNganHang);
                    }
                    session.setAttribute("hoaDon", hoaDon);
                    String url = "/dongThue.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                }
                else{
                    String url = "/index.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                }
            } else { //click nút quay về tại trang hóa đơn
                String url = "/chonKyDeDong.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String submit=request.getParameter("submit");
        HttpSession session = request.getSession();
        HoaDon hoaDon = (HoaDon) session.getAttribute("hoaDon");
        int idNganHang=Integer.parseInt(request.getParameter("idNganHang"));
        ArrayList<NganHang> dsNganHang=(ArrayList<NganHang>) session.getAttribute("dsNganHang");
        for(int i=0; i<dsNganHang.size(); i++){
            if(dsNganHang.get(i).getId()==idNganHang){
                session.setAttribute("nganHang", dsNganHang.get(i));
                hoaDon.setNganHang(dsNganHang.get(i));
                break;
            }
        }
        hoaDon.setTenChuThe(request.getParameter("tenChuThe"));
        System.out.println(hoaDon.getTenChuThe());
        hoaDon.setSoThe(request.getParameter("soThe"));
        hoaDon.setCVC(request.getParameter("cvc"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            hoaDon.setThangNamHetHan(formatter.parse(request.getParameter("hetHan")));
        } catch (ParseException ex) {
            Logger.getLogger(DongThueServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(submit.compareTo("Gui yeu cau thanh toan")==0){
            if(hoaDon.getNganHang()!=null && hoaDon.getCVC()!=null && hoaDon.getThangNamHetHan()!=null && hoaDon.getTenChuThe()!=null && hoaDon.getSoThe()!=null){
                Date time=java.util.Calendar.getInstance().getTime();
                if(time.compareTo(hoaDon.getThangNamHetHan())>0){
                    String thongBao="Thẻ đã hết hạn!";
                    session.setAttribute("thongBao", thongBao);
                    getServletContext().getRequestDispatcher("/dongThue.jsp").forward(request, response);
                }
                else{

                    HoaDonDAO hoaDonDAO=new HoaDonDAO();
                    hoaDonDAO.themHoaDon(hoaDon);
                    String url = "/index.jsp";
                    String thongBao="Yêu cầu thanh toán đã được gửi";
                    session.setAttribute("thongBao", thongBao);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                }
            }
            else{
                String thongBao="Điền thiếu thông tin";
                session.setAttribute("thongBao", thongBao);
                getServletContext().getRequestDispatcher("/dongThue.jsp").forward(request, response);
            }
        }
        else{
            session.setAttribute("hoaDon", hoaDon);
            String url = "/chonKyDeDong.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
}
