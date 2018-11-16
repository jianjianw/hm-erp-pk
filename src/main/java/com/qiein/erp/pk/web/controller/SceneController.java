package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ObjectUtil;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.po.ScenePO;
import com.qiein.erp.pk.web.service.SceneService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
@RestController
@RequestMapping("/scene")
public class SceneController extends InitController{


    @Autowired
    private SceneService sceneService;
    @ApiOperation(value = "根据id删除拍摄景")
    @PostMapping("/delete_by_primary_key")
    @ApiImplicitParam(name = "id", value = "场景id" ,dataType = "Integer")
    public ResultInfo deleteByPrimaryKey(Integer id){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        sceneService.deleteByPrimaryKey(id,companyId);
        return ResultInfoUtil.success();
    }

    @ApiOperation(value = "新增拍摄景")
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody ScenePO scene){

        Integer companyId=getCurrentLoginStaff().getCompanyId();
        scene.setCompanyId(companyId);
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(scene);
        sceneService.insert(scene);
        return ResultInfoUtil.success();
    }

    @ApiOperation(value = "根据id查询拍摄景")
    @GetMapping("/select_by_primary_key")
    @ApiImplicitParam(name = "id", value = "场景id" ,dataType = "Integer")
    public ResultInfo selectByPrimaryKey(Integer id){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        ScenePO scene = sceneService.selectByPrimaryKey(id,companyId);
        return ResultInfoUtil.success(scene);
    }

    @ApiOperation(value = "查询所有的拍摄景")
    @GetMapping("/select_all")
    public ResultInfo selectAll(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<ScenePO> scenes = sceneService.selectAll(companyId);
        return ResultInfoUtil.success(scenes);
    }

    @ApiOperation(value = "根据id更新")
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody ScenePO scene){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        scene.setCompanyId(companyId);
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(scene);
        sceneService.updateByPrimaryKey(scene);
        return ResultInfoUtil.success();
    }


    @ApiOperation(value = "查询拍摄间下的拍摄景")
    @ApiImplicitParam(name = "roomId", value = "房间id" ,dataType = "Integer")
    //查询拍摄间下面的拍摄景
    @GetMapping("/find_scene_by_room_id")
    public ResultInfo findSceneByRoomId(Integer roomId){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<ScenePO> list  = sceneService.findSceneByRoomId(companyId,roomId);
        return ResultInfoUtil.success(list);

    }

    @ApiOperation(value = "排序")
    //场景排序，修改优先级
    @PostMapping("/scene_sort")
    public ResultInfo sceneSort(@RequestBody List<ScenePO> scenes){
        sceneService.sceneSort(scenes);
        return ResultInfoUtil.success();
    }

    @ApiOperation(value = "查询场馆下面的房间和拍摄景")
    @ApiImplicitParam(name = "venueId", value = "场馆id" ,dataType = "Integer")
    //查询场馆下面的所有拍摄景
    @GetMapping("/find_scene_by_venue_id")
    public ResultInfo findSceneByVenueId(Integer venueId){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<RoomAndSceneDTO> roomAndScene = sceneService.findRoomAndSceneByVenueId(companyId, venueId);
        return ResultInfoUtil.success(roomAndScene);
    }


    //批量编辑或新增
    @ApiOperation(value = "批量编辑或新增")
    @PostMapping("/bat_insert_or_update_scene")
    public ResultInfo batInsertOrUpdateScene(@RequestBody List<ScenePO> scenes){
        sceneService.batInsertOrUpdateScene(scenes);
        return ResultInfoUtil.success();
    }


    //批量新增
    @ApiOperation(value = "批量新增")
    @PostMapping("/bat_insert_scene")
    public ResultInfo batInsertScene(@RequestBody List<ScenePO> scenes){
        sceneService.batInsertScene(scenes);
        return ResultInfoUtil.success();
    }

    //批量编辑
    @ApiOperation(value = "批量编辑")
    @PostMapping("/bat_update_scene")
    public ResultInfo batUpdateScene(@RequestBody List<ScenePO> scenes){
        sceneService.batUpdateScene(scenes);
        return ResultInfoUtil.success();
    }



}
