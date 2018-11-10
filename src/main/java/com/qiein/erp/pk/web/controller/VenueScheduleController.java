package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.service.VenueScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 获取场馆档期页面
     * @param monthStr
     * @return
     */
    @GetMapping("/get_schedule_show")
    public ResultInfo getScheduleShow(@RequestParam("monthStr")String monthStr){
        Integer companyId=1;
        return ResultInfoUtil.success(venueScheduleService.getScheduleShow(monthStr,companyId));
    }
}
