package com.qiein.erp.pk.web.entity.vo;

/**
 * 场馆档期下拉框
 * author xiangliang
 */
public class ServiceSchSelectVO {
    private Integer VenueSchId;//场馆档期id
    private Integer serviceId;//服务id
    private String serviceName;//服务名称
    private int count;//数量
    private int target;//目标
    private boolean status;//状态

    public Integer getVenueSchId() {
        return VenueSchId;
    }

    public void setVenueSchId(Integer venueSchId) {
        VenueSchId = venueSchId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
