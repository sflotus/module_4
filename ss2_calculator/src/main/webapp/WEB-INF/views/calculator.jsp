<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 3/18/2024
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 600px">
    <form action="/" method="post" id="calculator">
        <fieldset>
            <legend>Calculator</legend>
            <table>
                <tr>
                    <td><label for="numA">Number A</label></td>
                    <td><input type="number" name="numA" id="numA"></td>
                </tr>
                <tr>
                    <td><label for="numB">Number B</label></td>
                    <td><input type="number" name="numB" id="numB"></td>
                </tr>
            </table>
                <input type="submit" value="Add(+)" onclick="addURL('add')">
                <input type="submit" value="Sub(-)" onclick="addURL('sub')">
                <input type="submit" value="Multi(*)" onclick="addURL('mul')">
                <input type="submit" value="Div(/)" onclick="addURL('div')">
        </fieldset>
    </form>
    <form>
        <fieldset>
            <legend>Result</legend>
            <span>Result: ${result}</span>
        </fieldset>
    </form>
</div>
<script>
    function addURL(operator){
        var form = document.getElementById("calculator");
        form.action = "/"+encodeURIComponent(operator);
    }
</script>
</body>
</html>
