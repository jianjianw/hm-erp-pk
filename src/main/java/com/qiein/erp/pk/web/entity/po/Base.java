package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

public class Base implements Serializable {
    private static final long serialVersionUID = 21266182125583448L;

    private Integer id;

    private String baseName;

    private Integer companyId;


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
        this.baseName = baseName == null ? null : baseName.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}