$(function () {
    var url = 'admin/slide/list';
    var colModel = [
        {label: 'ID', name: 'id', width: 45, key: true},
        {label: '标题', name: 'title', width: 75},
    ];
    grid(url, colModel);
    addCallBack(function () {
        //主图片
        vm.slide.imgUrl = Arg[0].src;
    }, 'imgUrl');
});
var vm = new Vue({
    el: '#rrapp',
    data: {
        keyword: null,
        showList: true,
        title: null,
        slide: {
            id: null,
            title: null,
            imgUrl: null,
            isShow:true,
            type:'HOME',
        },
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
        },
        update: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }

            vm.showList = false;
            vm.title = "修改";
            $.get(baseURL + "admin/slide/info/" + id, function (r) {
                vm.slide = r.slide
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
                    url: baseURL + "admin/slide/delete",
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
            var url = "admin/slide/save";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.slide),
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
