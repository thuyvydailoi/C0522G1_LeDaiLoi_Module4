<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/12/2022
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="save">
    <h1>Sandwich Condiments</h1>

    <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
    <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
    <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
    <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
    <hr style="border: 2px">
    <td><input type="submit" value="save"></td>
    <br>
    <span style="font-size: 30px">
    <c:forEach items="${condiment}" var="eat">
        ${eat}
    </c:forEach>
</span>
</form>
</body>
</html>
