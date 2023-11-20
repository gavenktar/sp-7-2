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

    <% List<Resident> residentList = (List<Resident>) request.getAttribute("ResidentList") %>

    <title>Добавить город</title>
    <form id="addForm" action="http://localhost:8080/addcity">
        <input type="text" pattern="[a-zA-Z]+" placeholder="Введите название города">
        <input type="number" min="300" placeholder="Введите дату основания">
        <select multiple="multiple">
            <% if (!residentList.isEmpty()) {%>
            <% for (var resident : residentList) { %>
            <option id="<%= resident.getResidentID()%> " value="<%=  resident.getName()%>"
            <% }%>
            <% } %>
        </select>
        <input type="submit" placeholder="Добавить город">
    </form>
</head>
<body>

</body>
</html>
