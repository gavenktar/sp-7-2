<%@ page import="by.kirylarol.lab7.Entity.Resident" %>
<%@ page import="by.kirylarol.lab7.Entity.City" %>
<%@ page import="java.util.List" %>
<%@ page import="by.kirylarol.lab7.Entity.CityResident" %><%--
  Created by IntelliJ IDEA.
  User: kirlarla
  Date: 20.11.2023
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <% Resident resident = (Resident) request.getAttribute("resident"); %>
    <title>Этнос</title>
    <div>
        Название <%= resident.getName()%>>
        Язык <%= resident.getLanguage()%>
    </div>
    <table>
        <tr>
            <th>
                Название
            </th>
            <th>
                Дата основания
            </th>
            <th> Площадь</th>
        </tr>
        <% List<CityResident> cityList = resident.getCityResidentList();
            for (var elem : cityList) {
        %>
        <tr>
            <td><%= elem.getCity().getName()%>
            </td>
            <td><%= elem.getCity().getFoundationYear()%>
            </td>
            <td><%= elem.getCity().getSquare()%>
            </td>
        </tr>
        <% }%>
    </table>
</head>
<body>

</body>
</html>
