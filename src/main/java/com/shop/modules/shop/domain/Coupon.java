package com.shop.modules.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by heyujia on 2017/11/24.
 */
@Entity
@Table(name = "y_coupon")
public class Coupon {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "标题不能为空")
    private String title;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "promoteId")
    @JsonIgnore
    private Promote promote;

    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date begin;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date end;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date created;
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private Date updated;

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

    public Promote getPromote() {
        return promote;
    }

    public void setPromote(Promote promote) {
        this.promote = promote;
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

}
