package com.qiein.erp.pk.web.entity.po;


import java.io.Serializable;
/*
*  房间
*  author:wang lei
*  date : 2018-11-04
* */
public class RoomPO implements Serializable {
    private static final long serialVersionUID = 474466157479846785L;

    private Integer roomId;  //房间id

    private Integer venueId; //场馆id

    private String roomName; //房间名字

    private Integer roomLevel; //房间等级

    private Short roomType; // 房间类型 化妆间 1  拍摄间2

    private Short priority; // 排序

    private Short roomStatus;  //房间状态  1 启用  0 停用

    private Integer companyId;  //公司id

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(Integer roomLevel) {
        this.roomLevel = roomLevel;
    }

    public Short getRoomType() {
        return roomType;
    }

    public void setRoomType(Short roomType) {
        this.roomType = roomType;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Short getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Short roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}