<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 9/11/23
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .login {
        height:180px; width:230px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
    }
    .login input {
        padding:5px; margin:5px
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="get">
    <div>
        <br>
        <input type="text" size="30" name="userName" placeholder="UserName">
        <br>
        <br>
        <input type="password" size="30" name="passWord" placeholder="PassWord">
        <br>
        <br>
        <input type="submit" size="10">
    </div>
</form>
</body>
</html>
