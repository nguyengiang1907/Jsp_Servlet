<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 9/12/23
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tính triết khấu sản phẩm</title>
</head>
<body>
<form action="display-discount" method="post">
    <h1> Tính triết khấu </h1>
    <br>
    <input type="text" name="productDescription" placeholder="Sản phẩm ">
    <br>
    <br>
    <input type="text" name="listPrice" placeholder="Gía sản phẩm">
    <br>
    <br>
    <input type="text" name="discountPercent" placeholder="Nhập triết khấu">
    <br>
    <br>
    <input type="submit" size="10" >
</form>
</body>
</html>
