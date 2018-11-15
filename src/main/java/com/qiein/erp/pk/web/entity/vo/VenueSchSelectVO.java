package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 场馆档期下拉框
 * author xiangliang
 */
public class VenueSchSelectVO {

    private Integer venueId;//场馆id
    private String venueName;//场馆名称
    private List<ServiceSchSelectVO> serviceSchSelectVOS;

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public List<ServiceSchSelectVO> getServiceSchSelectVOS() {
        return serviceSchSelectVOS;
    }

    public void setServiceSchSelectVOS(List<ServiceSchSelectVO> serviceSchSelectVOS) {
        this.serviceSchSelectVOS = serviceSchSelectVOS;
    }
}
