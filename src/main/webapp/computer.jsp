<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 9/14/23
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="computer" method="post" >
    <h2>Máy tính</h2>
    <br>
    <lable>Number 1: </lable>
    <input type="text" name="number1" placeholder="Enter number one: ">
    <br>
    <br>
    <label>Select    :</label>
    <select name="calculation">
        <option value="summation" >+</option>
        <option value="subtraction">-</option>
        <option value="multiplication">*</option>
        <option value="division">/</option>
    </select>
    <br>
    <br>
    <label>Number 2: </label>
    <input type="text" name="number2" placeholder="Enter number two: ">
    <br>
    <br>
    <input type="submit" value="calculation">
</form>
</body>
</html>
