package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.Base;
import com.qiein.erp.pk.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 场地
 * author:wang lei
 * date : 2018-11-04
 * */
@RestController
@RequestMapping("/base")
public class BaseController {

    Integer companyId = 1;
    @Autowired
    private BaseService baseService;
    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer id){
        int i = baseService.deleteByPrimaryKey(id,companyId);
        return  ResultInfoUtil.success();
    }
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Base base){
        int insert = baseService.insert(base);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer id){
        Base base = baseService.selectByPrimaryKey(id,companyId);
        return ResultInfoUtil.success(base);
    }

    @GetMapping("/select_all")
    public ResultInfo selectAll(){
        List<Base> bases = baseService.selectAll(companyId);
        return ResultInfoUtil.success(bases);
    }

    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Base base){
        int i = baseService.updateByPrimaryKey(base);
        return ResultInfoUtil.success();
    }




}
