<%@ page import="java.util.List" %>
<%@ page import="com.example.servlet_.Customers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<table class="table table-dark table-striped">
    <tr>
        <th>Name</th>
        <th>Sex</th>
        <th>Address</th>
        <th>Picture</th>
    </tr>
    <%
        List<Customers> list = new ArrayList<>();
        list.add(new Customers("Nguyen Giang","Nam","Thanh Hoa","https://scontent.fhan2-3.fna.fbcdn.net/v/t39.30808-6/368383325_246368984971669_2325171876371137203_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=a2f6c7&_nc_ohc=7uC3kEIXAPUAX94dNKL&_nc_ht=scontent.fhan2-3.fna&oh=00_AfCqu5FryglnSE8wWK-7BY8kdTK21IyNw_QKfZ3GnUO1Fw&oe=650CA970"));
        list.add(new Customers("Thao Anh","Nu","Thanh Hoa","https://scontent.fhan2-4.fna.fbcdn.net/v/t39.30808-6/372839142_322912030398141_1093205242947327557_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5614bc&_nc_ohc=T11YQOfuumQAX99f0mF&_nc_ht=scontent.fhan2-4.fna&oh=00_AfBQQ6_uNSDqBVgRz307u11E4XzbA03EbmM6DOodoxeRhQ&oe=650C263E"));


        request.setAttribute("list",list);
    %>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.name}</td>
            <td>${item.sex}</td>
            <td>${item.address}</td>
            <td><img src="${item.picture}" alt="anh" style="width: 50px ; height: 50px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>