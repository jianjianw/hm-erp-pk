package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 场馆档期显示页面
 * author:xiangliang
 */
public class VenueServiceVO {
    private Integer venueId;//场馆id
    private String venueName;//场馆名称
    private Integer venueStatus;//场馆状态
    private List<ServiceScheduleVO> serviceScheduleVOS;//服务类

    public Integer getVenueStatus() {
        return venueStatus;
    }

    public void setVenueStatus(Integer venueStatus) {
        this.venueStatus = venueStatus;
    }

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

    public List<ServiceScheduleVO> getServiceScheduleVOS() {
        return serviceScheduleVOS;
    }

    public void setServiceScheduleVOS(List<ServiceScheduleVO> serviceScheduleVOS) {
        this.serviceScheduleVOS = serviceScheduleVOS;
    }
}
