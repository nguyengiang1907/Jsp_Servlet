<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 9/14/23
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    float result = convert(rate,usd);
%>
<%! float convert(float rate , float usd){
    float result = rate * usd;
    return  result;
}
%>
<h1>Rate: <%=rate%></h1>
<h1>Usd: <%=usd%></h1>
<h1>Result: <%=result%></h1>
</body>
</html>
