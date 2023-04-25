<%-- 
    Document   : dangNhap
    Created on : Mar 12, 2023, 1:32:17 PM
    Author     : Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fffcfc;
            margin: 0;
            padding: 0;
        }
        h1 {

            margin-top: 50px;
            margin-left: 620px;
        }
        form {
            width: 450px;
            margin: 0 auto;
            background-color: #cccccc;
            border-radius: 5px;
/*            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);*/
            padding: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }
        input {
            border-radius: 5px;
            border: 3px solid #ccc;
            padding: 10px;
            margin-right: 18px;
            margin-bottom: 15px;
            width: 90%;
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
        div.ma-xac-nhan {
            font-size: 20px;
            text-align: center;
            margin-bottom: 5px;
        }
        .ok{
            margin-bottom: 10px;
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
        <%String maXacNhanHeThong = (String) session.getAttribute("maXacNhanHeThong");%>
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 300px; display: block; margin-left:100px;  float: left;">
        <h1>Đăng nhập</h1>
        <form method="post" action="/HeThongTinhThue/DangNhapServlet" id="form1" >
            <label>Mã số thuế</label>
            <input type="text" name="maSoThue" value="${nguoiDung.getMaSoThue()}"/>
            <br/>
            <label>Mật khẩu</label>
            <input type="password" name="matKhau" value="${nguoiDung.getMatKhau()}"/>
            <br/>
            <label>Mã xác nhận</label>
            <div class="ok"><%=maXacNhanHeThong%></div>
            <input type="text" name="maXacNhan" />
            <input type="submit" value="Đăng nhập" />
        </form>
        <form method="get" action="/HeThongTinhThue/DangKiServlet" id="form2"> 
            <input type="submit" value="Đăng kí" />
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
