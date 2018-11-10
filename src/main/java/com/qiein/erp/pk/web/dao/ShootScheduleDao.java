package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.ShootSchedulePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 拍摄间档期
 * wang lei 
 */
public interface ShootScheduleDao {


    List<ShootSchedulePO> selectScheduleByDateTime(@Param("companyId") Integer companyId,
                                                   @Param("venueId")Integer venueId,
                                                   @Param("startTime")Integer startTime,
                                                   @Param("endTime")Integer endTime);


}
