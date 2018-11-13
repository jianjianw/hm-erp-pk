package com.qiein.erp.pk.web.entity.dto;

/**
 * 订单查询页面参数
 * author：xiangliang
 */
public class OrderDTO {
    private String timeType;//时间类型
    private Integer start;//开始时间
    private Integer end;//结束时间
    private String venueId;//场馆id
    private String shootId;//摄影师id
    private String makeupId;//化妆师id
    private String videoId;//摄像师id
    private String staffId;//员工id
    private String mealIds;//套餐id
    private Integer orderType;//订单状态
    private Integer companyId;

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
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

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getShootId() {
        return shootId;
    }

    public void setShootId(String shootId) {
        this.shootId = shootId;
    }

    public String getMakeupId() {
        return makeupId;
    }

    public void setMakeupId(String makeupId) {
        this.makeupId = makeupId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getMealIds() {
        return mealIds;
    }

    public void setMealIds(String mealIds) {
        this.mealIds = mealIds;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
