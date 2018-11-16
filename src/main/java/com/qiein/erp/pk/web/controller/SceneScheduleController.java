package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.SceneDTO;
import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.entity.vo.SceneScheduleVO;
import com.qiein.erp.pk.web.service.SceneScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 拍摄景档期   (拍摄间档期)
 * wang lei
 * 2018-11-9
 */
@RestController
@RequestMapping("/scene_room_schedule")
public class SceneScheduleController extends InitController{

    @Autowired
    private SceneScheduleService sceneScheduleService;

    @GetMapping("/select_scene_schedule_by_date")
    public ResultInfo selectSceneScheduleByDate(Integer venueId,Integer dateTime){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        ShootScheduleDTO shootScheduleDTO = sceneScheduleService.selectSceneScheduleByDate(companyId, venueId, dateTime);
        return ResultInfoUtil.success(shootScheduleDTO);
    }
    //打卡
    @PostMapping("/punch_in")
    public ResultInfo punchIn(Integer id,Integer statusId){//拍摄间档期id   statusId拍摄间档期状态
        //status_id
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        sceneScheduleService.punchIn(companyId,id,statusId);
        //1：默认初始，预定中；2：开始，使用中；3：使用完毕；
        return ResultInfoUtil.success();
    }

    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody SceneSchedulePO sceneSchedulePO){
        sceneScheduleService.insert(sceneSchedulePO);
        return ResultInfoUtil.success();
    }
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody SceneSchedulePO sceneSchedulePO){
        sceneScheduleService.updateByPrimaryKey(sceneSchedulePO);
        return ResultInfoUtil.success();
    }

    /**
     * 批量新增或编辑
     */
    @PostMapping("/bat_save_or_update")
    public ResultInfo batSaveOrUpdate(@RequestBody List<SceneSchedulePO> sceneSchedulePOS){
        sceneScheduleService.batSaveOrUpdate(sceneSchedulePOS);
        return ResultInfoUtil.success();
    }

    /**
     * 批量保存拍摄景档期
     * @param sceneSchedulePOS
     * @return
     */
    @PostMapping("/bat_save")
    public ResultInfo batSave(@RequestBody List<SceneSchedulePO> sceneSchedulePOS){
        //如果要防止添加重复记录 就要一条一条插入   。  也是可以的
        List<SceneScheduleVO> reslut = sceneScheduleService.batSave(sceneSchedulePOS);
        return ResultInfoUtil.success(reslut);
    }

    /**
     * 根据场景和时间 查询场景档期
     * @param sceneDTO
     * @return
     */
    public ResultInfo selectSceneScheduleByVenueIdAndDate(@RequestBody SceneDTO sceneDTO){
        Integer companyId=getCurrentLoginStaff().getCompanyId();

        List<SceneSchedulePO> result = sceneScheduleService.selectSceneScheduleByVenueIdAndDate(sceneDTO);

        return ResultInfoUtil.success(result);
    }






}
