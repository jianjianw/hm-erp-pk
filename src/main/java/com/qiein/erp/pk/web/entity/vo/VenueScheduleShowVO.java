package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 场馆档期显示页面
 * author:xiangliang
 */
public class VenueScheduleShowVO {
    private List<VenueServiceVO> venueServiceVOS;//表头
    private List<ServiceScheduleVO> serviceScheduleVOS;//数据

    public List<VenueServiceVO> getVenueServiceVOS() {
        return venueServiceVOS;
    }

    public void setVenueServiceVOS(List<VenueServiceVO> venueServiceVOS) {
        this.venueServiceVOS = venueServiceVOS;
    }

    public List<ServiceScheduleVO> getServiceScheduleVOS() {
        return serviceScheduleVOS;
    }

    public void setServiceScheduleVOS(List<ServiceScheduleVO> serviceScheduleVOS) {
        this.serviceScheduleVOS = serviceScheduleVOS;
    }
}
