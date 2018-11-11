package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
import com.qiein.erp.pk.web.entity.dto.TimeStampScheduleDTO;
import com.qiein.erp.pk.web.entity.dto.VenueScheduleDTO;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.service.SceneService;
import com.qiein.erp.pk.web.service.SceneScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 拍摄景档期   (拍摄间档期)
 * wang lei
 * 2018-11-9
 */
@RestController
@RequestMapping("/scene_room_schedule")
public class SceneScheduleController {

    @Autowired
    private SceneScheduleService sceneScheduleService;

    @Autowired
    private SceneService sceneService;

    private Integer  companyId=  1;
    @GetMapping("/select_scene_schedule_by_date")
    public ResultInfo selectSceneScheduleByDate(Integer venueId,Integer dateTime){
        ShootScheduleDTO shootScheduleDTO = sceneScheduleService.selectSceneScheduleByDate(companyId, venueId, dateTime);
        return ResultInfoUtil.success(shootScheduleDTO);
    }



}
