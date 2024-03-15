<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Student Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>Add New Student</h2>

    <%--    <h2>--%>
    <%--        <a href="product?action=product">List All Product</a>--%>
    <%--    </h2>--%>
</center>
<div align="center">
    <form method="post" action="/create">

        <table border="1" cellpadding="5">
            <tr>
                <th>Student Id:</th>
                <td>
                    <input type="number" name="id" id="id" size="45" required/>
                    <br>
                    <span></span>
                </td>
            </tr>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Student description:</th>
                <td>
                    <input type="text" name="desc" id="desc" size="45" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-outline-warning" type="button" value="Cancel" onclick="window.location.href='/'" />
                    <input class="btn btn-outline-success" type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>