package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.Room;

import java.util.List;

/**
 * 下拉框展示
 */
public class RoomVO {
    private List<Room> makeupRoom;
    private List<Room> shootRoom;

    public List<Room> getMakeupRoom() {
        return makeupRoom;
    }

    public void setMakeupRoom(List<Room> makeupRoom) {
        this.makeupRoom = makeupRoom;
    }

    public List<Room> getShootRoom() {
        return shootRoom;
    }

    public void setShootRoom(List<Room> shootRoom) {
        this.shootRoom = shootRoom;
    }
}
