package com.qiein.erp.pk.web.entity.vo;

import java.util.List;
/**
 * 场馆档期显示页面
 * author:xiangliang
 */
public class ServiceScheduleVO {
    private Integer serviceId;//服务id
    private String serviceName;//服务名称
    private Integer serviceType;//服务类型
    private Integer serviceStatus;//服务状态
    private Integer venueId;//场馆id
    private String venueName;//场馆名称
    private List<VenueScheduleVO> venueScheduleVOS;//档期类

    public Integer getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Integer serviceStatus) {
        this.serviceStatus = serviceStatus;
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

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }
}
