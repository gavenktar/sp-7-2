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
    <form action="<%= request.getContextPath()%>/addresident" method="post">
        <input type="text" name="name"  placeholder="Название населения">
        <input type="text" name="language" placeholder="Язык">
        <input type="submit" value="Отправить">
    </form>
</head>
<body>

</body>
</html>
