package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.VenueScheduleDao;
import com.qiein.erp.pk.web.entity.po.ShootSchedule;
import com.qiein.erp.pk.web.service.ShootScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
@Service
public class ShootScheduleServiceImpl implements ShootScheduleService {

    @Autowired
    private VenueScheduleDao venueScheduleDao;


    @Override
    public List<ShootSchedule> selectScheduleByDateTime(Integer companyId, Integer venueId, Integer beginTime, Integer endTime) {
        return venueScheduleDao.selectScheduleByDateTime(companyId,venueId,beginTime,endTime);
    }
}
