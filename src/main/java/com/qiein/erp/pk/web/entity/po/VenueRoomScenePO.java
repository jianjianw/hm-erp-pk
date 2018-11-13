package com.qiein.erp.pk.web.entity.po;

import com.qiein.erp.pk.web.entity.po.Scene;

import java.io.Serializable;
import java.util.List;

/**
 * 场馆/房间 拍摄景 dto
 * 拍摄景档期
 */
public class VenueRoomScenePO implements Serializable {


    private static final long serialVersionUID = 6023036765566046331L;

    private Integer venueId;
    private String venueName;
    private Integer roomId;
    private String roomName;
    private Integer companyId;

    //拍摄景
    private List<Scene> scenes;

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
