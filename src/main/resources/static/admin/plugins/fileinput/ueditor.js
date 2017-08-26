document.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.4.1.js\"></script>");
var _editor = UE.getEditor('upload_ue');
var Arg;
var callbacks = {};
var Tag = 'default';
_editor.ready(function () {
    _editor.hide();
    _editor.addListener('beforeInsertImage', function (t, arg) {
        Arg = arg;
        callBack();
    });
    _editor.addListener('afterUpfile', function (t, arg) {
        Arg = arg;
        callBack();
    });
});
function upImage() {
    if (arguments[0]) {
        Tag = arguments[0];
    }
    var myImage = _editor.getDialog("insertimage");
    myImage.open();
}
function upMedia() {
    if (arguments[0]) {
        Tag = arguments[0];
    }
    var myImage = _editor.getDialog("attachment");
    myImage.open();
}
function addCallBack(obj) {
    if (arguments[1]) {
        var tag = arguments[1];
    } else {
        tag = Tag;
    }
    callbacks[tag] = obj;
}
function callBack() {
    if (callbacks[Tag]) {
        callbacks[Tag]()
    }
}