package com.qiein.erp.pk.web.entity.vo;
/**
 * 人员排空
 */
public class TempStaffVO {
	private int count;//接单合计
    private String mealName;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
    
}
