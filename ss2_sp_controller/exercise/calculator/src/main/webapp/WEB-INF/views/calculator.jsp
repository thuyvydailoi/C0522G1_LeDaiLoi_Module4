<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/12/2022
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Calculator_icon.svg/2048px-Calculator_icon.svg.png">
    <title>Calculator</title>
</head>
<body>
<form method="get" action="calculate">
    <h1> Calculator </h1>
    <input type="text" value="${num1}" name="firstNumber">
    <input type="text" value="${num2}" name="secondNumber"><br>
    <br>
    <button name="string" value="addition">Addition(+)</button>
    <button name="string" value="subtraction">Subtraction(-)</button>
    <button name="string" value="multiplication">Multiplication(*)</button>
    <button name="string" value="division">Division(/)</button>
    <br>
    <h2>Result: ${result}</h2>
</form>
</body>
</html>
