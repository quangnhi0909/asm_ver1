<%-- 
    Document   : bill
    Created on : Mar 17, 2022, 7:34:25 AM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/import.css" rel="stylesheet" type="text/css"/>
        <script src="../js/import.js" type="text/javascript"></script>
        <title>Nhập Hàng Gần Đây</title>

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
                    <th colspan="7">Các Lần Nhập Hàng Gần Đây</th>
                </tr>
                <tr>
                    <td>Lần Nhập</td>
                    <td>Tên Sản Phẩm</td>
                    <td>Giá Sản Phẩm</td>
                    <td>Số Lượng</td>
                </tr>
                <c:forEach items="${requestScope.listProducts}" var="p">
                    <tr>
                        <td>${p.itime}</td>
                        <td>${p.pname}</td>
                        <td>${p.price}</td>
                        <td>${p.quantity}</td>
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
