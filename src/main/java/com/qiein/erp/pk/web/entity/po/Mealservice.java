package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;
/**
 * 套餐-服务关联表
 * author-HJF
 * */
public class Mealservice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 套餐ID
	 */
	private Integer mealId;
	/**
	 * 服务ID
	 */
	private Integer serviceId;
	/**
	 * 公司ID
	 */
	private Integer companyId;
	
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "mealService [mealId=" + mealId + ", serviceId=" + serviceId + ", companyId=" + companyId + "]";
	}
	
}
