package com.shop.modules.shop.domain;

import com.shop.common.enums.IsDefault;

import javax.persistence.*;

@Entity
@Table(name = "y_address")
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String area;

    private String phone;
    @ManyToOne
    private User user;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isDefault;
    public Long getId() {
        return id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
