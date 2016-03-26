var Dialog = new DialogContainer();

function DialogContainer() {

    var self = this;

    self.createDialog = function(context) {
        context.dialog({
            autoOpen: false,
            show: "blind",
            hide: "explode"
        });
        context.dialog("open")
    }

}