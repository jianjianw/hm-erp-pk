package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
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
    public ResultInfo deleteByPrimaryKey(Integer id){
        int i = baseService.deleteByPrimaryKey(id);
        return  ResultInfoUtil.success();
    }
    @PostMapping("/insert")
    public ResultInfo insert(Base base){
        int insert = baseService.insert(base);
        return ResultInfoUtil.success();
    }
    @GetMapping("/selectByPrimaryKey")
    public ResultInfo selectByPrimaryKey(Integer id){
        Base base = baseService.selectByPrimaryKey(id);
        return ResultInfoUtil.success(base);
    }

    @GetMapping("/selectAll")
    public ResultInfo selectAll(){
        List<Base> bases = baseService.selectAll();
        return ResultInfoUtil.success(bases);
    }

    @PostMapping("/updateByPrimaryKey")
    public ResultInfo updateByPrimaryKey(Base base){
        int i = baseService.updateByPrimaryKey(base);
        return ResultInfoUtil.success();
    }
}
