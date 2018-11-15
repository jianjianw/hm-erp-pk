package com.qiein.erp.pk.web.entity.vo;

/**
 * 流程vo
 * author xiangliang
 */
public class ProcessVO {
    private Integer proId;//流程id
    private Integer orderType;//流程状态
    private String shootTime;//拍摄时间
    private Integer clothes;//服装套数
    private Integer venueSchId;//场馆档期id
    private Integer makeupRoomSchId;//化妆间档期id
    private Integer shootRoomSchId;//拍摄间档期id
    private Integer shootSchId;//摄影师档期id
    private Integer makeupSchId;//化妆师档期id
    private Integer planSchId;//企划档期id

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getShootTime() {
        return shootTime;
    }

    public void setShootTime(String shootTime) {
        this.shootTime = shootTime;
    }

    public Integer getClothes() {
        return clothes;
    }

    public void setClothes(Integer clothes) {
        this.clothes = clothes;
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

    public Integer getShootRoomSchId() {
        return shootRoomSchId;
    }

    public void setShootRoomSchId(Integer shootRoomSchId) {
        this.shootRoomSchId = shootRoomSchId;
    }

    public Integer getShootSchId() {
        return shootSchId;
    }

    public void setShootSchId(Integer shootSchId) {
        this.shootSchId = shootSchId;
    }

    public Integer getMakeupSchId() {
        return makeupSchId;
    }

    public void setMakeupSchId(Integer makeupSchId) {
        this.makeupSchId = makeupSchId;
    }

    public Integer getPlanSchId() {
        return planSchId;
    }

    public void setPlanSchId(Integer planSchId) {
        this.planSchId = planSchId;
    }
}
