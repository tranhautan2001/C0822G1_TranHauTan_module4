<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 15/12/2022
  Time: 11:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result</h1>
<C:forEach items="${condiment}" var="ration">
    <h1>${ration}</h1>
</C:forEach>
</body>
</html>
