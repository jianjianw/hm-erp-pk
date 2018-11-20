package com.qiein.erp.pk.web.entity.vo;

/**
 * 人员排空
 */
public class StaffScheduleVO {
	private Integer id;
    private Integer venueId;
    private Integer staffDayLimit;
    private Integer staffStatus;
    private String venueName;
    private Integer staffId;
    private String nickName;
    private Integer roleLevel;
    private Integer roleId;
    private String roleName;
    private Integer time;
    private Integer companyId;
    private int status;
    private int count;//接单合计
    private String mealName;
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
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
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
	public Integer getStaffDay() {
		return staffDay;
	}
	public void setStaffDay(Integer staffDay) {
		this.staffDay = staffDay;
	}
	public StaffScheduleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffScheduleVO(Integer venueId, Integer staffDayLimit, Integer staffStatus, Integer staffId, Integer time,
			Integer companyId) {
		super();
		this.venueId = venueId;
		this.staffDayLimit = staffDayLimit;
		this.staffStatus = staffStatus;
		this.staffId = staffId;
		this.time = time;
		this.companyId = companyId;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public Integer getStaffDayLimit() {
		return staffDayLimit;
	}
	public void setStaffDayLimit(Integer staffDayLimit) {
		this.staffDayLimit = staffDayLimit;
	}
	public Integer getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(Integer staffStatus) {
		this.staffStatus = staffStatus;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getRoleLevel() {
		return roleLevel;
	}
	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
    
    
}
