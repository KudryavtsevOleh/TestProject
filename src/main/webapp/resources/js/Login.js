var Login = new LoginContainer();

function LoginContainer() {

    var self = this;
    var SUCCESS_URL = "/user/todos";
    var LOGIN_URL = "/user/login";

    self.init = function() {
        loginClickAction();
    };

    function loginClickAction() {
        $(".submit_js").click(function() {
            login();
        });
    }

    function login() {
        var username = $(".username_js").val();
        var password = $(".password_js").val();

        validateInputData(username, password);

        $.ajax({
           url: LOGIN_URL,
           type: "POST",
           headers: {
                "X-Login": username,
                "X-Password": password
            },
            success: function(response) {
                localStorage.setItem("username", username);
                localStorage.setItem("password", password);

                var client = new XMLHttpRequest();
                client.open("GET", SUCCESS_URL);
                client.setRequestHeader("X-Login", username);
                client.setRequestHeader("X-Password", password);
                client.send();
            },
            error: function(xhr, textStatus, errorThrown){
                $(".error_js").show();
            }
        });
    }

    function validateInputData(u, p) {
        if (!u.trim()) {
            $(".emptyUsername_js").show();
        }
        if (!p.trim()) {
            $(".emptyPassword_js").show();
        }
        if (!Validation.validateString(u)) {
            $(".invalidUsername_js").show();
        }
        if (!Validation.validatePassword(p)) {
            $(".invalidPassword_js").show();
        }
    }

}