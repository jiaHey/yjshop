package com.shop.modules.shop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "y_user",
        uniqueConstraints = {@UniqueConstraint(columnNames="openid")})
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String city;
    private String country;
    private String headimgurl;
    private String openid;
    private String unionid;
    private String province;
    @Column(columnDefinition = "tinyint default 0")
    private Integer sex;
    @OneToMany
    @JoinColumn(name = "userId")
    @JsonIgnore
    private Set<Order> order;

    private Date created;



    @OneToMany
    @JoinColumn(name="goods_id")
    @JsonIgnore
    private Set<Cart> cart;

    public User(){}
    public User(WxMpUser wxMpUser) {
        nickname=wxMpUser.getNickname();
        city=wxMpUser.getCity();
        country= wxMpUser.getCountry();
        openid= wxMpUser.getOpenId();
        province= wxMpUser.getProvince();
        sex=wxMpUser.getSexId();
        headimgurl=wxMpUser.getHeadImgUrl();
        unionid=wxMpUser.getUnionId();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
