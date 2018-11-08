package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 服务展示VO
 * author：xiangliang
 */
public class ServiceVO {
    private Integer id;//排序
    private String serviceName;//服务名称
    private int serviceType;//服务类型
    private int shootNum;
    private int makeupNum;
    private int videoNum;
    private boolean serviceStatus;//状态
    private String makeupRoomNum;//化妆间
    private String shootRoomNum;//拍摄间
    private String venueName;//场馆
    private String venueIds;
    private String peopleNum;//人员配比
    private String linkIds;
    private List<RoomGroupByServiceIdVO> makeupRoom;//化妆间
    private List<RoomGroupByServiceIdVO> shootRoom;//拍摄间

    public List<RoomGroupByServiceIdVO> getMakeupRoom() {
        return makeupRoom;
    }

    public void setMakeupRoom(List<RoomGroupByServiceIdVO> makeupRoom) {
        this.makeupRoom = makeupRoom;
    }

    public List<RoomGroupByServiceIdVO> getShootRoom() {
        return shootRoom;
    }

    public void setShootRoom(List<RoomGroupByServiceIdVO> shootRoom) {
        this.shootRoom = shootRoom;
    }

    public String getLinkIds() {
        return linkIds;
    }

    public void setLinkIds(String linkIds) {
        this.linkIds = linkIds;
    }

    public String getVenueIds() {
        return venueIds;
    }

    public void setVenueIds(String venueIds) {
        this.venueIds = venueIds;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getShootNum() {
        return shootNum;
    }

    public void setShootNum(int shootNum) {
        this.shootNum = shootNum;
    }

    public int getMakeupNum() {
        return makeupNum;
    }

    public void setMakeupNum(int makeupNum) {
        this.makeupNum = makeupNum;
    }

    public int getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public boolean isServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(boolean serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getMakeupRoomNum() {
        return makeupRoomNum;
    }

    public void setMakeupRoomNum(String makeupRoomNum) {
        this.makeupRoomNum = makeupRoomNum;
    }

    public String getShootRoomNum() {
        return shootRoomNum;
    }

    public void setShootRoomNum(String shootRoomNum) {
        this.shootRoomNum = shootRoomNum;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
}
