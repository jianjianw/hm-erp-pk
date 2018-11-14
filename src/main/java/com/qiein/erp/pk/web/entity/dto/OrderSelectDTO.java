package com.qiein.erp.pk.web.entity.dto;

/**
 * 档期页面查询订单条件参数
 * author：xiangliang 2018/11/13
 */
public class OrderSelectDTO {
    private Integer companyId;
    private Integer venueSchId;//场馆档期id
    private Integer makeupRoomSchId;//化妆间档期id
    private Integer makeupSchId;//化妆师档期id
    private Integer shootSchId;//摄像师档期id
    private Integer planSchId;//企划档期id
    private Integer shootRoomSchId;//拍摄间档期id

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getVenueSchId() {
        return venueSchId;
    }

    public void setVenueSchId(Integer venueSchId) {
        this.venueSchId = venueSchId;
    }

    public Integer getMakeupRoomSchId() {
        return makeupRoomSchId;
    }

    public void setMakeupRoomSchId(Integer makeupRoomSchId) {
        this.makeupRoomSchId = makeupRoomSchId;
    }

    public Integer getMakeupSchId() {
        return makeupSchId;
    }

    public void setMakeupSchId(Integer makeupSchId) {
        this.makeupSchId = makeupSchId;
    }

    public Integer getShootSchId() {
        return shootSchId;
    }

    public void setShootSchId(Integer shootSchId) {
        this.shootSchId = shootSchId;
    }

    public Integer getPlanSchId() {
        return planSchId;
    }

    public void setPlanSchId(Integer planSchId) {
        this.planSchId = planSchId;
    }

    public Integer getShootRoomSchId() {
        return shootRoomSchId;
    }

    public void setShootRoomSchId(Integer shootRoomSchId) {
        this.shootRoomSchId = shootRoomSchId;
    }
}
