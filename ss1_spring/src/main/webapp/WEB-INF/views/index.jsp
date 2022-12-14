<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 14/12/2022
  Time: 1:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency converter </title>
  </head>
  <body>
  <h1>Currency converter </h1>

  <form action="/usd" method="post">
    <label> Rate : </label>
    <input type="text" name="rate" placeholder="Rate" value="23000"><br>
    <label> USD :</label>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <input type="submit" id="submit" value="Converter">
  </form>
  </body>
</html>
