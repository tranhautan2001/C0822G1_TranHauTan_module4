<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 15/12/2022
  Time: 11:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form method="get" action="save">
    <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
    <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
    <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
    <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
    <br>
    <td><input type="submit" value="save"></td>
  </form>
  </body>
</html>
