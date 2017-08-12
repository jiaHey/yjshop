package com.shop.modules.shop.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "y_order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goodsId")
    private Goods goods;

    private String goodsTitle;
    private Integer goodsNum;
    @Column(precision = 10, scale = 2)
    private BigDecimal goodsPrice;
    private String goodsImgUrl;


    public OrderGoods(){

    }
    public OrderGoods(Goods goods) {
        this.goods=goods;
        this.goodsImgUrl=goods.getImgUrl();
        this.goodsTitle=goods.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }
}
