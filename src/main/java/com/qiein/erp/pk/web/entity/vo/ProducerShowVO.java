package com.qiein.erp.pk.web.entity.vo;

import java.util.List;
/**
 * 生产者页面
 * author:xiangliang 2018/11/09
 */
public class ProducerShowVO {
    private List<VenueSelectVO> venues;//场馆id
    private List<StaffRoleTypeVO> staffRoleTypeVOS;//员工等级展示页面

    public List<VenueSelectVO> getVenues() {
        return venues;
    }

    public void setVenues(List<VenueSelectVO> venues) {
        this.venues = venues;
    }

    public List<StaffRoleTypeVO> getStaffRoleTypeVOS() {
        return staffRoleTypeVOS;
    }

    public void setStaffRoleTypeVOS(List<StaffRoleTypeVO> staffRoleTypeVOS) {
        this.staffRoleTypeVOS = staffRoleTypeVOS;
    }
}
