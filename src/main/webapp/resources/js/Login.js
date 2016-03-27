var Login = new LoginContainer();

function LoginContainer() {

    var self = this;
    var SUCCESS_URL = "/user/todos";

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
        var usernameContext = $(".username_js");
        var passwordContext = $(".password_js");

        var usernameErrorElement = $(".invalidUsername_js");
        var passwordErrorElement = $(".invalidPassword_js");

        var usernameFieldObj = {
          fieldValue: usernameContext.val(),
          errorElement: usernameErrorElement,
          errorMessages: {
              emptyField: Messages.EMPTY_USERNAME,
              invalidSize: Messages.INVALID_USERNAME_SIZE,
              invalidContent: Messages.INVALID_USERNAME
          }
        };

        var passwordFieldObj = {
          fieldValue: passwordContext.val(),
          errorElement: passwordErrorElement,
          errorMessages: {
              emptyField: Messages.EMPTY_PASSWORD,
              invalidSize: Messages.INVALID_PASSWORD_SIZE,
              invalidContent: Messages.INVALID_PASSWORD
          }
        };

        var isValid = Validation.validateField(usernameFieldObj) && Validation.validateField(passwordFieldObj);
        if (!isValid) return;

        self.getTodosAjax(usernameContext.val(), passwordContext.val());

    }

    self.getTodosAjax = function(u, p) {
        $.ajax({
            url: SUCCESS_URL,
            type: "GET",
            headers: {
                "X-Login": u,
                "X-Password": p
            },
            success: function(response) {
                setDataToLocalStorage(u, p);
                showResponseData(response);
                clearInputData();
            },
            error: function(xhr, textStatus, errorThrown){
                var dialogContext = $(".errorDialog_js");
                Dialog.createDialog(dialogContext, xhr);
            }
        });
    };

    function clearInputData() {
        $(".username_js").val("");
        $(".password_js").val("");
    }

    function setDataToLocalStorage(u, p) {
        localStorage.setItem("username", u);
        localStorage.setItem("password", p);
    }

    function showResponseData(response) {
        var context = $(".todosContainer_js");
        context.html(response);
        context.show();
        $(".loginContainer_js").hide();
    }

}