package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.SceneScheduleDao;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.service.SceneScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
@Service
public class SceneScheduleServiceImpl implements SceneScheduleService {

    @Autowired
    private SceneScheduleDao sceneScheduleDao;


    @Override
    public List<SceneSchedulePO> selectScheduleByDateTime(Integer companyId, Integer venueId, Integer startTime, Integer endTime) {
        return sceneScheduleDao.selectScheduleByDateTime(companyId,venueId,startTime,endTime);
    }
}
