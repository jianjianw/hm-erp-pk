package com.qiein.erp.pk.web.entity.vo;

import java.io.Serializable;

/**
 * 查询房间 包含场馆和服务id
 * */
public class VenueAndRoomVO implements Serializable {

    private static final long serialVersionUID = -3291459222773465997L;
    private Integer venueId;//场馆id
    private Integer serviceId;//服务id
    private String roomId;//房间id
    private String roomName;//房间名
    private Integer roomType;//房间类型


    public Integer getVenueId() {
        return venueId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }
}
