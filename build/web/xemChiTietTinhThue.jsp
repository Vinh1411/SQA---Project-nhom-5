<%-- 
    Document   : XemChiTietTinhThue
    Created on : Mar 11, 2023, 6:22:11 PM
    Author     : Vinh
--%>

<%@page import="model.BieuMauTinhThue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem chi tiết kỳ thuế</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h1 {
            margin-left: 550px;
            margin-top: 50px;
            margin-bottom: 30px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 100%;
            max-width: 1000px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            border-radius: 5px;
            margin-bottom: 30px;
        }


        th, td {
/*            text-align: center;*/
/*            padding: 10px;*/
            border: 1px solid #ccc;
        }

        th {
            background-color: #CE7A58;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
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

        label {
            font-weight: bold;

        }
        .ok{
            margin-left: 217px;
        }

        div {
            margin-bottom: 10px;
        }
        form {
            text-align: center;
        }

        input[type="submit"] {
            display: inline-block;
            margin-top: 20px;
        }
        table tr td {
/*            font-size: 16px;
            font-weight: bold;*/
       
            padding-left: 0px;
        }
        .table1 tr td:first-child{
            text-align: center;
            
            vertical-align: middle;
            
        }
        .table1 tr td:nth-child(3) {
            text-align: center;
            
            vertical-align: middle;
  /* CSS cho cột thứ hai */
}

    </style>
    <body>
        <img src="thuedientu.png" alt="Mô tả ảnh" style="max-width: 300px; display: block; margin-left:100px;  float: left;">
        <h1>Chi tiết tính thuế</h1>
        <%BieuMauTinhThue bieuMauTinhThue = (BieuMauTinhThue) session.getAttribute("bieuMauTinhThue");%>
        <table>
            <tr>
                <td>
                    <label>Tên người đóng:</label>
                    <div><%=bieuMauTinhThue.getToKhaiThue().getNguoiDung().getTen()%></div>
                </td>
                <td>
                    <label>Mã số thuế:</label>
                    <div><%=bieuMauTinhThue.getToKhaiThue().getNguoiDung().getMaSoThue()%></div>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Đối tượng:</label>
                    <div><%=bieuMauTinhThue.getToKhaiThue().getDoiTuongDong()%></div>
                </td>
                <td>
                    <label>Kỳ đóng:</label>
                    <div><%=bieuMauTinhThue.getToKhaiThue().getKyTinhThue()%></div>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Thời điểm quyết toán:</label>
                    <div><%=bieuMauTinhThue.getToKhaiThue().getThoiGianBatDau()%></div>
                </td>
                <td>
                    <label>Đơn vị tính:</label>
                    <div>VNĐ</div>
                </td>
            </tr>
        </table>
        <label class="ok">Bảng thông tin đã khai báo</label>
        <table class="table1">
            <th style="text-align: center;">STT</th>
            <th>Chỉ tiêu</th>
            <th style="text-align: center;">Đơn vị tính</th>
            <th>Số người/Số tiền</th>
            <tr>
                <td>1</td>
                <td>Tiền lương hoặc tiền công</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienLuong()%></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Tiền thu từ đầu tư</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienDauTu()%></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Tiền thu từ kinh doanh</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienKinhDoanh()%></td>
            </tr> 
            <tr>
                <td>4</td>
                <td>Tiền thu từ chuyển nhượng bất động sản</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienBatDongSan()%></td>
            </tr>
            <tr>
                <td>5</td>
                <td>Tiền thu nhập từ trúng thưởng</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienTrungThuong()%></td>
            </tr>
            <tr>
                <td>6</td>
                <td>Số người phụ thuộc</td>
                <td>Người</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getSoNguoiPhuThuoc()%></td>
            </tr>
            <tr>
                <td>7</td>
                <td>Tiền nhân đạo, từ thiện</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienTuThien()%></td>
            </tr>
            <tr>
                <td>8</td>
                <td>Tiền đóng bảo hiểm</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienDongBaoHiem()%></td>
            </tr>
            <tr>
                <td>9</td>
                <td>Tiền đóng quỹ hưu trí tự nguyện</td>
                <td>VNĐ</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienHuuTri()%></td>
            </tr>
        </table>


        <label class="ok">Bảng biểu tính tổng thu nhập từ các nguồn</label>
        <table>
            <th>Các mục</th>
            <th>Thu nhập (VNĐ)</th>
            <tr>
                <td>Tiền lương hoặc tiền công</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienLuong()%></td>
            </tr>
            <tr>
                <td>Tiền thu từ đầu tư</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienDauTu()%></td>
            </tr>
            <tr>
                <td>Tiền thu từ kinh doanh</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienKinhDoanh()%></td>
            </tr> 
            <tr>
                <td>Tiền thu từ chuyển nhượng bất động sản</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienBatDongSan()%></td>
            </tr>
            <tr>
                <td>Tiền thu nhập từ trúng thưởng</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienTrungThuong()%></td>
            </tr>
            <tr>
                <td>
                    Tổng tiền
                </td>
                <td>
                    <%=bieuMauTinhThue.getTongTienTruocThue()%> VNĐ
                </td>
            </tr>
        </table>


        <label class="ok">Bảng biểu tính các khoản miễn thuế đối với tiền lương hoặc tiền công</label>
        <table>
            <th>
                Các mục
            </th>
            <th>Số tiền (Tính theo VNĐ)</th>
            <tr>
                <td>Số người phụ thuộc: <%=bieuMauTinhThue.getToKhaiThue().getSoNguoiPhuThuoc()%> người</td>
                <td><%=bieuMauTinhThue.getTienMienGiamPhuThuoc()%></td>
            </tr>
            <tr>
                <td>Tiền nhân đạo, từ thiện</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienTuThien()%></td>
            </tr>
            <tr>
                <td>Tiền đóng bảo hiểm</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienDongBaoHiem()%></td>
            </tr>
            <tr>
                <td>Tiền đóng quỹ hưu trí tự nguyện</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienHuuTri()%></td>
            </tr>
            <tr>
                <td>Cá nhân</td>
                <td><%=bieuMauTinhThue.getTienMienCaNhan()%></td>
            </tr>
            <tr>
                <td>
                    Tổng tiền
                </td>
                <td>
                    <%=bieuMauTinhThue.getTongTienDuocMienGiam()%> VNĐ
                </td>
            </tr>
        </table>


        <label class="ok">Bảng biểu tính số tiền thuế phải đóng</label>
        <table>
            <th>Các khoản chịu thuế</th>
            <th>Thu nhập</th>
            <th>Số tiền được miễn giảm</th>
            <th>Số tiền chịu thuế</th>
            <th>Thuế suất</th>
            <th>Tiền phải đóng</th>
            <tr>
                <td>Tiền lương hoặc tiền công</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienLuong()%></td>
                <td><%=bieuMauTinhThue.getTongTienDuocMienGiam()%></td>
                <td><%=bieuMauTinhThue.getSoTienLuongChiuThue()%></td>
                <td>
                    <c:if test="${bieuMauTinhThue.getDsThueLuongTheoBac()!=null}">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Xem chi tiết</button>
                    </c:if>
                    <c:if test="${bieuMauTinhThue.getDsThueLuongTheoBac()==null}">
                        <%=bieuMauTinhThue.getThueSuatToanPhanLuong()%>%
                    </c:if>

                </td>
                <td><%=bieuMauTinhThue.getTienThueLuong()%></td>
            </tr>
            <tr>
                <td>Tiền thu từ đầu tư</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienDauTu()%></td>
                <td>0</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienDauTu()%></td>
                <td><%=bieuMauTinhThue.getDsThueToanPhan()[1]%>%</td>
                <td><%=bieuMauTinhThue.getTienThueDauTu()%></td>
            </tr>
            <tr>
                <td>Tiền thu từ kinh doanh</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienKinhDoanh()%></td>
                <td>0</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienKinhDoanh()%></td>
                <td><%=bieuMauTinhThue.getDsThueToanPhan()[0]%>%</td>
                <td><%=bieuMauTinhThue.getTienThueKinhDoanh()%></td>
            </tr> 
            <tr>
                <td>Tiền thu từ chuyển nhượng bất động sản</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienBatDongSan()%></td>
                <td>0</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienBatDongSan()%></td>
                <td><%=bieuMauTinhThue.getDsThueToanPhan()[2]%>%</td>
                <td><%=bieuMauTinhThue.getTienThueBDS()%></td>
            </tr>
            <tr>
                <td>Tiền thu nhập từ trúng thưởng</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienTrungThuong()%></td>
                <td>0</td>
                <td><%=bieuMauTinhThue.getToKhaiThue().getTienTrungThuong()%></td>
                <td><%=bieuMauTinhThue.getDsThueToanPhan()[3]%>%</td>
                <td><%=bieuMauTinhThue.getTienThueTrungThuong()%></td>
            </tr>
            <tr>
                <td colspan="5">
                    Tổng tiền thuế phải đóng
                </td>
                <td>
                    <%=bieuMauTinhThue.getTongTienThuePhaiDong()%> VNĐ
                </td>
            </tr>
        </table>
        <form method="get" action="/HeThongTinhThue/TinhThueServlet" >
            <input type="hidden" name="action" value="3" />
            <input type="submit" value="Quay về" />
        </form>

        <c:if test="${bieuMauTinhThue.getDsThueLuongTheoBac()!=null}">
            <div class="modal fade" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Công thức lũy tiến cho tính thuế</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table>
                                <th>Bậc tính thuế</th>
                                <th>Số tiền chịu thuế</th>
                                <th>Thuế suất</th>
                                <th>Tiền thuế phải đóng</th>
                                    <%for (int i = 0; i < bieuMauTinhThue.getDsThueLuongTheoBac().size(); i++) {%>
                                <tr>
                                    <td><%=i + 1%></td>
                                    <td><%=bieuMauTinhThue.getDsThueLuongTheoBac().get(i).getSoTien()%></td>
                                    <td><%=bieuMauTinhThue.getDsBacThueLuong()[i]%> %</td>
                                    <td><%=bieuMauTinhThue.getDsThueLuongTheoBac().get(i).getTienPhaiDong()%></td>
                                </tr>
                                <%}%>
                                <tr>
                                    <td colspan="3">Tổng tiền phải đóng thuế từ tiền lương hoặc tiền công</td>
                                    <td><%=bieuMauTinhThue.getTienThueLuong()%></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>
