package com.qiein.erp.pk.web.entity.vo;
/**
 * 人员排空
 */
public class TempStaffVO {
	private Integer id;
	private int count;//接单合计
    private String mealName;
    private Integer staffStatus;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(Integer staffStatus) {
		this.staffStatus = staffStatus;
	}
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
