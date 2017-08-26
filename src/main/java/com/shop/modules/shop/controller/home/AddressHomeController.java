package com.shop.modules.shop.controller.home;


import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Address;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.AddressService;
import com.shop.modules.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home/address")
public class AddressHomeController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/addressList")
    public R addressList() {
        User user = userService.loginWx();
        Page<Address> addressList = addressService.findAllByUserEquals(user, PageUtil.page(request));
        return R.ok().put("addressList", addressList);
    }

    @RequestMapping("/addressSave")
    public R addressSave(@RequestBody Address address) {
        User user = userService.loginWx();
        address.setUser(user);
        if (address.getIsDefault()) {
            addressService.updateNoDefault(user.getId());
        }
        addressService.save(address);
        return R.ok();
    }

    @RequestMapping("addressInfo")
    public R addressInfo(Long id) {
        Address address = addressService.findOne(id);
        return R.ok().put("address", address);
    }

    @RequestMapping("/addressDelete")
    public R addressDelete(Long id) {
        addressService.delete(id);
        return R.ok();
    }
}
