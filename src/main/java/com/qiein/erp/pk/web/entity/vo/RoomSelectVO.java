package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.po.RoomPO;

import java.util.List;

/**
 * 房间下拉框
 * author：xiangliang 2018/11/07
 */
public class RoomSelectVO {
    private Integer venueId;
    private String venueName;
    private List<RoomPO> rooms;

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

    public List<RoomPO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomPO> rooms) {
        this.rooms = rooms;
    }
}
