package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.Scene;

import java.io.Serializable;
import java.util.List;

public class RoomAndSceneDTO implements Serializable {
    private static final long serialVersionUID = -8274087852216336209L;

    private Integer roomId;

    private Integer venueId;

    private String roomName;

    private Integer roomLevel;

    private Short roomType; //化妆间 1  拍摄间2

    private Short priority;

    private Short roomStatus;

    private Integer companyId;

    //拍摄景
    private List<Scene> scenes;


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
        this.roomName = roomName;
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

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
