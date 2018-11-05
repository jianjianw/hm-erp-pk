package com.qiein.erp.pk.web.entity.po;

/**
 * 服务PO
 *  author：xiangliang 2018/11/05
 */
public class ServicePO {
    private int id;
    private String serviceName;//服务名称
    private int serviceType;//服务类型
    private int shootNum;//摄像师人数
    private int makeupNum;//化妆师人数
    private int videoNum;//摄影师人数
    private boolean serviceStatus;//服务状态
    private int companyId;//公司id

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

    public boolean getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(boolean serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
