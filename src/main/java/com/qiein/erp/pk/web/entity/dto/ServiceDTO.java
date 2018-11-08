package com.qiein.erp.pk.web.entity.dto;

/**
 * 服务传参数
 * author:xiangliang 20181107
 */
public class ServiceDTO {
    private Integer id;
    private String serviceName;//服务名称
    private Integer serviceType;//服务类型
    private int shootNum;//摄像师人数
    private int makeupNum;//化妆师人数
    private int videoNum;//摄影师人数
    private String venueIds;//场馆id
    private String makeupLinkIds;//化妆间id
    private String shootLinkIds;//拍摄间id
    private boolean status;//服务状态
    private Integer companyId;//公司id

    public String getShootLinkIds() {
        return shootLinkIds;
    }

    public void setShootLinkIds(String shootLinkIds) {
        this.shootLinkIds = shootLinkIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getVenueIds() {
        return venueIds;
    }

    public void setVenueIds(String venueIds) {
        this.venueIds = venueIds;
    }

    public String getMakeupLinkIds() {
        return makeupLinkIds;
    }

    public void setMakeupLinkIds(String makeupLinkIds) {
        this.makeupLinkIds = makeupLinkIds;
    }



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
