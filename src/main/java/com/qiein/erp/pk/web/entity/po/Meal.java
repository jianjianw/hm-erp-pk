package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;
/**
 * 套餐-
 * author HJF
 * */
public class Meal implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 套餐ID
	 */
	private Integer id;
	/**
	 * 套餐名称
	 */
	private String mealName;
	/**
	 * 婚纱照类型ID
	 */
	private Integer photoType;
	/**
	 * 套餐类别ID
	 */
	private Integer mealType;
	/**
	 * 套餐类别名称
	 */
	private String mealTypeName;
	/**
	 * 套餐状态
	 */
	private Integer mealStatus;
	/**
	 * 套餐价格
	 */
	private Integer mealAmount;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 排序
	 */
	private Integer priority;
	/**
	 * 衣服套数
	 */
	private Integer clothesNum;
	/**
	 * 公司id
	 */
	private Integer companyId;
	/**
	 * 服务ID
	 */
	private Integer serviceId;
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	public String getMealTypeName() {
		return mealTypeName;
	}

	public void setMealTypeName(String mealTypeName) {
		this.mealTypeName = mealTypeName;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public Integer getPhotoType() {
		return photoType;
	}
	public void setPhotoType(Integer photoType) {
		this.photoType = photoType;
	}
	public Integer getMealType() {
		return mealType;
	}
	public void setMealType(Integer mealType) {
		this.mealType = mealType;
	}
	public Integer getMealStatus() {
		return mealStatus;
	}
	public void setMealStatus(Integer mealStatus) {
		this.mealStatus = mealStatus;
	}
	public Integer getMealAmount() {
		return mealAmount;
	}
	public void setMealAmount(Integer mealAmount) {
		this.mealAmount = mealAmount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getClothesNum() {
		return clothesNum;
	}
	public void setClothesNum(Integer clothesNum) {
		this.clothesNum = clothesNum;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
