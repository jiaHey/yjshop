document.write("<script type=\"text/javascript\" src=\"../../plugins/ueditor/ueditor.config.js\"></script>");
document.write("<script type=\"text/javascript\" src=\"../../plugins/ueditor/ueditor.all.js\"></script>");
document.write("<textarea name=\"upload_ue\" id=\"upload_ue\"></textarea>");
var _editor ;
$(function () {
    _editor=UE.getEditor('upload_ue')
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
});
var Arg;
var callbacks = {};
var Tag = 'default';
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
