package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.vo.VenueScheduleShowVO;

/**
 * 场馆档期service
 * author:xiangliang 2018/11/05
 */
public interface VenueScheduleService {
    /**
     * 获取场馆档期页面
     * @param monthStr
     * @return
     */
    VenueScheduleShowVO getScheduleShow(String monthStr,Integer companyId);
}
