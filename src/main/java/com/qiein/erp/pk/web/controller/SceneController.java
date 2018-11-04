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
 * */
@RestController
@RequestMapping("/scene")
public class SceneController {


    @Autowired
    private SceneService sceneService;

    @PostMapping("/deleteByPrimaryKey")
    public ResultInfo deleteByPrimaryKey(Integer id){
        int i = sceneService.deleteByPrimaryKey(id);
        return ResultInfoUtil.success();
    }
    @PostMapping("/insert")
    public ResultInfo insert(Scene scene){
        int insert = sceneService.insert(scene);
        return ResultInfoUtil.success();
    }
    @GetMapping("/selectByPrimaryKey")
    public ResultInfo selectByPrimaryKey(Integer id){
        Scene scene = sceneService.selectByPrimaryKey(id);
        return ResultInfoUtil.success(scene);
    }
    @GetMapping("/selectAll")
    public ResultInfo selectAll(){
        List<Scene> scenes = sceneService.selectAll();
        return ResultInfoUtil.success(scenes);
    }
    @PostMapping("/updateByPrimaryKey")
    public ResultInfo updateByPrimaryKey(Scene scene){
        int i = sceneService.updateByPrimaryKey(scene);
        return ResultInfoUtil.success();
    }
}
