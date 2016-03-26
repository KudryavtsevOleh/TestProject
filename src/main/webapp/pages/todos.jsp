<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Todos page</title>
    <%@include file="headers.jsp"%>
    <script src="/resources/js/Todos.js"></script>
</head>
<body>
    <div class="container" id="main">
        <h1>Ultimate To-Do List</h1>
        <div class="addTodoContainer_js">
            <%@include file="addTodo.jsp"%>
        </div>
    </div>
    <div class="todos-container" style="margin-left: 280px;">
        <%@include file="todosContainer.jsp"%>
    </div>
    <script>
        Todos.init();
    </script>
    <div class="errorDialog_js" style="display: none;">Internal server error.</div>
</body>
</html>