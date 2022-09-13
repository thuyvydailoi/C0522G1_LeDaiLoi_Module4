<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/13/2022
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SETTING</title>
</head>
<body>
<form:form method="post" action="/save" modelAttribute="mail">
    <table class="table">
        <tr>
            <td>Languages:</td>
            <td>
                <form:select path="languages">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Japnaese" label="Japanese"/>
                    <form:option value="Korea" label="Korea"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                <form:select path="pageSize">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
            </td>
            <td><p>emails per page</p></td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td><form:checkbox path="spamFilter"/></td>
            <td> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit">Update</button>
            </td>
            <td>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
