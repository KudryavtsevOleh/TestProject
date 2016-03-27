var Dialog = new DialogContainer();

function DialogContainer() {

    var self = this;

    self.createDialog = function(context, xhr) {
        var responseObj = JSON.parse(xhr.responseText);
        context.text(responseObj.message);
        context.dialog({
            autoOpen: false,
            show: "blind",
            hide: "explode"
        });
        context.dialog("open")
    }

}