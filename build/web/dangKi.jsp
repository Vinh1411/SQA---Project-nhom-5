<%-- 
    Document   : register_tax_first
    Created on : 05-Mar-2023, 15:14:07
    Author     : DELL-DATA
--%>

<%@page import="model.NguoiDung"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đăng ký</title>
        <script>
            document.getElementById("register-form").addEventListener("submit", function (event) {
                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("confirm-password").value;

                if (password !== confirmPassword) {
                    alert("Xác nhận mật khẩu không chính xác. Hãy thử lại!");
                    event.preventDefault();
                }
            });
        </script>
        <style>
            body {
                font-family: Arial, sans-serif;

            }
            h1 {
                text-align: center;
            }
            form {
                background-color: #cccccc;
                border-radius: 5px;
                padding: 20px;
                margin: 0 auto;
                max-width: 450px;
            }
            input[type=text], input[type=date], input[type=email] {
                width: 100%;
                padding: 8px;
                margin: 8px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            label {
                display: block;
                text-align: left;

                margin-bottom: 10px;

            }
            button {
          
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
            button:hover {
                background-color: #343a40;
                color: white;
            }

            select#type {
                font-size: 20px;
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
    </head>
    <body>
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 300px; display: block; margin: 0 auto; float: left;">
        <h1 style=" max-width: 1000px ; margin-left:80px">Đăng ký</h1>
        <%NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");%>
        <form id ="register-form" action="/HeThongTinhThue/DangKiServlet" method="POST">
            <fieldset>
                <label for="masothue">Mã số thuế:</label>
                <input type="text" id="masothue" name="maSoThue" value="${nguoiDung.getMaSoThue()}" required>



                <label for="pass">Mật khẩu:</label>
                <input type="password" id="password" name="matKhau" value="${nguoiDung.getMatKhau()}" required>

                <label for="repass">Xác nhận mật khẩu:</label>
                <input type="password" id="confirm-Password" name="xacNhanMatKhau"  required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${nguoiDung.getEmail()}" required>

                <label for="text">Số điện thoại:</label>
                <input type="text" id="sdt" name="soDienThoai" value="${nguoiDung.getSoDienThoai()}" required>
                <button type="submit" name="tieptuc" value="tieptuc">Gửi</button>
            </fieldset>
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