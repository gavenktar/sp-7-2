<%@ page import="java.util.List" %>
<%@ page import="by.kirylarol.lab7.Entity.City" %><%--
  Created by IntelliJ IDEA.
  User: kirlarla
  Date: 20.11.2023
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
    <% List<City> cityList = (List<City>) request.getAttribute("cities"); %>
    <% if (!cityList.isEmpty()) { %>
    <table>
        <tr>
            <th>Название города</th>
            <th> Год основания</th>
            <th> Площадь</th>
            <th> Перейти на страницу города</th>
        </tr>
    </table>
    <% for (City city : cityList) { %>
    <tr>
        <td><%= city.getName()%>
        </td>
        <td><%= city.getFoundationYear()%>
        </td>
        <td><%= city.getSquare()%>
        </td>
        <td><a href="http://localhost:8080/city/<%=city.getCityID()%>">Перейти на страницу города</a></td>
    </tr>
    <% } %>
    <% }%>
    <div>
        <a href="https://localhost:8080/addcity"> Добавить город</a>
        <a href="https://localhost:8080/addresidents">Добавить этнос</a>
    </div>
</head>
<body>

</body>
</html>
