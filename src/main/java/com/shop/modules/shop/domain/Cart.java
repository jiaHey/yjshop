package com.shop.modules.shop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "y_cart")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Cart.goods",
                attributeNodes = @NamedAttributeNode("goods")),
        @NamedEntityGraph(name = "Cart.user",
                attributeNodes = @NamedAttributeNode("user"))
})
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(columnDefinition = "INT(11) UNSIGNED DEFAULT '0'")
    private Integer number;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="goods_id")
    private Goods goods;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
