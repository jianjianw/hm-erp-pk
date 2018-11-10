package com.qiein.erp.pk.web.entity.vo;

import java.util.List;
/**
 * 场馆档期显示页面
 * author:xiangliang
 */
public class ServiceScheduleVO {
    private Integer serviceId;//服务id
    private String serviceName;//服务名称
    private List<VenueScheduleVO> venueScheduleVOS;//档期类

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<VenueScheduleVO> getVenueScheduleVOS() {
        return venueScheduleVOS;
    }

    public void setVenueScheduleVOS(List<VenueScheduleVO> venueScheduleVOS) {
        this.venueScheduleVOS = venueScheduleVOS;
    }
}
