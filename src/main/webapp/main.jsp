<%@ page import="java.util.List" %>
<%@ page import="by.kirylarol.lab7.Entity.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function findByPopulation() {
            const populationInput = document.getElementById("populationInput").value;
            const newUrl = 'http://localhost:8080/populations?population=' + populationInput;
            window.location.href = newUrl;
        }
    </script>

    <title>Главная страница</title>
</head>
<body>
<% List<City> cityList = (List<City>) request.getAttribute("cities"); %>
<% if (!cityList.isEmpty()) { %>
<table>
    <tr>
        <th>Название города</th>
        <th>Год основания</th>
        <th>Площадь</th>
        <th>Перейти на страницу города</th>
    </tr>
    <% for (City city : cityList) { %>
    <tr>
        <td><%= city.getName() %></td>
        <td><%= city.getFoundationYear() %></td>
        <td><%= city.getSquare() %></td>
        <td><a href="http://localhost:8080/city/<%=city.getCityID()%>">Перейти на страницу города</a></td>
    </tr>
    <% } %>
</table>
<% } %>

<div>
    <a href="https://localhost:8080/addcity">Добавить город</a>
    <a href="https://localhost:8080/addresidents">Добавить этнос</a>
</div>

<div>
    <form onsubmit="event.preventDefault(); findByPopulation();">
        <input id="populationInput" type="number" placeholder="Введите численность">
        <button type="submit">Поиск по численности</button>
    </form>
    <a href="https://localhost:8080/oldest" > Перейти к самым старым жителям</a>
</div>
</body>
</html>
