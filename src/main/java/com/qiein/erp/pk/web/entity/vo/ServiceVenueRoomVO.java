package com.qiein.erp.pk.web.entity.vo;

import java.util.ArrayList;
import java.util.List;

/*
* 服务场馆 房间vo
* */
public class ServiceVenueRoomVO {

    private Integer serviceId;//服务id
    private String serviceName;//服务名称
    private Integer serviceType;//服务类型
    private String venueName;//场馆
    private Integer venueId;//场馆id
    private Integer venueStatus;//场馆状态

    private List<VenueAndRoomVO> makeupRooms  = new ArrayList<>();//服务下面的化妆间


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

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public List<VenueAndRoomVO> getMakeupRooms() {
        return makeupRooms;
    }

    public void setMakeupRooms(List<VenueAndRoomVO> makeupRooms) {
        this.makeupRooms = makeupRooms;
    }

    public Integer getVenueStatus() {
        return venueStatus;
    }

    public void setVenueStatus(Integer venueStatus) {
        this.venueStatus = venueStatus;
    }
}
