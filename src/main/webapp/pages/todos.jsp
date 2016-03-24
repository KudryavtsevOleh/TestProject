<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Todos page</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <script src="/resources/js/Todos.js"></script>
    <script src="/resources/js/Validation.js"></script>
    <script src="/resources/js/jquery-1.8.2.min.js"></script>
</head>
<body>
    <div class="add-todo-container">
        <div class="add-todo-item">
            <button class="addTodo_js">Add new Todo</button>
        </div>
        <div class="addTodoContainer_js" style="display: none;">
            <%@include file="addTodo.jsp"%>
        </div>
    </div>
    <div class="todos-container">
        <%@include file="todosContainer.jsp"%>
    </div>
    <script>
        Todos.init();
    </script>
</body>
</html>