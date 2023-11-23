<%@ page import="java.util.List" %>
<%@ page import="by.kirylarol.lab7.Entity.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function findByPopulation() {
            const populationInput = document.getElementById("population").value;
            const newUrl = '<%= request.getContextPath()%>/finbypopulation?population=' + populationInput;
            window.location.href = newUrl;
        }
    </script>

    <title>Главная страница</title>
</head>
<body>
<% List<City> cityList = (List<City>) request.getAttribute("cities"); %>
<% if (cityList!= null && !cityList.isEmpty()) { %>
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
        <td><a href="<%= request.getContextPath()%>/city?id=<%=city.getCityID()%>">Перейти на страницу города</a></td>
    </tr>
    <% } %>
</table>
<% } %>

<div>
    <a href="<%= request.getContextPath()%>/newcity">Добавить город</a>
    <a href="<%= request.getContextPath()%>/addresident">Добавить этнос</a>
</div>

<div>
    <form action="<%= request.getContextPath()%>/findbypopulation" method="get">
        <input id="population" type="number" placeholder="Введите численность">
    </form>
    <button onclick="findByPopulation()">Поиск по численности</button>
    <a href="<%= request.getContextPath()%>/oldest" > Перейти к самым старым жителям</a>
</div>
</body>
</html>
