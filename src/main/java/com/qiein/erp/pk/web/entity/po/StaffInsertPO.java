package com.qiein.erp.pk.web.entity.po;
/**
 * 新增用po
 * author：xiangliang
 */
public class StaffInsertPO {
    private Integer staffId;
    private Integer companyId;
    private boolean status;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
