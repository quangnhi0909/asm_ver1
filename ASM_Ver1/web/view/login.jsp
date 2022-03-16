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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username:
            <input type="text" name="username">
            <br/>
            Password:
            <input type="text" name="password">
            <br/>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
