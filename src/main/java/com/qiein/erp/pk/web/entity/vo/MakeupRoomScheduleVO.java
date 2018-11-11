package com.qiein.erp.pk.web.entity.vo;

/*
*  化妆间档期vo
* */
public class MakeupRoomScheduleVO {

    private Integer date; // 时间
    private Integer makeupRoomId;  //化妆间id
    private Integer scheduleId; //档期id
    private Boolean isSunday; //是否是星期天
    private Integer makeupDayLimit; //  每日档期限额

    private Integer venueId;  //场馆id
    private Integer serviceId;  //服务id

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getMakeupRoomId() {
        return makeupRoomId;
    }

    public void setMakeupRoomId(Integer makeupRoomId) {
        this.makeupRoomId = makeupRoomId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Boolean isSunday() {
        return isSunday;
    }

    public void setIsSunday(Boolean sunday) {
        isSunday = sunday;
    }

    public Integer getMakeupDayLimit() {
        return makeupDayLimit;
    }

    public void setMakeupDayLimit(Integer makeupDayLimit) {
        this.makeupDayLimit = makeupDayLimit;
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
}
