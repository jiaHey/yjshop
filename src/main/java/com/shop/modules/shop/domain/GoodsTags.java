package com.shop.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.common.enums.YesNo;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "y_goods_tag")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "goods",
                attributeNodes = @NamedAttributeNode("goods")),
})
public class GoodsTags {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToMany
    @JoinTable(
            name = "y_goods_tags_goods",
            joinColumns = @JoinColumn(name = "tagsId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "goodsId",referencedColumnName = "id")

    )
    @JsonIgnore
    private Set<Goods> goods;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isHot;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isShow;
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

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean show) {
        isShow = show;
    }
}
