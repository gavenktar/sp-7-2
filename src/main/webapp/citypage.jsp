<%@ page import="by.kirylarol.lab7.Entity.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Город</title>
    <% City city = (City) request.getAttribute("city"); %>
    <script>
        async function deleteByID(id) {
            try {
                const response = await fetch(
                    '<%= request.getContextPath() %>/deletecityresident/' + id,
                    {
                        method: 'DELETE'
                    }
                );
                if (response.ok) {
                    console.log('DELETE запрос успешно отправлен');
                    // Дополнительные действия после успешного удаления
                } else {
                    console.error('Ошибка при выполнении DELETE запроса');
                    // Обработка ошибки при удалении
                }
            } catch (error) {
                console.error('Ошибка при выполнении DELETE запроса:', error);
            }
        }

        async function findByLanguage(cityID, language) {
            let link =   '<%= request.getContextPath() %>/findbylanguage?cityID=' + cityID + '&language=' + language
            window.location.href = link;
        }
    </script>
</head>
<body>
<div>
    <div> Название города <%= city.getName() %> </div>
    <div> Площадь города <%= city.getSquare() %></div>
    <div> Год создания города <%= city.getFoundationYear() %></div>
</div>
<div>
    <h1> Общности города </h1>
    <table>
        <tr>
            <th>
                Название общности
            </th>
            <th>
                Численность общности
            </th>
            <th>
                Язык общности
            </th>
            <th>
                Удалить
            </th>
        </tr>
        <% for (var resident : city.getCityResidentList()){ %>
        <tr>
            <td> <%= resident.getResident().getName() %> </td>
            <td> <%= resident.getPopulation() %> </td>
            <td> <%= resident.getResident().getLanguage() %> </td>
            <td> <button onclick="deleteByID('<%= resident.getCityResidentId() %>')">Удалить</button> </td>
            <td> <button> <a href= <%= "http://localhost:8080/resident?residentId="+resident.getResident().getResidentID()  %>> </button> </td>
        </tr>
        <% }%>
    </table>
    <form onsubmit="findByLanguage('<%= city.getCityID()%>', document.getElementById('langid').value)">
        <input type="text" minlength="2" placeholder="Введите название языка" id="langid">
        <input type="submit" value="Поиск">
    </form>
</div>
</body>
</html>
