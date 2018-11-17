package com.qiein.erp.pk.web.entity.po;

/**
 * 流程编辑参数
 * author ：xiangliang
 */
public class ProcessPO {
    private Integer proId;//流程id
    private Integer venueSchId;//场馆档期id
    private Integer makeupRoomSchId;//化妆间档期id
    private String shootRoomSchId;//拍摄间档期id
    private Integer shootSchId;//摄影师档期id
    private Integer makeupSchId;//化妆师档期id
    private Integer planSchId;//企划档期id
    private Integer companyId;//公司id
    private Integer orderType;
    private Integer orderId;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public String getShootRoomSchId() {
        return shootRoomSchId;
    }

    public void setShootRoomSchId(String shootRoomSchId) {
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
