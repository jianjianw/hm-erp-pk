package com.qiein.erp.pk.web.entity.vo;

/**
 * 员工展示页面
 * author：xiangliang 2018/11/08
 */
public class StaffSelectVO {
    private Integer id;
    private String staffName;//员工姓名
    private String nickName;//昵称
    private String phone;//电话
    private String headImg;//头像
    private String roleIds;//角色id
    private String roleNames;//角色名称
    private String venueNames;//内景馆名称
    private String venueIds;//内景馆id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getVenueNames() {
        return venueNames;
    }

    public void setVenueNames(String venueNames) {
        this.venueNames = venueNames;
    }

    public String getVenueIds() {
        return venueIds;
    }

    public void setVenueIds(String venueIds) {
        this.venueIds = venueIds;
    }
}
