package com.qiein.erp.pk.web.entity.vo;

import java.io.Serializable;

public class MealVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer mealType;//套餐类别
	private String  mealNmae;//套餐名称
	private Integer serviceId;//服务Id
	private String serviceName;//服务名称
	
	public Integer getMealType() {
		return mealType;
	}
	public void setMealType(Integer mealType) {
		this.mealType = mealType;
	}
	public String getMealNmae() {
		return mealNmae;
	}
	public void setMealNmae(String mealNmae) {
		this.mealNmae = mealNmae;
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
	

}
