package com.qiein.erp.pk.web.entity.vo;

/**
 * 服务展示VO
 * author：xiangliang
 */
public class ServiceVO {
    private int id;
    private String serviceName;
    private int serviceType;
    private int shootNum;
    private int makeupNum;
    private int videoNum;
    private boolean serviceStatus;
    private String makeupRoomNum;
    private String shootRoomNum;
    private String venueName;
    private String peopleNum;

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
