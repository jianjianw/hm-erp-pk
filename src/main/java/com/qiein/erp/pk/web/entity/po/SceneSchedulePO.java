package com.qiein.erp.pk.web.entity.po;

import com.qiein.erp.pk.web.entity.vo.StaffVO;

import java.io.Serializable;

/*
* 拍摄间档期
* wang lei
* 2018-11-9
* */
public class SceneSchedulePO implements Serializable {

    private Integer id;             //拍摄间档期id

    private Integer shootId;    //拍摄间id

    private Integer sceneId;        //场景id

    private Integer startTime;  //开始时间戳

    private Integer endTime;    //结束时间戳

    private String orderId;  //订单id

    private Integer statusId;  //状态 (打卡)

    private Integer companyId; //公司id

    private Integer venueId;    //场馆id

    private StaffVO staffVO;


    //add 订单新增时 要传入的数据  batSave() 和 batSaveSelect()时要传
    private String sceneName; //场景name
    //add  下拉框里面的数据是否可选  ture 可选
    private boolean select;

    //add
    private String venueName;
    private String roomName;





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

    public StaffVO getStaffVO() {
        return staffVO;
    }

    public void setStaffVO(StaffVO staffVO) {
        this.staffVO = staffVO;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
