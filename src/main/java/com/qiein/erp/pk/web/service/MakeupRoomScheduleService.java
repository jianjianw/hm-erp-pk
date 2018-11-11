package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;

import java.util.List;

/**
 * 化妆间档期
 * wang lei
 */
public interface MakeupRoomScheduleService {

    int deleteByPrimaryKey(Integer id);

    int insert(MakeupRoomSchedulePO record);

    MakeupRoomSchedulePO selectByPrimaryKey(Integer id);

    List<MakeupRoomSchedulePO> selectAll();

    int updateByPrimaryKey(MakeupRoomSchedulePO record);

    /**
     * 查询化妆间的档期
     */
    public Object selectMakeupRoomSchedule(Integer companyId,Integer dateTime);
}
