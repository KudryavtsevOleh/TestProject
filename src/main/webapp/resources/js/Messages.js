var Messages = new MessagesContainer();

function MessagesContainer() {

    this.EMPTY_USERNAME = "Username must not be empty.";
    this.EMPTY_PASSWORD = "Password must not be empty.";
    this.EMPTY_TODO = "Todo must not be empty.";

    this.INVALID_USERNAME_SIZE = "The username is too small.";
    this.INVALID_PASSWORD_SIZE = "The password is too small.";
    this.INVALID_TODO_SIZE = "The todo is too small.";

    this.INVALID_USERNAME = "The username contains illegal characters.";
    this.INVALID_PASSWORD = "The password contains illegal characters.";
    this.INVALID_TODO = "The todo contains illegal characters.";

    this.EMPTY_PRIORITY_SELECT = "The priority must not be empty."

}