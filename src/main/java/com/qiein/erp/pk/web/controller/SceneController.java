package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scene")
public class SceneController {


    @Autowired
    private SceneService sceneService;

    @PostMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Integer id){
        int i = sceneService.deleteByPrimaryKey(id);
        return i;
    }
    @PostMapping("/insert")
    public int insert(Scene scene){
        int insert = sceneService.insert(scene);
        return insert;
    }
    @GetMapping("/selectByPrimaryKey")
    public Scene selectByPrimaryKey(Integer id){
        Scene scene = sceneService.selectByPrimaryKey(id);
        return scene;
    }
    @GetMapping("/selectAll")
    public List<Scene> selectAll(){
        List<Scene> scenes = sceneService.selectAll();
        return scenes;
    }
    @PostMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Scene scene){
        int i = sceneService.updateByPrimaryKey(scene);
        return i;
    }
}
