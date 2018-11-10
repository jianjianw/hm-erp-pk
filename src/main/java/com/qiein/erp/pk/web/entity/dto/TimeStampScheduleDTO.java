package com.qiein.erp.pk.web.entity.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间戳档期  拍摄景
 * wang lei
 * 2018-11-9
 */
public class TimeStampScheduleDTO {

    private Integer timeStamp;   // 时间戳  2018-09-01 9:00

    private List<VenueScheduleDTO> venueSchedule = new ArrayList<>();//拍摄景档期


    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<VenueScheduleDTO> getVenueSchedule() {
        return venueSchedule;
    }

    public void setVenueSchedule(List<VenueScheduleDTO> venueSchedule) {
        this.venueSchedule = venueSchedule;
    }
}
