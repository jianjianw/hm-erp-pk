package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;
/**
 * 基地
 * author:wang lei
 * date : 2018-11-04
 * */
public class BasePO implements Serializable {
    private static final long serialVersionUID = 21266182125583448L;

    private Integer id;     //场馆id

    private String baseName; //场馆名字

    private Integer companyId;  //公司id

    //新加基地状态
    private Short baseStatus;

    private Short priority;//排序


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Short getBaseStatus() {
        return baseStatus;
    }

    public void setBaseStatus(Short baseStatus) {
        this.baseStatus = baseStatus;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }
}