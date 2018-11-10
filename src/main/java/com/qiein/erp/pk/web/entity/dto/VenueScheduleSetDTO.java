package com.qiein.erp.pk.web.entity.dto;

/**
 * 场馆档期参数
 * author：xiangliang 2018/11/10
 */
public class VenueScheduleSetDTO {
    private Integer venueId;//场馆id
    private Integer serviceId;//服务id
    private Integer start;//开始时间
    private Integer end;//结束时间
    private Integer companyId;//公司id
    private int target;//拍摄目标
    private String week;//星期

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}

