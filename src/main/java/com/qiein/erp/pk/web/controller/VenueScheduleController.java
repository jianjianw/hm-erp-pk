package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.VenueScheduleSetDTO;
import com.qiein.erp.pk.web.service.VenueScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /**
     * 场馆档期设置页面
     */
    @GetMapping("/get_venue_schedule_set")
    public ResultInfo getVenueScheduleSet(){
        Integer companyId=1;
        return ResultInfoUtil.success(venueScheduleService.getVenueScheduleSet(companyId));
    }
    /**
     * 场馆设置
     */
    @PostMapping("/venue_schedule_set")
    public ResultInfo VenueScheduleSet(@RequestBody VenueScheduleSetDTO venueScheduleSetDTO){
        Integer companyId=1;
        venueScheduleSetDTO.setCompanyId(companyId);
        if(venueScheduleSetDTO.getEnd()==null){
            venueScheduleSetDTO.setEnd(venueScheduleSetDTO.getStart()+ CommonConstant.THERE_YEAR_TIME);
        }
        venueScheduleService.VenueScheduleSet(venueScheduleSetDTO);
        return ResultInfoUtil.success();
    }
}