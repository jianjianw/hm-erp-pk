package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.entity.po.ShootSchedule;
import com.qiein.erp.pk.web.service.ShootScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
@Service
public class ShootScheduleServiceImpl implements ShootScheduleService {


    @Override
    public List<ShootSchedule> selectScheduleByDateTime(Integer companyId, Integer venueId, Integer beginTime, Integer endTime) {
        return null;
    }
}
