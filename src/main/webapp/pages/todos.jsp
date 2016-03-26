<div class="container" id="main">
    <h1>Ultimate To-Do List</h1>
    <input type="button" value="Logout" class="logout_js btn btn-primary add_button">
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