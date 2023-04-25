
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xin chào!</title>
    </head>
    <style>

        body {
            margin: 0;
            padding: 0;
        }

        /*        h1 {
                    font-size: 36px;
                    margin-right: 400px;
                }*/

        .form-container {
            max-width: 800px;
            margin: 0 auto;
            position: relative;
        }

        .form-left {
            display: inline-block;
            float: left

        }

        .form-right {
            display: inline-block;
            float: right;
            position: absolute;
            top: 0;
            right: 0;
        }

        .btn-calculate,
        .btn-pay,
        .btn-register {
            background-color: #4CAF50;
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            padding: 10px 30px;
            border-radius: 5px;
            margin: 5px;
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
        .div-move {
            float: left;
            width: 30%;
            margin-top: 30px;
            margin-left:550px;

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
        <img src="logo.png" alt="Mô tả ảnh" style="max-width: 550px; display: block; margin-left:30px;  float: left;">
        
        <div class="div-move">
            <form method='GET' action="/HeThongTinhThue/TinhThueServlet" style="display:inline-block;">
                <input type="hidden" name="action" value="0">
                <input type='submit' value='Tính thuế' />
            </form>
            <form method='GET' action="/HeThongTinhThue/DongThueServlet" style="display:inline-block;">
                <input type="hidden" name="action" value="0">
                <input type='submit' value='Đóng thuế' />
            </form>
            <form method='GET' action="/HeThongTinhThue/DangKiMSTServlet" style="display:inline-block;">
                <input type="hidden" name="action" value="0">
                <input type='submit' value='Đăng kí mã số thuế' />
        </div>
    </form>
    <c:if test='${thongBao!=null}'>
        <div class="alert-box">
            <span class="alert-message">${thongBao}</span>
            <span class="alert-close">&times;</span>
        </div>
        <%session.removeAttribute("thongBao");%>;
    </c:if>
    <%session.invalidate();%>
</body>
</html>
