package com.qiein.erp.pk.web.entity.po;
/**
 * 服务房间关联PO
 * author：xiangliang 2018/11/05
 */
public class ServiceVenueLinkPO {
    private int serviceVenceId;//服务场景id
    private int linkId;//房间id
    private int linkType;//房间类型
    private int companyId;//公司id

    public int getServiceVenceId() {
        return serviceVenceId;
    }

    public void setServiceVenceId(int serviceVenceId) {
        this.serviceVenceId = serviceVenceId;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
