var Todos = new TodosContainer();

function TodosContainer() {

    var self = this;

    var SUCCESS_URL = "/user/todos";

    self.init = function() {
        save();
    };

    function save() {
        $(".submit_js").click(function() {
            saveTodo();
        });
    }

    function saveTodo() {
        var task = $(".task_js").val();
        var priority = $(".priority option:selected");

        //TODO: validation

        $.ajax({
            url: "/user/login",
            headers: {
                "X-Login": localStorage.getItem("username"),
                "X-Password": localStorage.getItem("password")
            },
            success: function(response) {
                if (response == "success") {
                    window.location.href = SUCCESS_URL;
                } else {

                }
            },
            error: function(xhr, textStatus, errorThrown){
                $(".error_js").show();
            }
        });
    }

}