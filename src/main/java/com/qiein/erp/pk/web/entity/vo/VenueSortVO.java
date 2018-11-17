package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.VenuePO;

import java.util.List;

/**
 * 场馆排序
 * wang lei
 * 2018-11-17
 */
public class VenueSortVO {

    private Integer baseId;
    private String baseName;
    private Integer basePriority;
    List<VenuePO> venuePOS;


    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Integer getBasePriority() {
        return basePriority;
    }

    public void setBasePriority(Integer basePriority) {
        this.basePriority = basePriority;
    }

    public List<VenuePO> getVenuePOS() {
        return venuePOS;
    }

    public void setVenuePOS(List<VenuePO> venuePOS) {
        this.venuePOS = venuePOS;
    }
}
