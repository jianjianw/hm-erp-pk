package com.qiein.erp.pk.web.entity.dto;

/**
 * 断定下拉框能否被选中
 * author：xiangliang
 */
public class MakeupRoomSchDTO {
    private Integer makeupRoomSchId;
    private Integer roomId;
    private Integer count;

    public Integer getMakeupRoomSchId() {
        return makeupRoomSchId;
    }

    public void setMakeupRoomSchId(Integer makeupRoomSchId) {
        this.makeupRoomSchId = makeupRoomSchId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
