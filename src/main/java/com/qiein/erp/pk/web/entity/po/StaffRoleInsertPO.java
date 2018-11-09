package com.qiein.erp.pk.web.entity.po;

/**
 * 新增用po
 * author：xiangliang
 */
public class StaffRoleInsertPO {
    private Integer staffId;
    private Integer roleId;//角色id
    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
