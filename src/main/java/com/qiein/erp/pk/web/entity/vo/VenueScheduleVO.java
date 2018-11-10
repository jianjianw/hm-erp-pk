package com.qiein.erp.pk.web.entity.vo;
/**
 * 场馆档期显示页面
 * author:xiangliang
 */
public class VenueScheduleVO {
    private Integer time;//时间
    private int count;//实际拍摄对数
    private int targetCount;//目标拍摄对数
    private Integer scheduleId;//档期id
    private boolean isSunday;//是否是星期天

    public boolean isSunday() {
        return isSunday;
    }

    public void setSunday(boolean sunday) {
        isSunday = sunday;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(int targetCount) {
        this.targetCount = targetCount;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
