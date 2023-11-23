<%@ page import="by.kirylarol.lab7.Entity.Resident" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kirlarla
  Date: 20.11.2023
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <% List<Resident> residentList = (List<Resident>) request.getAttribute("ResidentList"); %>

    <title>Добавить город</title>
    <form id="addForm" method="post" action="<%= request.getContextPath()%>/newcity">
        <input type="text" name="cityTitle" pattern="[a-zA-Z]+" placeholder="Введите название города">
        <input type="number" name="date" min="300" placeholder="Введите дату основания">
        <input type="number" name="square" min="300" placeholder="Введите площадь">
        <input type="number" name="population" min="0" placeholder="Численность">
        <select style="width: 200px" name="residents" multiple="multiple">
            <% if (residentList!= null && !residentList.isEmpty()) {%>
            <% for (var resident : residentList) { %>
            <option id="<%= resident.getResidentID()%> " name="<%= resident.getResidentID()%>" value="<%= resident.getName()%>">
                <%= resident.getName()%>
            </option>
            <% }%>
            <% } %>
        </select>
        <input type="submit" placeholder="Добавить город">
    </form>
</head>
<body>

</body>
</html>