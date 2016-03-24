var Validation = new ValidationContainer();

function ValidationContainer() {

    var self = this;

    self.validatePassword = function(password) {
        var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
        return re.test(password);
    };

    self.validateString = function(text) {
        var re = /[a-z], [A-Z]/;
        return !re.test(text);
    }

}