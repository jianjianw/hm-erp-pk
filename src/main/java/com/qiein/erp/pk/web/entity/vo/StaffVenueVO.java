package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 场馆-员工，二级下拉框选项
 * author：gaoxiaoli 2018/11/19
 */
public class StaffVenueVO {
    private Integer venueId;//场馆id
    private String venueName;//场馆名称
    private List<StaffVO> staffList;//员工列表

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

    public List<StaffVO> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<StaffVO> staffList) {
        this.staffList = staffList;
    }
}
