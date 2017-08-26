package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Order;
import com.shop.modules.shop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.user.id = ?1")
    public Page<Order> pageByUserId(Long id, Pageable pageable);

    @EntityGraph(value = "Order.detail", type = EntityGraph.EntityGraphType.LOAD)
    public Order findByIdIs(Long id);

    @Query("select o from Order o where o.number like CONCAT('%',:text,'%')")
    Page<Order> findFullText(String keyword, Pageable pageable);

    Page<Order> findAllByUserEquals(User user, Pageable pageable);

    @Query("select o from Order o where o.user=:user")
    @EntityGraph(value = "Order.detail", type = EntityGraph.EntityGraphType.LOAD)
    Page<Order> findDetailByUserEquals(@Param("user") User user, Pageable pageable);

}
