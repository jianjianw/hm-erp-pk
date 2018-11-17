package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.RoomSelectPO;

import java.util.List;

/**
 * 房间下拉框
 * author：xiangliang 2018/11/07
 */
public class RoomSelectVO {
    private Integer venueId;
    private String venueName;
    private List<RoomSelectPO> rooms;

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

    public List<RoomSelectPO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomSelectPO> rooms) {
        this.rooms = rooms;
    }
}
