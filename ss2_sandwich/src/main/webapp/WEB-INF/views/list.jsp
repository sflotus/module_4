<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 3/18/2024
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h1>Sandwich Condiments</h1>
</center>
<div class="d-flex justify-content-center align-items-center">
    <div style="width: 800px">
        <form action="/" method="post">
            <fieldset>
                <legend>Sandwich Condiments</legend>
                <br>
                <input class="form-check-input" type="checkbox" name="condiments" value="Lettuce" id="Lettuce">
                <label  for="Lettuce">Lettuce</label>
                <br>
                <input class="form-check-input" type="checkbox" name="condiments" value="Tomato" id="Tomato">
                <label for="Tomato">Tomato</label>
                <br>
                <input class="form-check-input" type="checkbox" name="condiments" value="Mustard" id="Mustard">
                <label for="Mustard">Mustard</label>
                <br>
                <input class="form-check-input" type="checkbox" name="condiments" value="Sprouts" id="Sprouts">
                <label for="Sprouts">Sprouts</label>
                <br>
                <br>
                <input type="submit" value="save" class="btn btn-outline-success">
            </fieldset>
        </form>
        <form>
            <fieldset>
                <legend>Result</legend>
                <Span>Result: </Span>
                <c:forEach var="condiment" items="${condiments}">
                    <span>${condiment}, </span>
                </c:forEach>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
