package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.dto.MakeupRoomDTO;

import java.util.ArrayList;
import java.util.List;

/*
*  化妆间档期vo
* */
public class MakeupRoomScheduleVO {

    private Integer venueId;  //场馆id
    private Integer serviceId;  //服务id
    private Integer makeupRoomId;  //化妆间id
    private List<MakeupRoomDTO> MakeupRooms = new ArrayList<>();  //每个房间下面的1-30的数据
    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getMakeupRoomId() {
        return makeupRoomId;
    }

    public void setMakeupRoomId(Integer makeupRoomId) {
        this.makeupRoomId = makeupRoomId;
    }

    public List<MakeupRoomDTO> getMakeupRooms() {
        return MakeupRooms;
    }

    public void setMakeupRooms(List<MakeupRoomDTO> makeupRooms) {
        MakeupRooms = makeupRooms;
    }
}
