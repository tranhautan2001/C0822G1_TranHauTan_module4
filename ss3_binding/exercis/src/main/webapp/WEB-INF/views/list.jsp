<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16/12/2022
  Time: 2:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/bootstrap520/css/bootstrap.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
</head>
<body>
<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>STT</th>
        <th>LANGUAGE</th>
        <th>PAGE SIZE</th>
        <th>SPAMS FILTER</th>
        <th>SIGNATURE</th>
        <th>UPDATE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  var="mailbox" items="${mailboxList}" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${mailbox.language}</td>
            <td>${mailbox.size}</td>
            <td>${mailbox.spamsFilter}</td>
            <td>${mailbox.signature}</td>
            <td>
               <%-- <a type="button"  class="btn btn-danger">
                    UPDATE
                </a>--%>
                   <a class="btn btn-danger" href="/edit/${mailbox.id}">UPDATE</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
