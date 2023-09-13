<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 9/11/23
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>converter</title>
</head>

<body>
<h1>Chuyển đổi tiền tệ </h1>
<form action="converter" method="get" >
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
