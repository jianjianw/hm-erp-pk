package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

/**
 * 化妆间档期
 * wang lei
 */
public class MakeupRoomSchedulePO implements Serializable {
    private static final long serialVersionUID = -3753471065583643944L;
    private Integer id;

    private Integer venueId;

    private Integer serviceId;

    private Integer makeupRoomId;

    private Integer makeupDay;

    private Short makeupDayLimit;

    private Integer companyId;


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

    public Short getMakeupDayLimit() {
        return makeupDayLimit;
    }

    public void setMakeupDayLimit(Short makeupDayLimit) {
        this.makeupDayLimit = makeupDayLimit;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}