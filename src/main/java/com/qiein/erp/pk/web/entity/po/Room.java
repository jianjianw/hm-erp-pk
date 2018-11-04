package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

public class Room implements Serializable {
    private static final long serialVersionUID = 474466157479846785L;

    private Integer roomId;

    private Integer venueId;

    private String roomName;

    private Integer roomLevel;

    private Short roomType;

    private Short priority;

    private Short roomStatus;

    private Integer companyId;

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