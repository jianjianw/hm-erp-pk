package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.ShootSchedule;

import java.util.List;
/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
public interface ShootScheduleService {

    /**
     * 根据开始时间和结束时间查询档期
     * @param companyId
     * @param venueId
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<ShootSchedule> selectScheduleByDateTime(Integer companyId, Integer venueId, Integer beginTime,Integer endTime);
}
