package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.AddressRepository;
import com.shop.modules.shop.domain.Address;
import com.shop.common.enums.IsDefault;
import com.shop.modules.shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address findDefaultAddress(Long uid) {
        return addressRepository.findDefaultAddress(uid, true);
    }

    public Page<Address> findAllByUserEquals(User user, Pageable pageable) {
        return addressRepository.findAllByUserEquals(user, pageable);
    }

    public void delete(Long id) {
        addressRepository.delete(id);
    }

    @Transactional
    public void updateNoDefault(Long userId) {
        addressRepository.updateNoDefault(userId);
    }

    public Address findOne(Long id) {
       return addressRepository.findOne(id);
    }
}
