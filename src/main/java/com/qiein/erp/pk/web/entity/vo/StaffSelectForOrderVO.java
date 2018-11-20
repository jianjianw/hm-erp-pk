package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 人员下拉框
 * author：xiangliang
 */
public class StaffSelectForOrderVO {
    private Integer venueId;
    private String venueName;
    private List<StaffSelectForOrderInVO> staffSelectForOrderInVOS;

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

    public List<StaffSelectForOrderInVO> getStaffSelectForOrderInVOS() {
        return staffSelectForOrderInVOS;
    }

    public void setStaffSelectForOrderInVOS(List<StaffSelectForOrderInVO> staffSelectForOrderInVOS) {
        this.staffSelectForOrderInVOS = staffSelectForOrderInVOS;
    }
}
