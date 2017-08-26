package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Address;
import com.shop.common.enums.IsDefault;
import com.shop.modules.shop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.user.id=?1 and a.isDefault=?2")
    public Address findDefaultAddress(Long uid, Boolean isDefault);

    public Page<Address> findAllByUserEquals(User user, Pageable pageable);

    @Query("update Address a set a.isDefault=0 where user_id=:uid")
    @Modifying
    public void updateNoDefault(@Param("uid") Long userId);
}