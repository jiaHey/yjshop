package com.shop.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.modules.shop.domain.enums.ConditionType;
import com.shop.modules.shop.domain.enums.PromoteType;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户优惠券领取
 */
@Entity
@Table(name = "y_user_coupon")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "UserCoupon.promote",
                attributeNodes = @NamedAttributeNode("promote")),
        @NamedEntityGraph(name = "UserCoupon.coupon",
                attributeNodes = @NamedAttributeNode("coupon")),

        @NamedEntityGraph(name = "UserCoupon.couponPromote",
                attributeNodes = {
                        @NamedAttributeNode("coupon"),
                        @NamedAttributeNode("promote"),
                }
        )
})
public class UserCoupon {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
    @OneToOne
    @JoinColumn(name = "promoteId")
    @JsonIgnore
    private Promote promote;
    @OneToOne
    @JoinColumn(name = "couponId")
    @JsonIgnore
    private Coupon coupon;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date begin;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date end;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date created;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date updated;
    @Column(nullable = true)
    private Date used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Promote getPromote() {
        return promote;
    }

    public void setPromote(Promote promote) {
        this.promote = promote;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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

    public Date getUsed() {
        return used;
    }

    public void setUsed(Date used) {
        this.used = used;
    }
}
