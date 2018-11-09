package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

/*
* 拍摄间档期
* wang lei
* 2018-11-9
* */
public class ShootSchedule implements Serializable {

    private Integer id;             //拍摄间档期id

    private Integer shootRoomId;    //拍摄间id

    private Integer sceneId;        //场景id

    private Integer beginTime;  //开始时间戳

    private Integer endTime;    //结束时间戳

    private String orderId;  //订单id

    private Integer status;  //状态 (打卡)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShootRoomId() {
        return shootRoomId;
    }

    public void setShootRoomId(Integer shootRoomId) {
        this.shootRoomId = shootRoomId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
