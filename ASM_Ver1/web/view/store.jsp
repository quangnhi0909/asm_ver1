<%-- 
    Document   : store
    Created on : Mar 17, 2022, 8:28:13 AM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/store.css" rel="stylesheet" type="text/css"/>
        <script src="../js/store.js" type="text/javascript"></script>
        <title>Kho Hàng</title>
        <script>
        function deleteProduct(id) {
                var result = confirm("Bạn có thực sự muốn xóa sản phẩm này");
                if (result) {
                    window.location.href = "../store/delete?id=" + id
                }
            }
            </script>
    </head>
    <body>
        <div class="header">
            <p>Xin chào ${sessionScope.account.username}</p>
        </div>
        <nav class="left">
            <table>
                <tr>
                    <!--add thông tin lần nhập hàng đó vào DB-->
                    <td><a style="text-decoration: none" href="../product/add">Nhập Sản Phẩm</a></td>
                </tr>
                <tr>
                    <!--Xem hóa đơn, có thể click vào billID để tìm được lần nhập đó-->
                    <td><a style="text-decoration: none" href="../product/import">Các Lần Nhập Hàng Gần Đây</a></td>
                </tr>
                <tr>
                    <!--(Chức năng này cho phép quản lý kho, xóa bớt các sản phẩm đang có trong kho)-->
                    <td><a style="text-decoration: none" href="../product/store">Quản Lý Kho</a></td>
                </tr>
                <tr>
                    <!--(Chức năng này cho phép quản lý kho, xóa bớt các sản phẩm đang có trong kho)-->
                    <td><a style="text-decoration: none" href="../home">Trang Chủ</a></td>
                </tr>
            </table>
        </nav>
        <div class="right">
            <table border="1px">
                <tr>
                    <th colspan="5">Kho Hàng Của Bạn Hiện Tại</th>
                </tr>
                <tr>
                    <td>Tên Sản Phẩm</td>
                    <td>Tổng Số lượng</td>
                    <td>Ngày Nhập Hàng</td>
                    <td colspan="5">Cập Nhật Sản Phẩm</td>
                </tr>
                <c:forEach items="${requestScope.listStoreProduct}" var="list">
                    <tr>
                        <td>${list.productName}</td>
                        <td>${list.quantity}</td>
                        <td>${list.idate}</td>
                        <td>
                            <a style="text-decoration: none" href="../store/edit?id=${list.id}">Thay Đổi Thông Tin</a>
                        </td>
                        <td>
                            <a style="text-decoration: none" href="#" onclick="deleteProduct(${list.id})">Xóa Sản Phẩm</a>
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
