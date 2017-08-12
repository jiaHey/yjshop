var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        menu: {
            id: null,
            parentName: '',
            parentId: null,
            type:0,
            orderNum: 0,
            url: null,
            perms: null,
            name: null,
            icon: null,
        }
    },
    methods: {
        getMenu: function () {
            //加载菜单树
            $.get(baseURL + "sys/menu/select", function (r) {
                ztree = $.fn.zTree.init($("#menuTree"), setting, r.menuList);
                var node = ztree.getNodeByParam("id", vm.menu.parentId);
                ztree.selectNode(node);
                vm.menu.parentName = node.name;
            })
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.menu = {parentName: null, parentId: 0, type: 1, orderNum: 0};
            vm.getMenu();
        },
        update: function () {
            var menuId = getMenuId();
            if (menuId == null) {
                return;
            }

            $.get(baseURL + "sys/menu/info/" + menuId, function (r) {
                vm.showList = false;
                vm.title = "修改";
                vm.menu = {
                    id: r.menu.id,
                    parentName: r.parent?r.parent.name:null,
                    parentId: r.parent?r.parent.id:null,
                    type: r.menu.type,
                    orderNum: r.menu.orderNum,
                    url: r.menu.url,
                    perms: r.menu.perms,
                    name: r.menu.name,
                    icon: r.menu.icon,
                };
                vm.getMenu();
            });
        },
        del: function () {
            var menuId = getMenuId();
            if (menuId == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/menu/delete",
                    data: "menuId=" + menuId,
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
            });
        },
        saveOrUpdate: function () {
            if (vm.validator()) {
                return;
            }
            var url =  "sys/menu/save" ;
            $.ajax({
                type: "POST",
                url: baseURL + url,
                data: vm.menu,
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
        menuTree: function () {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#menuLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    // //选择上级菜单
                    vm.menu.parentId = node[0].id;
                    vm.menu.parentName = node[0].name;
                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            Menu.table.refresh();
        },
        validator: function () {
            if (isBlank(vm.menu.name)) {
                alert("菜单名称不能为空");
                return true;
            }

            //菜单
            if (vm.menu.type === 1 && isBlank(vm.menu.url)) {
                alert("菜单URL不能为空");
                return true;
            }
        }
    }
});


var Menu = {
    id: "menuTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Menu.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '菜单ID', field: 'id', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '菜单名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级菜单', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {
            title: '图标',
            field: 'icon',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '80px',
            formatter: function (item, index) {
                return item.icon == null ? '' : '<i class="' + item.icon + ' fa-lg"></i>';
            }
        },
        {
            title: '类型',
            field: 'type',
            align: 'center',
            valign: 'middle',
            sortable: true,
            width: '100px',
            formatter: function (item, index) {
                if (item.type === 0) {
                    return '<span class="label label-primary">目录</span>';
                }
                if (item.type === 1) {
                    return '<span class="label label-success">菜单</span>';
                }
                if (item.type === 2) {
                    return '<span class="label label-warning">按钮</span>';
                }
            }
        },
        {title: '排序号', field: 'orderNum', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '菜单URL', field: 'url', align: 'center', valign: 'middle', sortable: true, width: '160px'},
        {title: '授权标识', field: 'perms', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};


function getMenuId() {
    var selected = $('#menuTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}


$(function () {
    var colunms = Menu.initColumn();
    var table = new TreeTable(Menu.id, baseURL + "sys/menu/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("parentId");
    table.setExpandAll(false);
    table.init();
    Menu.table = table;
});
