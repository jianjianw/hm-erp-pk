package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
*   拍摄间档期
*   wang lei
*   2018-11-13
* */
public class SceneScheduleDTO implements Serializable {
    private static final long serialVersionUID = -6865823485613103864L;

    private Integer venueId;
    private Integer roomId;
    private List<SceneSchedulePO> sceneSchedulePOS = new ArrayList<>();


    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public List<SceneSchedulePO> getSceneSchedulePOS() {
        return sceneSchedulePOS;
    }

    public void setSceneSchedulePOS(List<SceneSchedulePO> sceneSchedulePOS) {
        this.sceneSchedulePOS = sceneSchedulePOS;
    }
}
