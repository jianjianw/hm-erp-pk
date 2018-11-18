package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.SceneDTO;
import com.qiein.erp.pk.web.entity.dto.SceneRequestDTO;
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
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        sceneScheduleService.punchIn(companyId,id,statusId);
        //1：默认初始，预定中；2：开始，使用中；3：使用完毕；
        return ResultInfoUtil.success();
    }

    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody SceneSchedulePO sceneSchedulePO){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        sceneSchedulePO.setCompanyId(companyId);
        sceneScheduleService.insert(sceneSchedulePO);
        return ResultInfoUtil.success();
    }
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody SceneSchedulePO sceneSchedulePO){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        sceneSchedulePO.setCompanyId(companyId);
        sceneScheduleService.updateByPrimaryKey(sceneSchedulePO);
        return ResultInfoUtil.success();
    }

    /**
     * 批量新增或编辑
     */
    @PostMapping("/bat_save_or_update")
    public ResultInfo batSaveOrUpdate(@RequestBody List<SceneSchedulePO> sceneSchedulePOS){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS ){
            sceneSchedulePO.setCompanyId(companyId);
        }
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
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS ){
            sceneSchedulePO.setCompanyId(companyId);
        }
        List<SceneScheduleVO> reslut = sceneScheduleService.batSave(sceneSchedulePOS);
        return ResultInfoUtil.success(reslut);

    }

    /**
     * 批量保存，先查询再保存
     * @param sceneSchedulePOS
     * @return
     */
    @PostMapping("/bat_save_select")
    public ResultInfo batSaveSelect(@RequestBody List<SceneSchedulePO> sceneSchedulePOS){


        Integer companyId=getCurrentLoginStaff().getCompanyId();
        for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS ){
            sceneSchedulePO.setCompanyId(companyId);
        }
        ResultInfo result = sceneScheduleService.batSaveSelect(sceneSchedulePOS);
        return result;
    }

    /**
     * 批量编辑
     * @param sceneRequestDTO
     * @return
     */
    @PostMapping("/bat_update")
    public ResultInfo batUpdate(@RequestBody SceneRequestDTO sceneRequestDTO){
        List<SceneSchedulePO> sceneSchedulePOS = sceneRequestDTO.getSceneSchedulePOS();
        List<Integer> deleteIds = sceneRequestDTO.getDeleteIds();
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS ){
            sceneSchedulePO.setCompanyId(companyId);
        }
        List<SceneSchedulePO> result = sceneScheduleService.batUpdate(sceneSchedulePOS,deleteIds);
        return ResultInfoUtil.success(result);
    }

    /**
     * 批量先删除 后 插入
     * @param sceneRequestDTO
     * @return
     */
    @PostMapping("/bat_delete_update")
    public ResultInfo batDeleteUpdate(@RequestBody SceneRequestDTO sceneRequestDTO){
        List<SceneSchedulePO> sceneSchedulePOS = sceneRequestDTO.getSceneSchedulePOS();
        List<Integer> deleteIds = sceneRequestDTO.getDeleteIds();
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS ){
            sceneSchedulePO.setCompanyId(companyId);
        }
        ResultInfo resultInfo = sceneScheduleService.batDeleteUpdate(sceneSchedulePOS, deleteIds);
        return ResultInfoUtil.success(resultInfo);
    }

    /**
     * 根据场景和时间 查询场景档期   （具体景点 右边的档期列表  这期先不上）
     * @param sceneDTO
     * @return
     */
    @GetMapping("find_scene_schedule_by_scene_id_and_date")
    public ResultInfo selectSceneScheduleBySceneIdAndDate(@RequestBody SceneDTO sceneDTO){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        sceneDTO.setCompanyId(companyId);
        List<SceneSchedulePO> result = sceneScheduleService.selectSceneScheduleBySceneIdAndDate(sceneDTO);
        return ResultInfoUtil.success(result);
    }


    //根据档期id获取档期  获取多个
    @GetMapping("/find_scene_schedule_by_ids")
    public ResultInfo findSceneScheduleByIds(@RequestBody List<Integer> ids){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<SceneSchedulePO> result =  sceneScheduleService.findSceneScheduleByIds(companyId,ids);
        return ResultInfoUtil.success(result);
    }






}
