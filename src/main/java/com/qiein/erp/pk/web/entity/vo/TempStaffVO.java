package com.qiein.erp.pk.web.entity.vo;
/**
 * 人员排空
 */
public class TempStaffVO {
	private Integer id;
	private int count;//接单合计
    private String mealName;
    private Integer staffStatus;
    private Integer servieceId;
    private String serviceName;
    private Integer photoId;
    private String photoName;
    private Integer staffDay;
    private Integer orderId;
    
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getServieceId() {
		return servieceId;
	}
	public void setServieceId(Integer servieceId) {
		this.servieceId = servieceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public Integer getStaffDay() {
		return staffDay;
	}
	public void setStaffDay(Integer staffDay) {
		this.staffDay = staffDay;
	}
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
