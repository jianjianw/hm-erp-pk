package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

/**
 * 化妆间档期
 * wang lei
 */
public class MakeupRoomSchedulePO implements Serializable {
    private static final long serialVersionUID = -3753471065583643944L;

    private Integer id; //档期id

    private Integer venueId;    //场馆id

    private Integer serviceId;  //服务id

    private Integer makeupRoomId; //化妆间id

    private Integer makeupDay;    //化妆日期 精确到天

    private Integer makeupDayLimit; //每日限额

    private Integer companyId;

    //add
    private Integer orderType;      //拍摄类型


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getMakeupRoomId() {
        return makeupRoomId;
    }

    public void setMakeupRoomId(Integer makeupRoomId) {
        this.makeupRoomId = makeupRoomId;
    }

    public Integer getMakeupDay() {
        return makeupDay;
    }

    public void setMakeupDay(Integer makeupDay) {
        this.makeupDay = makeupDay;
    }

    public Integer getMakeupDayLimit() {
        return makeupDayLimit;
    }

    public void setMakeupDayLimit(Integer makeupDayLimit) {
        this.makeupDayLimit = makeupDayLimit;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}