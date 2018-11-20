package com.qiein.erp.pk.web.entity.dto;

import java.io.Serializable;

public class MakeupRoomDTO implements Serializable {
    private static final long serialVersionUID = -888228371449016178L;


    private Integer date; // 时间
    private Integer scheduleId; //档期id
    private Boolean isSunday; //是否是星期天
    private Integer makeupDayLimit; //  每日档期限额
    //add
    private Integer orderType;  //订单类型
    private Integer roomStatus; //房间的状态
    private Integer countNum;    //拍摄流程个数
    private String mealName;    //套餐名字
    private String serviceName; //服务名字
    private String venueName;   //场馆名字
    private Integer orderId;     //订单id


    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
