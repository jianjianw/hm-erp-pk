package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.Venue;

import java.util.List;

/**
 * 场馆下拉框
 * author：xiangliang 2018/11/07
 */
public class VenueSelectVO {
    private Integer baseId;
    private String baseName;
    List<Venue> venues;

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
