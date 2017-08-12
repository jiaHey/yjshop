package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.AddressRepository;
import com.shop.modules.shop.domain.Address;
import com.shop.common.enums.IsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address findDefaultAddress(Long uid) {
        return addressRepository.findDefaultAddress(uid, IsDefault.YES);
    }
}
