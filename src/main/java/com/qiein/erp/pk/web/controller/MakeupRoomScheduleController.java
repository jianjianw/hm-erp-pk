package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.service.MakeupRoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 化妆间档期
 */
@RestController
@RequestMapping("/makeup_room_schedule")
public class MakeupRoomScheduleController {


    private Integer companyId = 1;

    @Autowired
    private MakeupRoomScheduleService makeupRoomScheduleService;
    /**
     * 查询化妆间的档期
     */
    public ResultInfo selectMakeupRoomSchedule(Integer dateTime){

        Object obj = makeupRoomScheduleService.selectMakeupRoomSchedule(companyId, dateTime);
        return ResultInfoUtil.success(obj);
    }


}
