<%-- 
    Document   : tokhai_dangki_thue
    Created on : 05-Mar-2023, 15:18:16
    Author     : DELL-DATA
#f2f2f2
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.ToKhaiDangKiMST"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>To khai dang ki thue</title>
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

            input[type="submit"], input[type="reset"] {
                background-color: #0099ff;
                color: white;
                padding: 14px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-right: 10px;
            }

            input[type="text"], input[type="email"], select {
                padding: 10px;
                margin-bottom: 10px;
                border: none;
                border-radius: 5px;
                background-color: #f5f5f5;
                width: 100%;
            }

            h2 {
                margin-top: 20px;
                margin-bottom: 10px;
            }

            fieldset {
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 10px;
                margin-bottom: 20px;
            }

            legend {
                font-size: 20px;
                font-weight: bold;
                margin-bottom: 10px;
            }

            label {
                display: block;
                margin-bottom: 10px;
            }

            form p {
                margin-top: 20px;
                margin-bottom: 10px;
                font-size: 20px;
                font-weight: bold;
                text-align: center;
                text-decoration: underline;
            }

            .error-message {
                color: red;
                font-style: italic;
                font-size: 14px;
                margin-top: 5px;
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
            .bold-text {
                font-weight: bold;
            }
            /*            .oneLine {
                            display: inline-block;
                             các style khác của label 
                        }*/
        </style>
    </head>
    <body>
        <%ToKhaiDangKiMST toKhai = (ToKhaiDangKiMST) session.getAttribute("toKhai");%>
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 400px; display: block; margin: 0 auto; float: left;">
        <h1 style="max-width:1000px">Tờ khai đăng ký thuế</h1>

        <form action="/HeThongTinhThue/DangKiMSTServlet" method="post">
            <fieldset>
                <legend>Thông tin cá nhân</legend>
                <div class="oneLine">

                    <label for="fullname" >Họ và tên người đăng ký thuế: <%=toKhai.getNguoiYeuCau().getTen()%> </label>
<!--                    <label ><%=toKhai.getNguoiYeuCau().getTen()%></label>-->
                </div><br>

                <label for="ngaysinh">Ngày tháng năm sinh:</label>
                <input type="date" id="ngaysinh" name="ngaySinh" value="${toKhai.getNguoiYeuCau().getNgayThangNamSinh()}" placeholder="yyyy-MM-dd" required><br>


                <label for="gioitinh">Giới tính:</label>
                <label>
                    <input type="radio" name="gioiTinh" value="nam" required> Nam
                </label>
                <label>
                    <input type="radio" name="gioiTinh" value="nu" required> Nữ
                </label>



                <label for="quoctich">Quốc tịch: Việt Nam</label>
                <!--                <label>Việt Nam</label><br>-->

                <%
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                %>

                <label for="giaytocanhan">Giấy tờ cá nhân:</label>
                <label>Loại giấy: <%=toKhai.getNguoiYeuCau().getGiayTo().getLoai()%></label>
<!--                <div id="giaytocanhan"><%=toKhai.getNguoiYeuCau().getGiayTo().getLoai()%></div>-->
                <br>
                <label>Số giấy: <%=toKhai.getNguoiYeuCau().getGiayTo().getSoGiayTo()%></label>
<!--                <div id="sogiay" placeholder="Số giấy:"><%=toKhai.getNguoiYeuCau().getGiayTo().getSoGiayTo()%></div>-->
                <br>
                <label>Cơ quan cấp</label>
                <input type="text" id="coquancap" name="coQuanCap" placeholder="Cơ quan cấp:" required value="${toKhai.getNguoiYeuCau().getGiayTo().getCoQuanCap()}" /><br>
                <div>Ngày cấp: <%=formatter.format(toKhai.getNguoiYeuCau().getGiayTo().getNgayCap())%></div>
                <br>

                <label for="taxcode">Địa chỉ đăng ký theo hộ khẩu:</label>
                <input type="text" id="comp" name="soNha" placeholder="Số nhà/Đường phố/Thôn,xóm:" required value="${toKhai.getNguoiYeuCau().getDiaChi().getSoNha()}" /><br>
                <input type="text" id="comp1" name="thanhPho" placeholder="Tỉnh thành phố" required value="${toKhai.getNguoiYeuCau().getDiaChi().getThanhPho()}" /><br><!-- comment -->
                <input type="text" id="comp2" name="quanHuyen" placeholder="Quận huyện" required value="${toKhai.getNguoiYeuCau().getDiaChi().getQuanHuyen()}" /><br>
                <label>Quốc gia: Việt Nam</label>

                <label for="diachi">Địa chỉ cư trú:</label>
                <input type="text" id="diachicutru" name="diaChiCuTru" required value="${toKhai.getNguoiYeuCau().getDiaChiCuTru()}" /><br>	

                <label for="dienthoai">Điện thoại liên hệ :</label>
                <input type="text" id="dienthoai" name="dienThoai" required value="${toKhai.getNguoiYeuCau().getDienThoai()}" /><br>

                <label for="email">Email: <%=toKhai.getNguoiYeuCau().getEmail()%></label>
<!--                        <label id="email"> <%=toKhai.getNguoiYeuCau().getEmail()%> </label>-->

                <label for="coquan">Cơ quan chi trả tại thời điểm đăng ký thuế:</label>
                <input type="text" id="coquan" name="coQuanChiTra" placeholder="Mã số thuế" required value="${toKhai.getMaSoThueCoQuanChiTra()}" /><br>

                <label for="ngay">Ngày: <%=formatter.format(new Date())%></label>
                <label class="bold-text">
                    <input type="checkbox" name="confirm"  value="yes" required> Tôi cam kết những nội dung kê khai là đúng và chịu trách nhiệm 
                    trước pháp luật về nội dung kê khai
                </label>
            </fieldset>

            <div>
                <button type="submit" name="tieptuc1" value="tieptuc1">Nộp tờ khai</button>
                <span class="btn-separator" ></span>
        </form>
    </body>
</html>
