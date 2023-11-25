<%@ page import="by.kirylarol.lab7.Entity.Resident" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат поиска</title>
</head>
<body>
<h2>Результат поиска по жителям</h2>

<table border="1">
    <tr>
        <th>Название</th>
        <th>Язык</th>
    </tr>

    <% List<Resident> cityResidents = (List<Resident>) request.getAttribute("cityResidents"); %>
    <% if (cityResidents != null && !cityResidents.isEmpty()) { %>
    <% for (Resident resident : cityResidents) { %>
    <tr>
        <td><%= resident.getName() %></td>
        <td><%= resident.getLanguage() %></td>
    </tr>
    <% } %>
    <% } else { %>
    <tr>
        <td colspan="3">Нет результатов</td>
    </tr>
    <% } %>
</table>
</body>
</html>
