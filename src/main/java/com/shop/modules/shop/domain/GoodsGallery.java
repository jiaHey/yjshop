package com.shop.modules.shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "y_goods_gallery")
public class GoodsGallery {
    @Id
    @GeneratedValue
    private Long id;
    private String imgUrl;

    private Long goodsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
