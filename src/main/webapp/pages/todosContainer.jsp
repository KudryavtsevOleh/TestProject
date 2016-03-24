<div class="todoItem_js"></div>

<c:forEach var="todo" items="${todos}">
  <div class="todoItem_js">
  ${todo.task} ${todo.taskPriority} ${todo.status}
  </div>
</c:forEach>

<c:if test="${isEmptyTodos}">
  <div class="empty-todos emptyTodos_js">
    <span class="alert-danger">You haven't any todo</span>
  </div>
</c:if>