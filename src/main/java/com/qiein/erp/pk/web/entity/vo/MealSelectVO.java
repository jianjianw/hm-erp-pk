package com.qiein.erp.pk.web.entity.vo;

import java.util.List;
import com.qiein.erp.pk.web.entity.po.MealPO;

/**
 * 套餐下拉框
 * author xiangliang
 */
public class MealSelectVO {
    private Integer typeId;//类型
    private String typeName;
    private List<MealPO> meals;//套餐

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<MealPO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealPO> meals) {
        this.meals = meals;
    }
}
