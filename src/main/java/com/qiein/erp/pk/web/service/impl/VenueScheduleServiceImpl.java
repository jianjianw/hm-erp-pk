package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.VenueScheduleDao;
import com.qiein.erp.pk.web.service.VenueScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 场馆档期service
 * author:xiangliang 2018/11/05
 */
@Service
public class VenueScheduleServiceImpl implements VenueScheduleService {
    @Autowired
    private VenueScheduleDao venueScheduleDao;
}
