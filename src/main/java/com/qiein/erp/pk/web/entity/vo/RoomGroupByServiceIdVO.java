package com.qiein.erp.pk.web.entity.vo;

/**
 * 根据服务id对房间进行分组页面显示vo
 * author:xiangliang 2018/11/08
 */
public class RoomGroupByServiceIdVO {
    private String roomId;
    private String roomName;
    private Integer serviceId;
    private Integer roomType;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }
}
