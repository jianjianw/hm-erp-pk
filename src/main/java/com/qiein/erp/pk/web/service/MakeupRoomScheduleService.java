package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import com.qiein.erp.pk.web.entity.vo.MakeupRoomShowVO;

import java.util.List;

/**
 * 化妆间档期
 * wang lei
 */
public interface MakeupRoomScheduleService {

    int deleteByPrimaryKey(Integer id);

    int insert(MakeupRoomSchedulePO makeupRoomSchedulePO);

    MakeupRoomSchedulePO selectByPrimaryKey(Integer id);

    List<MakeupRoomSchedulePO> selectAll();

    int updateByPrimaryKey(MakeupRoomSchedulePO makeupRoomSchedulePO);

    /**
     * 查询化妆间的档期
     */
    public MakeupRoomShowVO selectMakeupRoomSchedule(Integer companyId, Integer venueId, Integer dateTime);

    /**
     * 修改每天限额
     * @param makeupRoomSchedulePO
     */
    void updateLimitByPrimaryKey(MakeupRoomSchedulePO makeupRoomSchedulePO);

    /**
     * 批量保存或编辑
     * @param makeupRoomSchedulePOS
     */
    void batSaveOrUpdate(List<MakeupRoomSchedulePO> makeupRoomSchedulePOS);
}
