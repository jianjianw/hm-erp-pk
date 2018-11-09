package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.web.service.VenueScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场馆档期controller
 * author:xiangliang 2018/11/05
 */
@RestController
@RequestMapping("/venue_schedule")
public class VenueScheduleController {
    @Autowired
    private VenueScheduleService venueScheduleService;
}
