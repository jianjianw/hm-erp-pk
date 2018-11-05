package com.qiein.erp.pk.web.entity.po;
/**
 * 服务场馆关联PO
 * author：xiangliang 2018/11/05
 */
public class ServiceVenuePO {
    private int id;
    private int serviceId;//服务id
    private int venueId;//场馆id
    private int companyId;//公司id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
