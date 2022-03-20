<%-- 
    Document   : login
    Created on : Mar 16, 2022, 3:22:52 PM
    Author     : Hoang Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Đăng Nhập</title>
    </head>
    <body>
        <div class="login">
            <form action="login" method="POST">
                <h2>Xin Mời Đăng Nhập</h2>
                <input type="text" placeholder="Nhập Tài Khoản..." name="username"><br/>
                <input type="password"placeholder="Nhập Mật Khẩu..." name="password"><br/>
                <button type="submit">Đăng Nhập</button>
            </form>            
        </div>
    </body>
</html>
