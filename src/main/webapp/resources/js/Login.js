var Login = new LoginContainer();

function LoginContainer() {

    var self = this;
    var SUCCESS_URL = "/user/todos";
    var LOGIN_URL = "/user/login";

    self.init = function() {
        loginClickAction();
        hideErrorsMessages();
    };

    function hideErrorsMessages() {
        hideUsernameErrors();
        hidePasswordErrors();
    }

    function hideUsernameErrors() {
        $(".username_js").click(function() {
           $(".emptyUsername_js").hide();
           $(".invalidUsername_js").hide();
        });
    }

    function hidePasswordErrors() {
        $(".password_js").click(function() {
            $(".emptyPassword_js").hide();
            $(".invalidPassword_js").hide();
        });
    }

    function loginClickAction() {
        $(".submit_js").click(function() {
            login();
        });
    }

    function login() {
        var username = $(".username_js").val();
        var password = $(".password_js").val();

        var usernameErrorElement = $(".invalidUsername_js");
        var passwordErrorElement = $(".invalidPassword_js");

        var usernameFieldObj = {
          fieldValue: username,
          errorElement: usernameErrorElement,
          errorMessages: {
              emptyField: Messages.EMPTY_USERNAME,
              invalidSize: Messages.INVALID_USERNAME_SIZE,
              invalidContent: Messages.INVALID_USERNAME
          }
        };

        var passwordFieldObj = {
          fieldValue: password,
          errorElement: passwordErrorElement,
          errorMessages: {
              emptyField: Messages.EMPTY_PASSWORD,
              invalidSize: Messages.INVALID_PASSWORD_SIZE,
              invalidContent: Messages.INVALID_PASSWORD
          }
        };

        var isValid = Validation.validateField(usernameFieldObj) && Validation.validateField(passwordFieldObj);
        if (!isValid) return;

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
                var dialogContext = $(".errorDialog_js");
                Dialog.createDialog(dialogContext);
            }
        });
    }

}