<div class="col-xs-6">
<div class="well" style="max-height: 300px;overflow: auto; cursor: pointer;" title="Click to set todo done">
  <ul class="list-group checked-list-box">
    <li id="" class="list-group-item todoItem_js setDoneTodo_js" style="display: none;"></li>
    <c:forEach var="todo" items="${todos}">
      <li id="${todo.id}" class="list-group-item setDoneTodo_js todoItem_js"
              <c:choose>
                <c:when test="${todo.taskPriority eq 'HIGH'}">
                  style="background: #ff0000"
                </c:when>
                <c:when test="${todo.taskPriority eq 'MEDIUM'}">
                  style="background: #33cc33"
                </c:when>
                <c:otherwise>
                  style="background: #66ccff"
                </c:otherwise>
              </c:choose>
              >${todo.task}</li>
    </c:forEach>
  </ul>
  <c:if test="${isEmptyTodos}">
    <div class="empty-todos">
      <span class="alert-danger">You haven't any todo</span>
    </div>
  </c:if>
</div>
</div>