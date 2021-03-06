<%-- 
    Document   : bill
    Created on : Mar 20, 2022, 11:31:24 PM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/bill.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bill.js" type="text/javascript"></script>
        <title>Hóa Đơn</title>

    </head>
    <body>
        <div class="header">
            <p>Xin chào ${sessionScope.account.username}</p>
        </div>
        <nav class="left">
            <table>
                <tr>
                    <td><a style="text-decoration: none" href="../product/add">Nhập Sản Phẩm</a></td>
                </tr>
                <tr>
                    <td><a style="text-decoration: none" href="../product/import">Các Sản Phẩm Nhập Gần Đây</a></td>
                </tr>
                <tr>
                    <td><a style="text-decoration: none" href="../product/bill">Hóa Đơn Gần Đây</a></td>
                </tr>
                <tr>
                    <td><a style="text-decoration: none" href="../product/store">Quản Lý Kho</a></td>
                </tr>
                <tr>
                    <td><a style="text-decoration: none" href="../home">Trang Chủ</a></td>
                </tr>
            </table>
        </nav>
        <div class="right">
            <table border="1px">
                <tr>
                    <th colspan="8">Hóa Đơn Gần Đây</th>
                </tr>
                <tr>
                    <td>Lần Nhập</td>
                    <td>Mã Sản Phẩm</td>
                    <td>Người Bán</td>
                    <td>Số Điện Thoại</td>
                    <td>Ngày Nhập</td>
                    <td>Tổng Số Tiền</td>
                    <td>Trạng Thái Thanh Toán</td>
                    <td>Cập Nhật</td>
                </tr>
                <c:forEach items="${requestScope.listBills}" var="b">
                    <tr>
                        <td>${b.itime}</td>
                        <td>${b.pid}</td>
                        <td>${b.seller}</td>
                        <td>${b.phone}</td>
                        <td>${b.getDateFormat()}</td>
                        <td>${b.total}</td>
                        <td>${b.description}</td>
                        <td>
                            <a style="text-decoration: none" href="../bill/edit?bid=${b.bid}">Thay Đổi Thông Tin</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="pagger"> </div>
        <script>
            pagger('pagger',${requestScope.pageindex},${requestScope.totalpage});
        </script>
    </body>
</html>
