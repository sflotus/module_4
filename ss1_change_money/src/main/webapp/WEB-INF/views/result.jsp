<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 3/15/2024
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Money Exchanger</h1>
    <div>
        <form action="/" method="post">
            <table>
                <tr>
                    <th>Input Number A</th>
                    <td>
                        <input type="number" placeholder="Number A" name="numA"  value="${numA}" required>
                    </td>
                </tr>
                <tr>
                    <th>Input Exchanger Rate</th>
                    <td>
                        <input type="number" placeholder="Exchanger Rate" name="exchangeRate" value="${exchangeRate}" required>
                    </td>
                </tr>
                <tr>
                    <th>Result</th>
                    <td>
                        <input type="number" placeholder="Result" value="${result}" readonly>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input type="submit" value="Calculator">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</center>
</body>
</html>
