<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/9/2022
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<form method="get" action="/convert">
    <label>USD</label>
    <input type="number" name="usd" value="${usd}"> <br> <br>
    <label>VND</label>
    <input type="number" name="convertMoney" value="${convertMoney}">
    <button type="submit">Convert</button>
</form>
</body>
</html>
