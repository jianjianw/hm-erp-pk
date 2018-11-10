package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

/*
* 拍摄间档期
* wang lei
* 2018-11-9
* */
public class ShootSchedule implements Serializable {

    private Integer id;             //拍摄间档期id

    private Integer shootId;    //拍摄间id

    private Integer sceneId;        //场景id

    private Integer startTime;  //开始时间戳

    private Integer endTime;    //结束时间戳

    private String orderId;  //订单id

    private Integer statusId;  //状态 (打卡)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
