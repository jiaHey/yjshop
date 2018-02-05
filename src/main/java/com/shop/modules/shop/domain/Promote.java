package com.shop.modules.shop.domain;

import com.shop.modules.shop.domain.enums.ConditionType;
import com.shop.modules.shop.domain.enums.PromoteType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 促销
 */
@Entity
@Table(name = "y_promote")
public class Promote {
    @Id
    @GeneratedValue
    private Long id;
    @Column(precision = 10, scale = 2)
    @Min(value = 0, message = "必须大于0")
    @NotNull(message = "不能为空")
    private BigDecimal promotePrice;
    /**
     * 优惠方式
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private PromoteType promoteType;
    @Column(precision = 10, scale = 2)
    @Min(value = 0, message = "必须大于0")
    @NotNull(message = "不能为空")
    private BigDecimal conditionPrice;
    /**
     * 满足促销到条件
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private ConditionType conditionType;
    @Column(columnDefinition = "TEXT")
    private String goodsIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public PromoteType getPromoteType() {
        return promoteType;
    }

    public void setPromoteType(PromoteType promoteType) {
        this.promoteType = promoteType;
    }


    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public String getGoodsIds() {
        return goodsIds;
    }

    public BigDecimal getConditionPrice() {
        return conditionPrice;
    }

    public void setConditionPrice(BigDecimal conditionPrice) {
        this.conditionPrice = conditionPrice;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }
}
