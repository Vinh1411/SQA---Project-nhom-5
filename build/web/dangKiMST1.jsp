<%-- 
    Document   : register_tax_first
    Created on : 05-Mar-2023, 15:14:07
    Author     : DELL-DATA
--%>

<%@page import="model.ToKhaiDangKiMST"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đăng ký mã số thuế lần đầu</title>
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
                max-width: 600px;
            }
            input[type=text], input[type=date], input[type=email] {
                width: 100%;
                padding: 8px;
                margin: 8px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }
            label {
                display: block;
                text-align: left;

                margin-bottom: 10px;

            }
            button {
                background-color: #6c757d;
                color: white;
                padding: 14px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-right: 10px;
            }

            .btn-separator{
                margin-right: 20px;
            }
            select#type {
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <%ToKhaiDangKiMST toKhai = (ToKhaiDangKiMST) session.getAttribute("toKhai");%>
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 300px; display: block; margin: 0 auto; float: left;">
        <h1 style=" max-width: 1000px ; margin-left:80px">Đăng ký mã số thuế lần đầu</h1>
        <form action="/HeThongTinhThue/DangKiMSTServlet" method="get">
            <label for="name">Họ tên:</label>
            <input type="text" id="ten" name="ten" placeholder="Nguyen Van A" value="${toKhai.getNguoiYeuCau().getTen()}" required>
            <label for="type">Loại giấy tờ:</label>
            <%
                boolean temp1 = false;
                if (toKhai.getNguoiYeuCau().getGiayTo().getLoai() != null) {
                    temp1 = toKhai.getNguoiYeuCau().getGiayTo().getLoai().compareTo("cccd") == 0;
                }
                boolean temp2 = false;
                if (toKhai.getNguoiYeuCau().getGiayTo().getLoai() != null) {
                    temp2 = toKhai.getNguoiYeuCau().getGiayTo().getLoai().compareTo("cmnd") == 0;
                }
                boolean temp3 = false;
                if (toKhai.getNguoiYeuCau().getGiayTo().getLoai() != null)
                    temp3 = toKhai.getNguoiYeuCau().getGiayTo().getLoai().compareTo("hc") == 0;
            %>
            <select  name="loaiGiayTo" >
                <option value="cccd" <c:if test="${temp1}"> selected</c:if> >Căn Cước Công Dân</option>
                <option value="cmnd" <c:if test="${temp2}">selected</c:if>>Chứng Minh Thư Nhân Dân</option>
                <option value="hc" <c:if test="${temp3}">selected</c:if>>Hộ chiếu</option>
                </select>

                <label for="sogiayto">Số giấy tờ:</label>
                <input type="text" id="sogiayto" name="soGiayTo" value="${toKhai.getNguoiYeuCau().getGiayTo().getSoGiayTo()}" required>

            <label for="dob">Ngày cấp:</label>
            <input type="date" id="ngaycap" name="ngayCap" placeholder="yyyy-MM-dd" value="${toKhai.getNguoiYeuCau().getGiayTo().getNgayCap()}" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${toKhai.getNguoiYeuCau().getEmail()}" required>
            <div style="text-align: center; margin-left: 20px">
                <input type="hidden" name="action" value="1"/>
                <button style="width: 200px;" type="submit" name="submit" value="tiepTuc" >Thực hiện bước tiếp theo</button>
                <span class="btn-separator" ></span>
            </div>
            <div style="text-align: center;margin-top: 10px ; margin-left: 0px" >
                <form action="/HeThongTinhThue/DangKiMSTServlet" method="get">
                    <input type="hidden" name="action" value="2" />
                    <button style="width: 200px;" type="submit" name="submit" value="quayVe">Quay về trang chủ</button>
                </form>
            </div>
        </form>

    </body>
</html>