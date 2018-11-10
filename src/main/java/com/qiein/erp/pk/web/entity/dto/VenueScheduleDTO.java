package com.qiein.erp.pk.web.entity.dto;

import java.io.Serializable;

/**
 * 拍摄景档期
 */
public class VenueScheduleDTO implements Serializable {
    private static final long serialVersionUID = 5019710506918729855L;

    private Integer shootRoomId;  //拍摄间id

    private Integer sceneId;    //拍摄景id

    private Integer cameramanId; //摄影师id

    private String cameramanName;   //摄影师名字

    //private Integer


    public Integer getShootRoomId() {
        return shootRoomId;
    }

    public void setShootRoomId(Integer shootRoomId) {
        this.shootRoomId = shootRoomId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getCameramanId() {
        return cameramanId;
    }

    public void setCameramanId(Integer cameramanId) {
        this.cameramanId = cameramanId;
    }

    public String getCameramanName() {
        return cameramanName;
    }

    public void setCameramanName(String cameramanName) {
        this.cameramanName = cameramanName;
    }

}
