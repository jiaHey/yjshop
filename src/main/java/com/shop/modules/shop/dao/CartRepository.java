package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Cart;
import com.shop.modules.shop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select c from Cart c where c.user.id = :uid")
    @EntityGraph(value = "Cart.goods", type = EntityGraph.EntityGraphType.LOAD)
    public List<Cart> findCartByUserId(@Param("uid") Long uid);


    @Query("select c from Cart c where c.goods.id=:gid and c.user.id=:uid")
    public Cart findFirstByGoodsIdAndUserId(@Param("gid") Long gid, @Param("uid") Long uid);

    @Query("delete from Cart c where c.user.id =?1")
    @Modifying
    public Integer deleteByUserId(Long uid);

    public Integer deleteByIdIn(Set<Long> ids);


    @EntityGraph(value = "Cart.goods", type = EntityGraph.EntityGraphType.LOAD)
    public Cart findByIdEquals(Long id);

    public void deleteByUserEquals(User user);

    public List<Cart> findAllByUserEquals(User user);
}