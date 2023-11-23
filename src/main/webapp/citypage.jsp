<%@ page import="by.kirylarol.lab7.Entity.City" %>
<%@ page import="by.kirylarol.lab7.Entity.Resident" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Город</title>
    <% City city = (City) request.getAttribute("City"); %>
    <% List<Resident> residentList = (List<Resident>) request.getAttribute("ResidentList"); %>
    <script>
        async function deleteByID(id) {
            try {
                const response = await fetch(
                    '<%= request.getContextPath() %>/cityresident/' + id,
                    {
                        method: 'DELETE'
                    }
                );
            } catch (error) {
                console.error(error);
            }
        }


        async function findByLanguage() {
            const langid = document.getElementById("findByLanguage").elements["langid"].value;
            const cityid = document.getElementById("findByLanguage").elements["city"].value;

            const url = `<%= request.getContextPath() %>/city?city=${cityid}&langid=${langid}`;
            window.location.href = url;
        }
    </script>

</head>
<body>
<div>
    <% if (city != null) { %>
    <div> Название города <%= city.getName() %>
    </div>
    <div> Площадь города <%= city.getSquare() %>
    </div>
    <div> Год создания города <%= city.getFoundationYear() %>
    </div>
    <% } else { %>
    <p>Город не найден</p>
    <% } %>
</div>
<div>
    <h1> Общности города <%= city.getCityID()%>
    </h1>
    <% if (city != null && city.getCityResidentList() != null) { %>
    <table>
        <tr>
            <th>Название общности</th>
            <th>Численность общности</th>
            <th>Язык общности</th>
            <th>Удалить</th>
            <th>Детали</th>
        </tr>
        <% for (var resident : city.getCityResidentList()) { %>
        <tr>
            <td><%= resident.getResident().getName() %>
            </td>
            <td><%= resident.getPopulation() %>
            </td>
            <td><%= resident.getResident().getLanguage() %>
            </td>
            <td>
                <button onclick="deleteByID('<%= resident.getCityResidentId() %>')">Удалить</button>
            </td>
            <td>
                <a href="<%= request.getContextPath() %>/resident?residentId=<%= resident.getResident().getResidentID() %>">Детали</a>
            </td>
        </tr>
        <% } %>
        <% } %>
    </table>
    <form id="findByLanguage" action="<%= request.getContextPath() %>/findbylanguage" method="get">
        <input type="text" minlength="2" placeholder="Введите название языка" name="language">
        <input type="submit" value="Поиск">
        <input type="hidden" name="city" value='<%= city.getCityID() %>'>
    </form>
    <form action="<%= request.getContextPath() %>/addcityresident" method="post">
        <input type="text" minlength="2" placeholder="Введите название языка" name="langid">
        <input type="submit" value="Поиск">
        <input type="hidden" name="city" value='<%=city.getCityID()%>'>
        <input type="number" name="population" min="0" placeholder="Численность">
        <select style="width: 200px" name="residents" multiple="multiple">
            <% if (residentList != null && !residentList.isEmpty()) {%>
            <% for (var resident : residentList) { %>
            <option id="<%= resident.getResidentID()%> " name="<%= resident.getResidentID()%>"
                    value="<%= resident.getName()%>">
                <%= resident.getName()%>
            </option>
            <% } %>
            <% } %>
        </select>
        <input type="submit" value="Добавить">
    </form>
</div>
</body>
</html>