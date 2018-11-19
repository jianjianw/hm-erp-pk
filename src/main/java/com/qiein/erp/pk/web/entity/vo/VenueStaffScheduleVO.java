package com.qiein.erp.pk.web.entity.vo;

import java.util.List;
/**
 * 场馆人员排班表
 * @author HanJf
 *
 */
public class VenueStaffScheduleVO {
	private Integer venueId;
	private String venueName;
	private List<StaffScheduleVO> staffScheduleVO;
	private Integer staffId;
	private String nickName;
	
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
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public List<StaffScheduleVO> getStaffScheduleVO() {
		return staffScheduleVO;
	}
	public void setStaffScheduleVO(List<StaffScheduleVO> staffScheduleVO) {
		this.staffScheduleVO = staffScheduleVO;
	}
	
}
