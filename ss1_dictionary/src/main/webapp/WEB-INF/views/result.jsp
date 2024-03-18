
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>DICTIONARY</h1>
    <div>
        <form action="/" method="post">
            <table>
                <tr>
                    <th>Input ENG Word</th>
                    <td>
                        <input type="text" placeholder="English Word" name="ENGword"  value="${ENGword}" required>
                    </td>
                </tr>
                <tr>
                    <th>Result</th>
                    <td>
                        <input type="text" placeholder="Result" value="${VNWord}" readonly>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input type="submit" value="Translate">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</center>
</body>
</html>
