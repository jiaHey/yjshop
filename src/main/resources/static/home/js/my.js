var vm = new Vue({
    el: '#rrapp',
    data: {
        pic: null,
    },
    methods: {},
    watch: {},
    updated: function () {
    }
});
$(function () {
    $.ajax({
        type: "POST",
        url: "/home/user/userInfo",
        success: function (r) {
            if (r.code == 0) {
                vm.pic=r.user.headimgurl;
            } else {
                alert(r.msg);
            }
        }
    });
});