package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultInfo insert(Scene scene){
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
    public ResultInfo updateByPrimaryKey(Scene scene){
        int i = sceneService.updateByPrimaryKey(scene);
        return ResultInfoUtil.success();
    }
}
