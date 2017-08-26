package com.shop.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Cart() {

    }



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
