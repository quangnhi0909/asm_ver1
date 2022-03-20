<%-- 
    Document   : addproduct
    Created on : Mar 16, 2022, 5:16:02 PM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/add.css" rel="stylesheet" type="text/css"/>
        <title>Nhập Hàng</title>
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
                    <td><a style="text-decoration: none" href="../product/import">Các Sản Phẩm Nhập Gần Đây</a></td>
                </tr>
                <tr>
                    <!--(Chức năng này cho phép quản lý kho, xóa bớt các sản phẩm đang có trong kho)-->
                    <td><a style="text-decoration: none" href="../product/bill">Hóa Đơn Gần Đây</a></td>
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
        </div>
        <div class="content">
            <p>Xin Mời Nhập Thông Tin Đơn Hàng</p>
            <form action="add" method="post">
                Mã Sản Phẩm:
                <br/>
                <input type="text" name="pid"><br/>
                Lần Nhập Hàng:
                <br/>
                <input type="text" name="itime"><br/>
                Ngày Nhập Hàng:
                <br/>
                <input type="date" name="idate"><br/>
                Người Bán:
                <br/>
                <input type="text" name="seller"><br/>
                Số Điện Thoại:
                <br/>
                <input type="text" name="phone"><br/>
                Tên Sản Phẩm:
                <br/>
                <input type="text" name="pname"><br/>
                Giá Sản Phẩm:
                <br/>
                <input type="text" name="pprice"><br/>
                Số Lượng Sản Phẩm:
                <br/>
                <input type="text" name="quantity"><br/>
                <button type="submit">Xác Nhận</button>
            </form>
        </div>
    </body>
</html>
