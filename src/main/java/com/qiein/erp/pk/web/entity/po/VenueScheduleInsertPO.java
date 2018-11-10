package com.qiein.erp.pk.web.entity.po;

/**
 * 场馆档期po 用于新增
 * author：xiangliang
 */
public class VenueScheduleInsertPO {
    private Integer id;//场馆档期id
    private Integer venueId;//场馆id
    private Integer serviceId;//服务id
    private Integer venueDay;//哪一天
    private Integer venueDayLimit;//拍几套
    private Integer companyId;//公司id

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
