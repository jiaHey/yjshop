package com.shop.modules.shop.domain;

import com.shop.common.enums.IsDefault;
import com.shop.common.enums.YesNo;
import com.shop.modules.shop.domain.enums.SlideType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "y_slide")
public class Slide {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String imgUrl;
    private String url;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isShow;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    @Enumerated(EnumType.ORDINAL)
    private SlideType type;
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


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public SlideType getType() {
        return type;
    }

    public void setType(SlideType type) {
        this.type = type;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean show) {
        isShow = show;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
