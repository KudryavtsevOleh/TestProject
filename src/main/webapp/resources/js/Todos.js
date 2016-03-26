var Todos = new TodosContainer();

function TodosContainer() {

    var self = this;

    var ADD_NEW_TODO_URL = "/user/addTodo";
    var CHANGE_TODO_STATUS_URL = "/user/changeTodoStatus";

    self.init = function() {
        save();
        setDoneTodo();
        hideErrorsMessages();
        logoutClick();
    };

    function logoutClick() {
        $(".logout_js").click(function() {
            logout();
        });
    }

    function logout() {
        window.localStorage.removeItem("username");
        window.localStorage.removeItem("password");
        $(".todosContainer_js").hide();
        $(".todosContainer_js").html();
        $(".loginContainer_js").show();

    }

    function hideErrorsMessages() {
        hideEmptyTaskError();
        hideEmptyPriorityError();
    }

    function hideEmptyTaskError() {
        $(".task_js").click(function () {
            $(".todoError_js").hide();
        });
    }

    function hideEmptyPriorityError() {
        $(".priority_js").click(function() {
            $(".priorityError_js").hide();
        });
    }

    function save() {
        $(".submit_js").click(function() {
            saveTodo();
        });
    }

    function setDoneTodo() {
        $(".setDoneTodo_js").click(function() {
            doneTodo(this);
        });
    }

    function doneTodo(context) {
        var id = $(context).attr("id");

        var params = {
            todoId: id
        };

        $.ajax({
            url: CHANGE_TODO_STATUS_URL,
            type: "POST",
            data: params,
            headers: {
                "X-Login": localStorage.getItem("username"),
                "X-Password": localStorage.getItem("password")
            },
            success: function() {
                $(context).hide();
            },
            error: function(xhr, textStatus, errorThrown){
                var dialogContext = $(".errorDialog_js");
                Dialog.createDialog(dialogContext);
            }
        });
    }

    function saveTodo() {
        var todo = $(".task_js").val();
        var priority = $(".priority_js option:selected").val();

        var todoErrorElement = $(".todoError_js");
        var priorityErrorElement = $(".priorityError_js");

        var todoFieldObj = {
            fieldValue: todo,
            errorElement: todoErrorElement,
            errorMessages: {
                emptyField: Messages.EMPTY_TODO,
                invalidSize: Messages.INVALID_TODO_SIZE,
                invalidContent: Messages.INVALID_TODO
            }
        };

        var isValid = Validation.validateField(todoFieldObj);
        if (!isValid) return;

        if (priority == "") {
            priorityErrorElement.text(Messages.EMPTY_PRIORITY_SELECT);
            priorityErrorElement.show();
            return;
        }


        var params = {
            task: todo,
            priority: priority
        };

        $.ajax({
            url: ADD_NEW_TODO_URL,
            type: "POST",
            data: params,
            headers: {
                "X-Login": localStorage.getItem("username"),
                "X-Password": localStorage.getItem("password")
            },
            success: function(response) {
                createNewTodo(response);
            },
            error: function(xhr, textStatus, errorThrown){
                var dialogContext = $(".errorDialog_js");
                Dialog.createDialog(dialogContext);
            }
        });
    }

    function createNewTodo(response) {
        var newTodoItem = $(".todoItem_js:first").clone();
        newTodoItem.attr("id", response.id);
        newTodoItem.data(response.status);
        newTodoItem.click(function () {
            setDoneTodo();
        });
        setPriorityColor(response.taskPriority, newTodoItem);
        newTodoItem.prepend(response.task);
        $(".todoItem_js:last").after(newTodoItem);
        newTodoItem.show();
        $(".emptyTodos_js").hide();
        $(".task_js").val("");
        $(".priority_js").val("");
    }

    function setPriorityColor(priority, element) {
        if (priority == "HIGH") {
            element.css("background", "#ff0000");
        } else if (priority == "MEDIUM") {
            element.css("background", "#33cc33");
        } else {
            element.css("background", "#66ccff");
        }
    }

}