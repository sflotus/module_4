<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 3/13/2024
  Time: 8:28 PM
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
<h1>Student Management</h1>
<button class="btn btn-outline-success" onclick="window.location.href='/create'">Add New Student</button>
</center>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="table" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                    <th>ACTION</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${list}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${student.getName()}</td>
                        <td>${student.getDescription()}</td>
                        <td>
                                <%--                            <button class="btn btn-outline-success"--%>
                                <%--                                    onclick="window.location.href='/benh_an?action=update&id=${sach.getId()}'">Edit--%>
                                <%--                            </button>--%>
                                <%--                    <a href="/product?action=delete&id=${product.id}">Delete</a>--%>
                                    <button type="button" onclick="getInfo(${student.getId()},'${student.getName()}')" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                        Delete
                                    </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Warning</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" name="deleteId" id="deleteIdProduct" hidden>
                    <span>Delete </span><span id="deleteProductName"></span><span> ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-warning" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-outline-success">Confirm</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="../../assets/jquery/jquery-3.5.1.min.js"></script>
<script src="../../assets/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../assets/datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#table').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
    function getInfo(id,name){
        document.getElementById("deleteProductName").innerText = name;
        document.getElementById("deleteIdProduct").value=id;
    }
</script>
</body>
</html>
