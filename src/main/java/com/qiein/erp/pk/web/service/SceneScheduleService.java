package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;

import java.util.List;
/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
public interface SceneScheduleService {

    /**
     * 根据开始时间和结束时间查询档期
     * @param companyId
     * @param venueId
     * @param startTime
     * @param endTime
     * @return
     */
    List<SceneSchedulePO> selectSceneScheduleByDate(Integer companyId, Integer venueId, Integer startTime, Integer endTime);
}