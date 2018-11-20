package com.qiein.erp.pk.web.entity.vo;

/**
 * 人员下拉框
 * author：xiangliang
 */
public class StaffSelectForOrderInVO {
    private Integer id;//档期id
    private Integer staffId;//人员id
    private String staffName;//人员名称
    private Integer status;//状态
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
