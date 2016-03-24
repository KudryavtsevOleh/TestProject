var Todos = new TodosContainer();

function TodosContainer() {

    var self = this;

    var ADD_NEW_TODO_URL = "/user/addTodo";

    self.init = function() {
        save();
        addTodoClick();
    };

    function save() {
        $(".submit_js").click(function() {
            saveTodo();
        });
    }

    function addTodoClick() {
        $(".addTodo_js").click(function() {
            $(".addTodoContainer_js").show();
        });
    }

    function saveTodo() {
        var task = $(".task_js").val();
        var priority = $(".priority_js option:selected").val();

        if (!task.trim() || !Validation.validateString(task)) {
            $(".error_js").show();
            return;
        }

        var params = {
            task: task,
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
                console.log(response);
                var newTodoItem = $(".todoItem_js:first").clone().html(response.task + " " + response.taskPriority + " " + response.status);
                $(".todoItem_js:last").append(newTodoItem);
                $(".emptyTodos_js").hide();
                $(".addTodoContainer_js").hide();
            },
            error: function(xhr, textStatus, errorThrown){
                $(".error_js").show();
            }
        });
    }

}