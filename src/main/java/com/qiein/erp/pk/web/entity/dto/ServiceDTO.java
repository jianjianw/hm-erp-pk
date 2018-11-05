package com.qiein.erp.pk.web.entity.dto;

public class ServiceDTO {
    private int id;
    private String serviceName;
    private int serviceType;
    private int shootNum;
    private int makeupNum;
    private int videoNum;
    private String venueIds;
    private String makeupLinkIds;
    private String shookLinkIds;
    private boolean status;
    private int companyId;

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

    public String getShookLinkIds() {
        return shookLinkIds;
    }

    public void setShookLinkIds(String shookLinkIds) {
        this.shookLinkIds = shookLinkIds;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
