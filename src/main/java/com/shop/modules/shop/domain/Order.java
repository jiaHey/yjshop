package com.shop.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.modules.shop.domain.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="y_order")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Order.orderGoods",
                attributeNodes = @NamedAttributeNode("orderGoods")),
        @NamedEntityGraph(name = "Order.detail",
                attributeNodes = {
                        @NamedAttributeNode("orderGoods"),
                }
        )
})
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    @Column(precision = 10, scale = 2)
    @Min(0)
    private BigDecimal price;
    @NotNull
    private String addressStr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Set<OrderGoods> orderGoods;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date created;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date updated;
    private OrderStatus status;

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }


    public Set<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Set<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
