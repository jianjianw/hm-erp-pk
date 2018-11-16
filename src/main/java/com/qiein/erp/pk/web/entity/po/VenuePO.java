package com.qiein.erp.pk.web.entity.po;

import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;

import java.io.Serializable;
import java.util.List;

/**
 * 内景馆 venue_type 1
 * 门店 venue_type 2
 * author:wang lei
 * date : 2018-11-04
 * */
public class VenuePO implements Serializable {
    private static final long serialVersionUID = -1302559071626317704L;

    private Integer id;   //场馆id

    private Integer baseId;   //基地id

    private String venueName;   //场馆名字

    private Short venueType;    //场馆类型

    private String venuePhone;  //场馆电话

    private String respo;       //负责人

    private String address;     //地址

    private Short venueStatus;      //场馆状态 1开启 0 关闭

    private Integer companyId;      //公司id

    private Integer priority;       //排序

    private List<StaffRoleTypeVO> list;//场景馆对应员工

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<StaffRoleTypeVO> getList() {
        return list;
    }

    public void setList(List<StaffRoleTypeVO> list) {
        this.list = list;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName == null ? null : venueName.trim();
    }

    public Short getVenueType() {
        return venueType;
    }

    public void setVenueType(Short venueType) {
        this.venueType = venueType;
    }

    public String getVenuePhone() {
        return venuePhone;
    }

    public void setVenuePhone(String venuePhone) {
        this.venuePhone = venuePhone == null ? null : venuePhone.trim();
    }

    public String getRespo() {
        return respo;
    }

    public void setRespo(String respo) {
        this.respo = respo == null ? null : respo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getVenueStatus() {
        return venueStatus;
    }

    public void setVenueStatus(Short venueStatus) {
        this.venueStatus = venueStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}