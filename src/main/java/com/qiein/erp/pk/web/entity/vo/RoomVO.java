package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.Room;

import java.util.List;

/**
 * 下拉框展示
 */
public class RoomVO {
    private List<RoomSelectVO> makeupRoom;
    private List<RoomSelectVO> shootRoom;

    public List<RoomSelectVO> getMakeupRoom() {
        return makeupRoom;
    }

    public void setMakeupRoom(List<RoomSelectVO> makeupRoom) {
        this.makeupRoom = makeupRoom;
    }

    public List<RoomSelectVO> getShootRoom() {
        return shootRoom;
    }

    public void setShootRoom(List<RoomSelectVO> shootRoom) {
        this.shootRoom = shootRoom;
    }
}
