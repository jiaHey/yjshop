package com.shop.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "y_goods")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Goods.gallery",
                attributeNodes = @NamedAttributeNode("gallery")),
        @NamedEntityGraph(name = "Goods.specs",
                attributeNodes = @NamedAttributeNode("specs")),
        @NamedEntityGraph(name = "Goods.tags",
                attributeNodes = @NamedAttributeNode("tags")),
        @NamedEntityGraph(name = "Goods.detail",
                attributeNodes = {
                        @NamedAttributeNode("specs"),
                        @NamedAttributeNode("gallery"),
                        @NamedAttributeNode("tags"),
                }
        )
})
public class Goods {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "标题不能为空")
    private String title;
    @NotNull(message = "图片不能为空")
    private String imgUrl;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date created;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date updated;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(precision = 10, scale = 2)
    @Min(value = 0,message = "价格必须大于0")
    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "goodsId")
    @JsonIgnore
    private Set<GoodsGallery> gallery;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "goodsId")
    @JsonIgnore
    private Set<GoodsSpec> specs;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "y_goods_tags_goods",
            joinColumns = @JoinColumn(name = "goodsId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tagsId", referencedColumnName = "id")

    )
    @JsonIgnore
    private Set<GoodsTags> tags;

    @OneToMany
    @JoinColumn(name="goods_id")
    @JsonIgnore
    private Set<Cart> cart;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public Set<GoodsGallery> getGallery() {
        return gallery;
    }

    public void setGallery(Set<GoodsGallery> gallery) {
        this.gallery = gallery;
    }

    public Set<GoodsSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(Set<GoodsSpec> specs) {
        this.specs = specs;
    }

    public Set<GoodsTags> getTags() {
        return tags;
    }

    public void setTags(Set<GoodsTags> tags) {
        this.tags = tags;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
