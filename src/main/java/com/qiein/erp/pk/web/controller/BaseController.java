package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.web.entity.po.Base;
import com.qiein.erp.pk.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 场地
 * */
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;
    @PostMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Integer id){
        int i = baseService.deleteByPrimaryKey(id);
        return i;
    }
    @PostMapping("/insert")
    public int insert(Base base){
        int insert = baseService.insert(base);
        return insert;
    }
    @GetMapping("/selectByPrimaryKey")
    public Base selectByPrimaryKey(Integer id){
        Base base = baseService.selectByPrimaryKey(id);
        return base;
    }

    @GetMapping("/selectAll")
    public List<Base> selectAll(){
        List<Base> bases = baseService.selectAll();
        return bases;
    }

    @PostMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Base base){
        int i = baseService.updateByPrimaryKey(base);
        return i;
    }
}
