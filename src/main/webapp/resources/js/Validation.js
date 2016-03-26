var Validation = new ValidationContainer();

function ValidationContainer() {

    var self = this;

    self.validateField = function(obj) {
        var illegalChars = /[\W_]/;

        if (obj.fieldValue == "") {
            obj.errorElement.text(obj.errorMessages.emptyField);
            obj.errorElement.show();
            return false;

        } else if ((obj.fieldValue.length < 4)) {
            obj.errorElement.text(obj.errorMessages.invalidSize);
            obj.errorElement.show();
            return false;

        } else if (illegalChars.test(obj.fieldValue)) {
            obj.errorElement.text(obj.errorMessages.invalidContent);
            obj.errorElement.show();
            return false;

        }
        return true;
    };

}