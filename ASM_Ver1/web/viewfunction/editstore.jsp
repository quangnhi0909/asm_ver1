<%-- 
    Document   : edit-store
    Created on : Mar 17, 2022, 8:53:42 AM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/editStore.css" rel="stylesheet" type="text/css"/>
        <title>Thay Đổi Thông Tin Sản Phẩm</title>
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
            <p>Cập Nhật Sản Phẩm</p>
            <form action="../store/edit" method="post">
                <c:set var="store" value="${requestScope.store}"></c:set>
                ID Sản Phẩm: <br/>
                ${store.sid} <br/>
                <input type="hidden" name="sid" value="${store.sid}">
                Tên Sản Phẩm: <br/>
                <input type="text" name="pname" value="${store.pname}"/> <br/>
                Số Lượng Trong Kho: <br/>
                <input type="text" name="quantity" value="${store.quantity}"/> <br/>
                Ngày Nhập Sản Phẩm:<br/>
                <input type="date" name="idate" value="${store.idate}"><br/>
                Mô Tả Sản Phẩm:<br/>
                <input type="text" name="des" value="${store.description}"><br/>
                <button type="submit">Save</button>
            </form>
        </div>
    </body>
</html>
