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
    private int count;//当日已定档期数
    private Integer orderType;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
