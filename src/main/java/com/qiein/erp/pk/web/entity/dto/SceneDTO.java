package com.qiein.erp.pk.web.entity.dto;


import java.io.Serializable;

public class SceneDTO implements Serializable {
    private static final long serialVersionUID = -2090391419659702910L;

    private Integer sceneId; //场景id

    private Integer companyId;  //公司id

    private Integer venueId;  //场馆id

    private Integer shootId;    //拍摄间id

    private Integer date;       //具体到日时间戳


    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
