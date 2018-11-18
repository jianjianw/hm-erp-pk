package com.qiein.erp.pk.web.entity.vo;

/**
 * author：xiangliang
 */
public class ShootRoomVO {
    private Integer shootRoomSchId;//拍摄景档期id
    private Integer roomId;//拍摄间id
    private String shootRoomName;//拍摄景名称
    private Integer start;//开始
    private Integer end;//结束
    private Integer sceneId;//拍摄景id
    public Integer getShootRoomSchId() {
        return shootRoomSchId;
    }

    public void setShootRoomSchId(Integer shootRoomSchId) {
        this.shootRoomSchId = shootRoomSchId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getShootRoomName() {
        return shootRoomName;
    }

    public void setShootRoomName(String shootRoomName) {
        this.shootRoomName = shootRoomName;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
