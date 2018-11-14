package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
* 化妆间档期
* wang lei
* */

public interface MakeupRoomScheduleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(MakeupRoomSchedulePO record);

    MakeupRoomSchedulePO selectByPrimaryKey(Integer id);

    List<MakeupRoomSchedulePO> selectAll();

    int updateByPrimaryKey(MakeupRoomSchedulePO record);

    /*根据日期查询化妆间档期*/
    List<MakeupRoomSchedulePO> selectMakeupRoomScheduleByDate(@Param("companyId") Integer companyId,
                                        @Param("venueId") Integer venueId,
                                        @Param("startTime") Integer startTime,
                                        @Param("endTime") Integer endTime);

    /**
     * 修改每天限额
     * @param makeupRoomSchedulePO
     */
    void updateLimitByPrimaryKey(MakeupRoomSchedulePO makeupRoomSchedulePO);

}