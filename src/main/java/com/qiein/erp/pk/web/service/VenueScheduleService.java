package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.VenueScheduleSetDTO;
import com.qiein.erp.pk.web.entity.vo.VenueScheduleSetVO;
import com.qiein.erp.pk.web.entity.vo.VenueScheduleShowVO;

import java.util.List;

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
    /**
     * 场馆档期设置页面
     */
    List<VenueScheduleSetVO> getVenueScheduleSet(Integer companyId);
    /**
     * 档期设置
     */
     void VenueScheduleSet(VenueScheduleSetDTO venueScheduleSetDTO);
}
