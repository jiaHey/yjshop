package com.shop.modules.shop.domain.vo;

import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.GoodsGallery;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GoodsVo {
    private Goods goods;
    private List<GoodsGallery> gallery;

    private List<Long> goodsTagsIdList;
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsGallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<GoodsGallery> gallery) {
        this.gallery = gallery;
    }

    public List<Long> getGoodsTagsIdList() {
        return goodsTagsIdList;
    }

    public void setGoodsTagsIdList(List<Long> goodsTagsIdList) {
        this.goodsTagsIdList = goodsTagsIdList;
    }
}
