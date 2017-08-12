$(function () {
    var url = 'admin/goods/list';
    var colModel = [
        {label: 'ID', name: 'id', width: 45, key: true},
        {label: '标题', name: 'title', width: 75},
        {label: '价格', name: 'price', width: 75},
        {label: '创建时间', name: 'created', width: 75},
    ];
    grid(url, colModel);
    addCallBack(function () {
        //主图片
        vm.goods.imgUrl = Arg[0].src;
    }, 'imgUrl');
    addCallBack(function () {
        //主图片
        $.each(Arg, function (key, item) {
            $.ajax({
                type: "POST",
                url: baseURL + 'admin/goodsGallery/save',
                data: {
                    imgUrl: item.src,
                    goodsId: vm.goods.id
                },
                success: function (r) {
                    if (r.code === 0) {
                        vm.gallery.push({
                            imgUrl: item.src
                        })
                    } else {
                        alert(r.msg);
                    }
                }
            });

        })

    }, 'gallery');
});
var vm = new Vue({
    el: '#rrapp',
    data: {
        keyword: null,
        showList: true,
        title: null,
        goods: {
            id: null,
            title: null,
            imgUrl: null,
            price: null,
            content: '',

        },
        gallery: [],
        goodsTagsList: [],
        goodsTagsIdList: [],
        ue: null,
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            ue = UE.getEditor('content');
        },
        update: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }

            vm.showList = false;
            vm.title = "修改";
            $.get(baseURL + "admin/goods/info/" + id, function (r) {
                vm.goods.id = r.goods.id;
                vm.goods.imgUrl = r.goods.imgUrl;
                vm.goods.title = r.goods.title;
                vm.goods.price = r.goods.price;
                vm.goods.content = r.goods.content;
                vm.gallery = r.gallery;
                vm.goodsTagsList = r.goodsTags;
                vm.goodsTagsIdList = r.goodsTagsIdList;
                ue = UE.getEditor('content');
                ue.addListener("contentChange", function () {
                    vm.goods.content = ue.getContent();
                });
                ue.ready(function () {
                    ue.setContent(vm.goods.content)
                });
            });


        },
        del: function () {
            var id = getSelectedRows();
            if (id == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "admin/goods/delete",
                    contentType: "application/json",
                    data: JSON.stringify(id),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            var url = "admin/goods/save";
            var data = {};
            data.gallery = vm.gallery;
            data.goods = vm.goods;
            data.goodsTagsIdList = vm.goodsTagsIdList;
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function () {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'keyword': vm.keyword},
                page: page
            }).trigger("reloadGrid");
        },
    }
});
