package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.Room;

import java.io.Serializable;
import java.util.List;

/* 场馆dto
* author:wang lei
* date : 2018-11-04
* */
public class VenueDTO implements Serializable {
    private static final long serialVersionUID = 2483186702999950057L;

    private Integer id;

    private Integer baseId;

    private String venueName;

    private Short venueType;

    private String venuePhone;

    private String respo;

    private String address;

    private Short venueStatus;

    private Integer companyId;


    private List<Room> shootRooms;  //拍摄间
    private List<Room> dressingRooms;  //拍摄间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.venueName = venueName;
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
        this.venuePhone = venuePhone;
    }

    public String getRespo() {
        return respo;
    }

    public void setRespo(String respo) {
        this.respo = respo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
