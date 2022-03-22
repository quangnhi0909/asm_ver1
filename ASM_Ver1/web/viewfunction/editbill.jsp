<%-- 
    Document   : editbill
    Created on : Mar 21, 2022, 10:49:07 PM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/editBill.css" rel="stylesheet" type="text/css"/>
        <title>Thay Đổi Thông Tin Thanh Toán</title>
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
                    <td><a style="text-decoration: none" href="../product/import">Các Lần Nhập Gần Đây</a></td>
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
        <div class="content">
            <p>Cập Nhật Thanh Toán</p>
            <form action="../bill/edit" method="post">
                <c:set var="b" value="${requestScope.bill}"></c:set>
                Mã Số Hóa Đơn: ${b.bid} <br/>
                <input type="hidden" name="bid" value="${b.bid}">
                Mã Sản Phẩm: ${b.pid}<br/>
                <input type="hidden" name="pid" value="${b.pid}"><br/>
                Lần Nhập: <br/>
                <input type="text" name="itime" value="${b.itime}"/> <br/>
                Người Bán: <br/>
                <input type="text" name="seller" value="${b.seller}"/> <br/>
                Số Điện Thoại: <br/>
                <input type="text" name="phone" value="${b.phone}"/> <br/>
                Ngày Nhập:<br/>
                <input type="date" name="idate" value="${b.idate}"><br/>
                Tổng Số Tiền:<br/>
                <input type="text" name="total" value="${b.total}"><br/>
                Trạng Thái:<br/>
                <input type="text" name="desB" value="${b.description}"><br/>
                <button type="submit">Save</button>
            </form>
        </div>
    </body>
</html>