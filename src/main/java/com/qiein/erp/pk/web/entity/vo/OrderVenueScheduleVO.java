package com.qiein.erp.pk.web.entity.vo;

/**
 * 获取每天的档期数
 * author：xiangliang 2018/11/10
 */
public class OrderVenueScheduleVO {
    private Integer id;
    private Integer venueId;//场馆id
    private Integer venueDay;//哪一天
    private Integer venueDayLimit;//当日档期限量
    private Integer serviceId;//服务id
    private Integer count;//当日已定档期数

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

    public Integer getVenueDay() {
        return venueDay;
    }

    public void setVenueDay(Integer venueDay) {
        this.venueDay = venueDay;
    }

    public Integer getVenueDayLimit() {
        return venueDayLimit;
    }

    public void setVenueDayLimit(Integer venueDayLimit) {
        this.venueDayLimit = venueDayLimit;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
