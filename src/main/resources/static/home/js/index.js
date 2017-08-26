$(function () {
    loadList();
    $.ajax({
        type: "GET",
        url: "/home/index/",
        success: function (r) {
            if (r.code == 0) {
                vm.slide = r.slide;
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
function loadList() {
    if (!hasNext) {
        return;
    } else {
        hasNext = false;
    }
    var url = '';
    if (vm.search) {
        url = '/home/goods/searchGoods';
    } else {
        url = '/home/goods/newsGoods';
    }

    $.ajax({
        type: "GET",
        url: url,
        data: {
            page: page,
            search: vm.search,
        },
        success: function (r) {
            if (r.code == 0) {
                if (vm.lists.length) {
                    vm.lists = vm.lists.concat(r.page.content);
                } else {
                    vm.lists = (r.page.content);
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

var vm = new Vue({
    el: '#rrapp',
    data: {
        slide: [],
        lists: [],
        search: '',
    },
    methods: {},
    watch: {
        search: function (val, old) {
            if (val!=old) {
                page = 1;
                hasNext = true;
                vm.lists=[];
            }
            loadList();
        }
    },
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