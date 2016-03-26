var Autologin = new AutologinContainer();

function AutologinContainer() {

    var self = this;

    self.autologin = function() {
        var usernameStorageValue = localStorage.getItem("username");
        var passwordStorageValue = localStorage.getItem("password");
        if (usernameStorageValue != null && passwordStorageValue != null) {
            Login.getTodosAjax(usernameStorageValue, passwordStorageValue);
        }
    };


}