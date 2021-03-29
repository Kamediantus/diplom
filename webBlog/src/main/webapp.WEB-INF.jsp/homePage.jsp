<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="Supertrump"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link th:href="@{/css/global.css}" rel="stylesheet" />
</head>
<body>
<header th:insert="blocks/header :: header"/><header/>
<div class="basicText" th:text="'this is the beginning of something small but important...JSP'"/>

</body>
<footer th:insert="blocks/footer :: footer"></footer>
</html>