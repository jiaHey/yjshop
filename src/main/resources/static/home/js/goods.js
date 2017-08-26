$(function () {
    var id = getUrlParam("id");
    $.ajax({
        type: "GET",
        url: "/home/goods/goodsDetail",
        data: {
            id: id
        },
        success: function (r) {
            if (r.code == 0) {
                vm.goods = r.goods;
                vm.gallery = r.gallery;
            } else {
                alert(r.msg);
            }
        }
    });
    $("#back").click(function () {
        history.go(-1);
    });
    $("#addCart").click(function () {
        $.ajax({
            type: "GET",
            url: "/home/cart/cartGoodsAdd",
            data: {
                id: id
            },
            success: function (r) {
                if (r.code == 0) {
                    $.toast("添加成功");
                } else {
                    alert(r.msg);
                }
            }
        });
    });
});
var vm = new Vue({
    el: '#rrapp',
    data: {
        goods: [],
        gallery: []
    },
    methods: {},
    watch: {},
    updated: function () {
        var swiper = new Swiper('.swiper-container', {
            pagination: '.swiper-pagination',
            loop: true,
            speed: 2000,
            autoplay: true,
            paginationClickable: true
        });
    }
});