package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
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
     * @param dateTime
     * @return
     */
    ShootScheduleDTO selectSceneScheduleByDate(Integer companyId, Integer venueId, Integer dateTime);

    /**
     * 拍摄间档期打卡
     * @param companyId
     * @param id
     */
    void punchIn(Integer companyId, Integer id,Integer statusId);

    /**
     * 根据拍摄间档期id查询订单
     * @param companyId
     * @param id
     * @return
     */
    List<Object> findOrderBySceneScheduleId(Integer companyId, Integer id);
}
