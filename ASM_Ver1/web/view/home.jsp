<%-- 
    Document   : home
    Created on : Mar 16, 2022, 3:39:30 PM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <script src="js/home.js" type="text/javascript"></script>
        <title>Trang Chủ</title>
    </head>
    <body>
        <div class="header">
            <p>Xin chào ${sessionScope.account.username}</p>
        </div>
        <nav class="left">
                       <table>
                <tr>
                    <!--add thông tin lần nhập hàng đó vào DB-->
                    <td><a style="text-decoration: none" href="product/add">Nhập Sản Phẩm</a></td>
                </tr>
                <tr>
                    <!--Xem hóa đơn, có thể click vào billID để tìm được lần nhập đó-->
                    <td><a style="text-decoration: none" href="product/import">Các Sản Phẩm Nhập Gần Đây</a></td>
                </tr>
                <tr>
                    <!--(Chức năng này cho phép quản lý kho, xóa bớt các sản phẩm đang có trong kho)-->
                    <td><a style="text-decoration: none" href="product/bill">Hóa Đơn Gần Đây</a></td>
                </tr>
                <tr>
                    <!--(Chức năng này cho phép quản lý kho, xóa bớt các sản phẩm đang có trong kho)-->
                    <td><a style="text-decoration: none" href="product/store">Quản Lý Kho</a></td>
                </tr>
            </table>
        </nav>
        <div class="right">
            <table border = "1px" >
                <tr>
                    <th colspan="3">Các Sản Phẩm Hiện Có Trong Kho</th>
                </tr>
                <tr>
                    <td>Tên Sản Phẩm</td>
                    <td>Tổng Số lượng</td>
                    <td>Ngày Nhập Về</td>
                </tr>
                <c:forEach items="${requestScope.listStoreProduct}" var="list">
                    <tr>
                        <td>${list.pname}</td>
                        <td>${list.quantity}</td>
                        <td>${list.idate}</td>
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
