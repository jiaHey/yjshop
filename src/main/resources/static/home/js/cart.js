$(function () {
    $.ajax({
        type: "GET",
        url: "/home/cart/cartGoodsList",
        success: function (r) {
            if (r.code == 0) {
                vm.cart = r.cart;
            } else {
                alert(r.msg);
            }
        }
    });
    $("#buy").click(function () {
        $.ajax({
            type: "POST",
            url: "/home/order/createOrder",
            success: function (r) {
                if (r.code == 0) {
                    window.location.href="my.html";
                } else if(r.code==302) {
                    alert(r.msg);
                    window.location.href="address.html";
                }
            }
        });
    });
    $("#edit").click(function () {
        if (vm.edit) {
            $.ajax({
                type: "POST",
                url: "/home/cart/cartGoodsEdit",
                contentType: "application/json",
                data:JSON.stringify(vm.cart),
                success: function (r) {
                    if (r.code == 0) {

                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
        vm.edit = !vm.edit;
        vm.editText = vm.edit ? '完成' : '编辑';
    });
    $("#clear").click(function () {
        $.confirm("确定清空购物车吗", function () {
            $.ajax({
                type: "GET",
                url: "/home/cart/cartGoodsClear",
                success: function (r) {
                    if (r.code == 0) {
                        vm.cart = [];
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }, function () {
            //点击取消后的回调函数
        });

    });
});

function cartEdit(obj, num) {
    var cIndex = $(obj).attr("cIndex");
    var newNum = vm.cart[cIndex].number + num;
    vm.cart[cIndex].number = newNum > 0 ? newNum : 1;
}
function cartDelete(obj) {
    var cIndex = $(obj).attr("cIndex");
    vm.cart.splice(cIndex, 1);
}
var vm = new Vue({
    el: '#rrapp',
    data: {
        cart: [],
        edit: false,
        editText: '编辑',
    },
    methods: {},
    watch: {},
    updated: function () {
    }
});