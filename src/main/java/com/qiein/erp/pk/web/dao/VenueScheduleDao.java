package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.ShootSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 场馆档期dao
 * author:xiangliang 2018/11/05
 */
public interface VenueScheduleDao {


    List<ShootSchedule> selectScheduleByDateTime( @Param("companyId") Integer companyId,
                                                  @Param("venueId")Integer venueId,
                                                  @Param("beginTime")Integer beginTime,
                                                  @Param("endTime")Integer endTime);

}
