package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.MakeupRoomScheduleDao;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import com.qiein.erp.pk.web.service.MakeupRoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MakeupRoomScheduleServiceImpl implements MakeupRoomScheduleService {

    @Autowired
    private MakeupRoomScheduleDao makeupRoomScheduleDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return makeupRoomScheduleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MakeupRoomSchedulePO record) {
        return makeupRoomScheduleDao.insert(record);
    }

    @Override
    public MakeupRoomSchedulePO selectByPrimaryKey(Integer id) {
        return makeupRoomScheduleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<MakeupRoomSchedulePO> selectAll() {
        return makeupRoomScheduleDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(MakeupRoomSchedulePO makeupRoomSchedulePO) {
        return makeupRoomScheduleDao.updateByPrimaryKey(makeupRoomSchedulePO);
    }
}
