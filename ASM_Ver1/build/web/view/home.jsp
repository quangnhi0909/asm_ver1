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
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <p1>Xin chào ${sessionScope.account.username}</p1>
        </div>
        <div>
            <form>
                <table>
                    <tr>
                        <!--add thông tin lần nhập hàng đó vào DB-->
                        <td><a style="text-decoration: none" href="product/add">Nhập Sản Phẩm</a></td>
                    </tr>
                    <tr>
                        <!--Xem hóa đơn, có thể click vào billID để tìm được lần nhập đó-->
                        <td><a style="text-decoration: none" href="product/bill">Các Lần Nhập Hàng Gần Đây</a></td>
                    </tr>
                    <tr>
                        <!--(Chức năng này cho phép quản lý kho, xóa bớt các sản phẩm đang có trong kho)-->
                        <td><a style="text-decoration: none" href="product/store">Kho Hàng</a></td>
                    </tr>
                </table>
            </form>
        </div>
        <div>
            <table border="1px">
                <tr>
                    <th colspan="2">Kho Hàng Của Bạn</th>
                </tr>
                <tr>
                    <td>Tên Sản Phẩm</td>
                    <td>Tổng Số lượng</td>
                </tr>
                <c:forEach items="${requestScope.listProduct}" var="list">
                    <tr>
                        <td>${list.productName}</td>
                        <td>${list.quantity}</td>
                    </tr>    
                </c:forEach>

            </table>
        </div>
    </body>
</html>
