<%-- 
    Document   : DongThue
    Created on : Mar 12, 2023, 8:51:39 AM
    Author     : Vinh
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.HoaDon"%>
<%@page import="model.NganHang"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đóng thuế</title>
    </head>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h1 {

            margin-top: 50px;
            margin-bottom: 50px;
            margin-left: 400px;
        }

        table {                    
            margin: 0 auto;
            margin-left: 100px;
          
            border-collapse: collapse;
            width: 70%;
            max-width: 800px;
/*            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);*/
            border-radius: 5px;
            margin-bottom: 30px;
        }

        th, td {
            text-align: center;
            padding: 10px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #CE7A58;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #cccccc;
        }

        input[type="submit"] {
            background-color: #6c757d;
            color: white;

            padding: 12px 24px;
            border: none;
            border-radius: 5px;
            font-family: sans-serif;
            font-size: 16px;
            cursor: pointer;
            transition-duration: 0.4s;
        }
        input[type="submit"]:hover {
            background-color: #343a40;
            color: white;
        }
        form{
            margin-left: 263px;
        }
        td input[type=text] {
            width: 100%;
            
            box-sizing: border-box;
        }
        div{
            margin-left: 100px;
        }

        .alert-box {
            position: fixed;
            top: 10px;
            right: 10px;
            padding: 10px;
            background-color: #f2f2f2;
            border: 1px solid #ddd;
            border-radius: 3px;
/*            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);*/
            }

            .alert-message {
                display: inline-block;
                margin-right: 10px;
                color: #333;
                font-weight: bold;
            }

            .alert-close {
                display: inline-block;
                margin-left: 10px;
                color: #bbb;
                font-size: 20px;
                font-weight: bold;
                cursor: pointer;
            }

    </style>
    <body>
        <form method="post" action='/HeThongTinhThue/DongThueServlet' id="form1" accept-charset="UTF-8"/>
        <%
            NganHang nganHang = (NganHang) session.getAttribute("nganHang");
            ArrayList<NganHang> dsNganHang = (ArrayList<NganHang>) session.getAttribute("dsNganHang");
            HoaDon hoaDon = (HoaDon) session.getAttribute("hoaDon");
        %>
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 300px; display: block; margin-left:0px;  float: left;">
        <h1>Đóng thuế</h1>
        <table>
            <tr>
                <td style="text-align: left;">
                    <label>Người đóng thuế: <%=hoaDon.getNguoiDung().getTen()%></label>
<!--                    <div><%=hoaDon.getNguoiDung().getTen()%></div>-->
                </td>
                <td style="text-align: left;">
                    <label>Mã số thuế: <%=hoaDon.getNguoiDung().getMaSoThue()%></label>
<!--                    <div><%=hoaDon.getNguoiDung().getMaSoThue()%></div>-->
                </td>
            </tr>
            <tr>
                <td style="text-align: left;">
                    <label>Ngân hàng hỗ trợ</label>
                    <select name="idNganHang" required>
                        <c:forEach items="${dsNganHang}" var="option">
                            <option value="${option.getId()}" <c:if test="${nganHang.getId()==option.getId()}">selected</c:if>> ${option.getTen()} </option>
                        </c:forEach>
                    </select>
                </td>
            
                <td style="text-align: left;">
     
                    <label>Việt Nam Đồng (VNĐ)</label>
                </td>
            </tr>
            <tr>
                <td style="text-align: left;">
                    <label>Tên chủ thẻ</label>
                    <input type='text' name='tenChuThe' value="${hoaDon.getTenChuThe()}" required/>
                </td>
                <td style="text-align: left;">
                    <label>Số thẻ</label>
                    <input type='text' name='soThe' value="${hoaDon.getSoThe()}" required pattern="[0-9]+"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: left;">
                    <label>CVC</label>
                    <input type='text' name='cvc' value="${hoaDon.getCVC()}" required pattern="[0-9]+" maxlength="3"/>
                </td>
                <td style="text-align: left;">
                    <label>Tháng, năm hết hạn của thẻ</label>
                    <%
                        String strDate="";
                        if(hoaDon.getThangNamHetHan()!=null){
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            strDate = formatter.format(hoaDon.getThangNamHetHan());
                        }
                    %>
                    <input type='date' name='hetHan' value="${strDate}" required/>
                </td>
            </tr>
        </table>
        <table>
            <th>STT</th>
            <th>Theo loại</th>
            <th>Thời gian</th>
            <th>Tiền cần đóng</th> 
                <%
                    long tongTien = 0;
                    int i = 0;
                %>
                <c:forEach items="${hoaDon.getDsHoaDonChiTiet()}" var="option">
                    <c:if test="${option.trangThai}">
                    <tr>
                        <td><%=i%></td>
                        <td><%=hoaDon.getDsHoaDonChiTiet().get(i).getToKhaiThue().getLoaiToKhai()%></td>
                        <td><%=hoaDon.getDsHoaDonChiTiet().get(i).getToKhaiThue().getThoiGianBatDau()%></td>
                        <td><%=hoaDon.getDsHoaDonChiTiet().get(i).getTongTienThuePhaiDong()%></td>
                        <%tongTien = tongTien + hoaDon.getDsHoaDonChiTiet().get(i).getTongTienThuePhaiDong();%>
                        <%i = i + 1;%>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <div>
            

            <input type='submit' name="submit" value="Gửi yêu cầu thanh toán"></input>
            
        </div>
    </form>
    <c:if test='${thongBao!=null}'>
        <div class="alert-box">
            <span class="alert-message">${thongBao}</span>
            <span class="alert-close">&times;</span>
        </div>
        <%session.removeAttribute("thongBao");%>;
    </c:if>
</body>
</html>
