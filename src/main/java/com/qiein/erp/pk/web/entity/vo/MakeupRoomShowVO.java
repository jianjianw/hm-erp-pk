package com.qiein.erp.pk.web.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 返给前端的化妆间vo
 * wang lei
 */
public class MakeupRoomShowVO implements Serializable {

    private static final long serialVersionUID = -9145468983478629516L;

    private List<ServiceVenueRoomVO> serviceVenueRoomVOS; //服务和房间  表头

    private List<MakeupRoomScheduleVO> makeupRoomScheduleVOS; //化妆间档期 数据


    public List<ServiceVenueRoomVO> getServiceVenueRoomVOS() {
        return serviceVenueRoomVOS;
    }

    public void setServiceVenueRoomVOS(List<ServiceVenueRoomVO> serviceVenueRoomVOS) {
        this.serviceVenueRoomVOS = serviceVenueRoomVOS;
    }

    public List<MakeupRoomScheduleVO> getMakeupRoomScheduleVOS() {
        return makeupRoomScheduleVOS;
    }

    public void setMakeupRoomScheduleVOS(List<MakeupRoomScheduleVO> makeupRoomScheduleVOS) {
        this.makeupRoomScheduleVOS = makeupRoomScheduleVOS;
    }
}
