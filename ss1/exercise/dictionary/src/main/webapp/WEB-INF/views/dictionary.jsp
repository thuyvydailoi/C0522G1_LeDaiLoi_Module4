<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/9/2022
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/dictionary1">
    <h1>Từ Điển Việt Nam <3</h1>
    <input type="text" name="english"><br><br>
    <input type="submit" id="Submit" value="Translate"><br><br>
    <span>Result: ${translate}</span>
</form>
</body>
</html>
