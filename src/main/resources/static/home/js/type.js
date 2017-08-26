$(function () {
    $.ajax({
        type: "GET",
        url: "/home/goodsTags/goodsTagsList",
        success: function (r) {
            if (r.code == 0) {
                vm.goodsTagsList = r.goodsTagsList;
                tagsId = vm.goodsTagsList[0].id;
                loadList();
            } else {
                alert(r.msg);
            }
        }
    });
    $("#lists").infinite().on("infinite", function () {
        loadList();
    });
});
var page = 1;
var hasNext = true;
var tagsId = 1;
function loadList() {
    if (!hasNext) {
        return;
    } else {
        hasNext = false;
    }
    $.ajax({
        type: "GET",
        url: "/home/goods/goodsTags",
        data: {
            id: tagsId,
            page: page
        },
        success: function (r) {
            if (r.code == 0) {
                if (vm.goodsList.length) {
                    vm.goodsList = vm.goodsList.concat(r.goodsList.content);
                } else {
                    vm.goodsList = (r.goodsList.content);
                }
                page++;
                if (!r.goodsList.last) {
                    hasNext = true;
                }
            } else {
                alert(r.msg);
            }
        }
    });
}
var vm = new Vue({
    el: '#rrapp',
    data: {
        goodsTagsList: [],
        goodsList: [],
    },
    methods: {
        changeTags: function (id) {
            vm.goodsList = [];
            tagsId = id;
            page = 1;
            hasNext = true;
            loadList();
        }
    },
    watch: {},
    updated: function () {
    }
});