var vm = new Vue({
    el: '#rrapp',
    data: {
        orderList: [],
        order: {},
        orderListShow: true,
    },
    methods: {
        orderDetail: function (item) {
            vm.orderListShow=false;
            vm.order=item
        },
        goodsDetail:function (gId) {
            location.href = "goods.html?id=" + gId;
        },
    },
    watch: {},
    updated: function () {

    }
});
$(function () {
    loadList();
    $("#rrapp").infinite().on("infinite", function () {
        loadList();
    });
});
var page = 1;
var hasNext = true;
function loadList() {
    if (!hasNext) {
        return;
    } else {
        hasNext = false;
    }
    $.ajax({
        type: "GET",
        url: "/home/order/orderList",
        data: {
            page: page,
            rows: 4,
        },
        success: function (r) {
            if (r.code == 0) {
                if (vm.orderList.length) {
                    vm.orderList = vm.orderList.concat(r.page.content);
                } else {
                    vm.orderList = r.page.content;
                }
                page++;
                if (!r.page.last) {
                    hasNext = true;
                }
            } else {
                alert(r.msg);
            }
        }
    });
}