package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.Meal;

import java.util.List;

/**
 * 套餐下拉框
 * author xiangliang
 */
public class MealSelectVO {
    private Integer typeId;//类型
    private String typeName;
    private List<Meal> meals;//套餐

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

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
