package com.qiein.erp.pk.web.entity.dto;

import java.io.Serializable;

public class MakeupRoomDTO implements Serializable {
    private static final long serialVersionUID = -888228371449016178L;


    private Integer date; // 时间
    private Integer scheduleId; //档期id
    private Boolean isSunday; //是否是星期天
    private Integer makeupDayLimit; //  每日档期限额


    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Boolean isSunday() {
        return isSunday;
    }

    public void setIsSunday(Boolean sunday) {
        isSunday = sunday;
    }

    public Integer getMakeupDayLimit() {
        return makeupDayLimit;
    }

    public void setMakeupDayLimit(Integer makeupDayLimit) {
        this.makeupDayLimit = makeupDayLimit;
    }
}
