var vm = new Vue({
    el: '#rrapp',
    data: {
        address: {
            id: null,
            area: '',
            address: '',
            phone: '',
            isDefault: false,
        },
        addressList: [],
        showList: true,
    },
    methods: {
        addressInfo: function (id) {
            vm.showList = false;
            $.ajax({
                type: "POST",
                url: "/home/address/addressInfo",
                data: {
                    id: id
                },
                success: function (r) {
                    if (r.code == 0) {
                        vm.address = r.address;
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        addressSave: function () {
            var address = vm.address;
            if (!address.id) {
                delete address["id"]
            }
            $.ajax({
                type: "POST",
                url: "/home/address/addressSave",
                contentType: "application/json",
                data: JSON.stringify(address),
                success: function (r) {
                    if (r.code == 0) {
                        vm.showList = true;
                        addressList();
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
    },
});
$(function () {
    addressList();
    $("#city-picker").cityPicker({
        title: "请选择收货地址",
        onClose: function (d) {
            vm.address.area = d.displayValue.join(' ');
        }
    });
});
function addressList() {
    $.ajax({
        type: "POST",
        url: "/home/address/addressList",
        success: function (r) {
            if (r.code == 0) {
                vm.addressList = r.addressList.content;
            } else {
                alert(r.msg);
            }
        }
    });
}