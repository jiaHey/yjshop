$(function () {
    var url = 'admin/coupon/list';
    var colModel = [
        {label: 'ID', name: 'id', width: 45, key: true},
        {label: '标题', name: 'title', width: 75},
    ];
    grid(url, colModel);
});
var vm = new Vue({
    el: '#rrapp',
    data: {
        keyword: null,
        showList: false,
        title: null,
        coupon:{

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
            $.get(baseURL + "admin/coupon/info/" + id, function (r) {
                vm.coupon = r.coupon
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
                    url: baseURL + "admin/coupon/delete",
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
            var url = "admin/coupon/save";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.coupon),
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
