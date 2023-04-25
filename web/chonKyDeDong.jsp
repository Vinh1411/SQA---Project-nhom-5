

<%@page import="model.HoaDon"%>
<%@page import="model.BieuMauTinhThue"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chọn kỳ để đóng</title>
    </head>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h1 {

            margin-top: 50px;
            margin-bottom: 50px;
            margin-left: 500px;
        }

        table {
            /*            margin: 0 auto;*/
            border-collapse: collapse;
            width: 70%;
            max-width: 900px;
/*            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);*/
            border-radius: 5px;
            margin-bottom: 30px;
            margin-left: 90px;
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
        div{
            margin-left: 660px;
        }

        .alert-box {
            position: fixed;
            top: 10px;
            right: 10px;
            padding: 10px;
            background-color: #f2f2f2;
            border: 1px solid #ddd;
            border-radius: 3px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
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
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 300px; display: block; margin: 0 auto; float: left;">
        <h1>Chọn các kỳ còn nợ để đóng</h1>
        <form method="get" action="/HeThongTinhThue/DongThueServlet">
            <table>
                <th>STT</th>
                <th>Theo loại</th>
                <th>Thời gian</th>
                <th>Tiền cần đóng</th> 
                <th>Lựa chọn</th>
                    <%int i = 1;%>
                    <c:forEach var="item" items="${hoaDon.getDsHoaDonChiTiet()}">
                    <tr>
                        <td><%=i%></td>
                        <%i = i + 1;%>
                        <td>${item.getToKhaiThue().getLoaiToKhai()}</td>
                        <td>${item.getToKhaiThue().getThoiGianBatDau()}</td>
                        <td>${item.getTongTienThuePhaiDong()}</td>
                        <td>
                            <c:if test="${item.isTrangThai()}">
                                <input type="checkbox" name='dsIdToKhai' value="${item.getToKhaiThue().getId()}" checked />
                            </c:if>
                            <c:if test="${!item.isTrangThai()}">
                                <input type="checkbox" name='dsIdToKhai' value="${item.getToKhaiThue().getId()}" />
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <input type="hidden" name="action" value="1" />

                <input type="submit" name="submit" value="Tiếp tục" />
                <input type="submit" name="submit" value="Về trang chủ" />
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
