package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import com.qiein.erp.pk.web.entity.vo.MakeupRoomShowVO;
import com.qiein.erp.pk.web.entity.vo.VenueAndRoomVO;
import com.qiein.erp.pk.web.service.MakeupRoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping("/select_makeup_room_schedule_by_date")
    public ResultInfo selectMakeupRoomSchedule(Integer venueId, Integer dateTime){
        MakeupRoomShowVO result = makeupRoomScheduleService.selectMakeupRoomSchedule(companyId, venueId,dateTime);
        return ResultInfoUtil.success(result);
    }

    /**
     * 编辑每日限额
     */
    @PostMapping("/update_limit_by_primary_key")
    public ResultInfo updateLimitByPrimaryKey(@RequestBody MakeupRoomSchedulePO makeupRoomSchedulePO){
        makeupRoomSchedulePO.setCompanyId(companyId);
        makeupRoomScheduleService.updateLimitByPrimaryKey(makeupRoomSchedulePO);
        return ResultInfoUtil.success();
    }

    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody MakeupRoomSchedulePO makeupRoomSchedulePO){
        makeupRoomScheduleService.insert(makeupRoomSchedulePO);
        return ResultInfoUtil.success();
    }
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody MakeupRoomSchedulePO makeupRoomSchedulePO){
        makeupRoomScheduleService.updateByPrimaryKey(makeupRoomSchedulePO);
        return ResultInfoUtil.success();
    }

    /**
     * 批量保存或者编辑
     * @param makeupRoomSchedulePOS
     * @return
     */
    @PostMapping("bat_save_or_update")
    public ResultInfo batSaveOrUpdate(@RequestBody List<MakeupRoomSchedulePO> makeupRoomSchedulePOS){
        makeupRoomScheduleService.batSaveOrUpdate(makeupRoomSchedulePOS);
        return ResultInfoUtil.success();
    }

    /**
     * 根据服务id 查询化妆间档期
     * @param venueId
     * @param serviceId
     * @param date
     * @return
     */
    @GetMapping("find_makeup_room_schedule_by_service_id")
    public ResultInfo findMakeupRoomScheduleByServiceId(Integer venueId,Integer serviceId,Integer date){
        List<VenueAndRoomVO> result = makeupRoomScheduleService.findMakeupRoomScheduleByServiceId(companyId, venueId, serviceId, date);
        return ResultInfoUtil.success(result);
    }




}
