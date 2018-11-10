package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.vo.OrderVenueScheduleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


import com.qiein.erp.pk.web.entity.po.ShootSchedule;

/**
 * 场馆档期dao
 * author:xiangliang 2018/11/05
 */
public interface VenueScheduleDao {
    /**
     * 获取每天的档期数
     * @param companyId
     * @return
     */
    List<OrderVenueScheduleVO> getVenueSchedule(@Param("companyId") Integer companyId,@Param("start")Integer start,@Param("end")Integer end);


}
