package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.service.SceneService;
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
public class SceneController {

    Integer companyId = 1;

    @Autowired
    private SceneService sceneService;

    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer id){
        int i = sceneService.deleteByPrimaryKey(id,companyId);
        return ResultInfoUtil.success();
    }
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Scene scene){
        int insert = sceneService.insert(scene);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer id){
        Scene scene = sceneService.selectByPrimaryKey(id,companyId);
        return ResultInfoUtil.success(scene);
    }
    @GetMapping("/select_all")
    public ResultInfo selectAll(){
        List<Scene> scenes = sceneService.selectAll(companyId);
        return ResultInfoUtil.success(scenes);
    }
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Scene scene){
        int i = sceneService.updateByPrimaryKey(scene);
        return ResultInfoUtil.success();
    }

    //查询拍摄间下面的拍摄景
    @GetMapping("/find_scene_by_room_id")
    public ResultInfo findSceneByRoomId(Integer roomId){
        List<Scene> list  = sceneService.findSceneByRoomId(companyId,roomId);
        return ResultInfoUtil.success(list);

    }

    //场景排序，修改优先级
    @PostMapping("/scene_sort")
    public ResultInfo sceneSort(@RequestBody List<Scene> scenes){
        sceneService.sceneSort(scenes);
        return ResultInfoUtil.success();
    }

    //查询场馆下面的所有拍摄景
    @GetMapping("/find_scene_by_venue_id")
    public ResultInfo findSceneByVenueId(@RequestBody Integer venueId){
        List<RoomAndSceneDTO> roomAndScene = sceneService.findRoomAndSceneByVenueId(companyId, venueId);
        return ResultInfoUtil.success(roomAndScene);
    }

    //批量编辑
    @PostMapping("/bat_insert_or_update_scene")
    public ResultInfo batInsertOrUpdateScene(@RequestBody List<Scene> scenes){
        sceneService.batInsertOrUpdateScene(scenes);
        return ResultInfoUtil.success();
    }



}
