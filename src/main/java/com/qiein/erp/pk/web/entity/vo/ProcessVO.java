package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 流程vo
 * author xiangliang
 */
public class ProcessVO {
    private Integer proId;//流程id
    private Integer venueId;//场馆id
    private Integer serviceId;//服务id
    private Integer orderType;//流程状态
    private String shootTime;//拍摄时间
    private int clothes;//服装套数
    private Integer venueSchId;//场馆档期id
    private String venueName;//场馆名称
    private Integer makeupRoomSchId;//化妆间档期id
    private String makeupRoomName;//化妆间名称
    private List<ShootRoomVO> shootRooms;//拍摄景档期list
    private Integer shootSchId;//摄影师档期id
    private String shootName;//摄影师名字
    private Integer makeupSchId;//化妆师档期id
    private String makeupName;//化妆师名称
    private Integer planSchId;//企划档期id
    private String planName;//企划名称
    private Integer planTime;//企划时间
    private Integer videoSchId;//摄像师档期id
    private String videoName;
    private Integer followPeopleId;
    private String followPeopleName;

    public Integer getFollowPeopleId() {
        return followPeopleId;
    }

    public void setFollowPeopleId(Integer followPeopleId) {
        this.followPeopleId = followPeopleId;
    }

    public String getFollowPeopleName() {
        return followPeopleName;
    }

    public void setFollowPeopleName(String followPeopleName) {
        this.followPeopleName = followPeopleName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Integer getVideoSchId() {
        return videoSchId;
    }

    public void setVideoSchId(Integer videoSchId) {
        this.videoSchId = videoSchId;
    }

    public Integer getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Integer planTime) {
        this.planTime = planTime;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getMakeupRoomName() {
        return makeupRoomName;
    }

    public void setMakeupRoomName(String makeupRoomName) {
        this.makeupRoomName = makeupRoomName;
    }

    public String getShootName() {
        return shootName;
    }

    public void setShootName(String shootName) {
        this.shootName = shootName;
    }

    public String getMakeupName() {
        return makeupName;
    }

    public void setMakeupName(String makeupName) {
        this.makeupName = makeupName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public List<ShootRoomVO> getShootRooms() {
        return shootRooms;
    }

    public void setShootRooms(List<ShootRoomVO> shootRooms) {
        this.shootRooms = shootRooms;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getShootTime() {
        return shootTime;
    }

    public void setShootTime(String shootTime) {
        this.shootTime = shootTime;
    }

    public int getClothes() {
        return clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    public Integer getVenueSchId() {
        return venueSchId;
    }

    public void setVenueSchId(Integer venueSchId) {
        this.venueSchId = venueSchId;
    }

    public Integer getMakeupRoomSchId() {
        return makeupRoomSchId;
    }

    public void setMakeupRoomSchId(Integer makeupRoomSchId) {
        this.makeupRoomSchId = makeupRoomSchId;
    }

    public Integer getShootSchId() {
        return shootSchId;
    }

    public void setShootSchId(Integer shootSchId) {
        this.shootSchId = shootSchId;
    }

    public Integer getMakeupSchId() {
        return makeupSchId;
    }

    public void setMakeupSchId(Integer makeupSchId) {
        this.makeupSchId = makeupSchId;
    }

    public Integer getPlanSchId() {
        return planSchId;
    }

    public void setPlanSchId(Integer planSchId) {
        this.planSchId = planSchId;
    }
}
