<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 3/20/2024
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<h1>Email Setting</h1>
<p>${msg}</p>
<form:form modelAttribute="newEmail" method="post" action="/">
    <table>
        <tr>
            <th>Language</th>
            <td>
                <form:select path="language">
                    <c:forEach var="language" items="${languageList}">
                        <c:choose>
                            <c:when test="${(email.getLanguage()==language)}">
                                <form:option selected="true" value="${email.getLanguage()}"></form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${language}"></form:option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page size</th>
            <td>
                <span>Show</span>
                    <form:select path="pageSize">
                        <c:forEach var="pageSize" items="${pageSizeList}">
                            <c:choose>
                                <c:when test="${(email.getPageSize()==pageSize)}">
                                    <form:option selected="true" value="${email.getPageSize()}"></form:option>
                                </c:when>
                                <c:otherwise>
                                    <form:option value="${pageSize}"></form:option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                <spam>email per page</spam>
            </td>
        </tr>
        <tr>
            <th>Spam filter</th>
            <td>
                <c:choose>
                    <c:when test="${email.isFilter()}">
                        <form:checkbox path="filter" checked="checked"></form:checkbox>
                    </c:when>
                    <c:otherwise>
                        <form:checkbox path="filter"></form:checkbox>
                    </c:otherwise>
                </c:choose>
                 Enable Spam Filter
            </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td>
                <form:input path="signature" value="${email.signature}"></form:input>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit">
            </td>
        </tr>
    </table>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
