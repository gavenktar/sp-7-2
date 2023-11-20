<%--
  Created by IntelliJ IDEA.
  User: kirlarla
  Date: 20.11.2023
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить этнос</title>
    <form action="https://localhost:8080/addresident">
        <input type="text" pattern="[а-яA-Z].3+" placeholder="Название населения">
        <input type="number" min="0" placeholder="Численность">
        <input type="text" pattern="[а-яA-Z].3+" placeholder="Язык">
        <input type="submit" value="Отправить">
    </form>
</head>
<body>

</body>
</html>
