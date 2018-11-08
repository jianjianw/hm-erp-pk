package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.Room;

import java.io.Serializable;
import java.util.List;

public class LevelAndRoomDTO implements Serializable {
    private static final long serialVersionUID = 711032953678223332L;

    //等级id
    private Integer roomLevelId;
    //添加的房间类型   1 化妆间   2 拍摄间
    private String roomType;
    //等级类型
    private String roomLevelType;
    //等级code
    private Integer roomLevelCode;
    //等级name
    private String roomLevelName;
    //排序
    private Integer priority;
    //等级状态    1 开启    0关闭
    private Integer roomLevelStatus;

    private Integer companyId;

    //等级下面的房子
    private List<Room> rooms;


    public Integer getRoomLevelId() {
        return roomLevelId;
    }

    public void setRoomLevelId(Integer roomLevelId) {
        this.roomLevelId = roomLevelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomLevelType() {
        return roomLevelType;
    }

    public void setRoomLevelType(String roomLevelType) {
        this.roomLevelType = roomLevelType;
    }

    public Integer getRoomLevelCode() {
        return roomLevelCode;
    }

    public void setRoomLevelCode(Integer roomLevelCode) {
        this.roomLevelCode = roomLevelCode;
    }

    public String getRoomLevelName() {
        return roomLevelName;
    }

    public void setRoomLevelName(String roomLevelName) {
        this.roomLevelName = roomLevelName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRoomLevelStatus() {
        return roomLevelStatus;
    }

    public void setRoomLevelStatus(Integer roomLevelStatus) {
        this.roomLevelStatus = roomLevelStatus;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
