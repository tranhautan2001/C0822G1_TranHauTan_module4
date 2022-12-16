<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16/12/2022
  Time: 4:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="mailbox" type=""--%>
<form:form action="/edit" method="post" modelAttribute="mailbox">
<form:hidden path="id"/>
    <form:label path="language" > language :</form:label>
    <form:select path="language" items="${languageList}"/>

    <form:label path="size" > size :</form:label>
    <form:select path="size" items="${pageSizeList}"/>

    <form:label path="spamsFilter" > spamsFilter :</form:label>
    <form:checkbox path="spamsFilter"/>

    <form:label path="signature" > signature :</form:label>
    <form:input path="signature"/>

    <input type="submit" value="Lưu">
</form:form>
</body>
</html>
