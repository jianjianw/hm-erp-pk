package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

public class DictionaryErp implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	/**
     * 类型
     */
    private String dicType;
    /**
     * 编码
     */
    private Integer dicCode;
    /**
     * 名称
     */
    private String dicName;

    /**
     * 顺序
     */
    private Integer priority;
    /**
     * 备用字段
     */
    private String spare;
    /**
     * 企业ID
     */
    private Integer companyId;
    /**
     * 是否启用
     */
    private boolean showFlag;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDicType() {
		return dicType;
	}
	public void setDicType(String dicType) {
		this.dicType = dicType;
	}
	public Integer getDicCode() {
		return dicCode;
	}
	public void setDicCode(Integer dicCode) {
		this.dicCode = dicCode;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public boolean isShowFlag() {
		return showFlag;
	}
	public void setShowFlag(boolean showFlag) {
		this.showFlag = showFlag;
	}
	
	
}
