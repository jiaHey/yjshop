package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Address;
import com.shop.common.enums.IsDefault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.user.id=?1 and a.isDefault=?2")
    public Address findDefaultAddress(Long uid, IsDefault isDefault);
}