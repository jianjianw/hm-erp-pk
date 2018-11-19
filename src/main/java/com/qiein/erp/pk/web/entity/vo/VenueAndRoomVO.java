package com.qiein.erp.pk.web.entity.vo;

import java.io.Serializable;

/**
 * 查询房间 包含场馆和服务id
 * */
public class VenueAndRoomVO implements Serializable {

    private static final long serialVersionUID = -3291459222773465997L;
    private Integer venueId;//场馆id
    private Integer serviceId;//服务id
    private Integer roomId;//房间id
    private String roomName;//房间名
    private Integer roomType;//房间类型
    //订单页面用到的数据
    //add
    private boolean roomStatus;//房间状态   1 开启  0  关闭
    //add
    private Integer makeupRoomScheduleId; //化妆间档期id


    public Integer getVenueId() {
        return venueId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
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

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getMakeupRoomScheduleId() {
        return makeupRoomScheduleId;
    }

    public void setMakeupRoomScheduleId(Integer makeupRoomScheduleId) {
        this.makeupRoomScheduleId = makeupRoomScheduleId;
    }
}
