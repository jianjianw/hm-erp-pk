package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.exception.ExceptionEnum;
import com.qiein.erp.pk.util.ObjectUtil;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.BasePO;
import com.qiein.erp.pk.web.service.BaseService;
import org.apache.commons.lang3.StringUtils;
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
public class BaseController extends InitController{

    @Autowired
    private BaseService baseService;
    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer id){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        baseService.deleteByPrimaryKey(id,companyId);
        return  ResultInfoUtil.success();
    }
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody BasePO base){
        int companyId = getCurrentLoginStaff().getCompanyId();
        base.setCompanyId(companyId);
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(base);
        //名字查重
        String baseName = baseService.checkName(companyId, null, base.getBaseName());
        if(StringUtils.isNotBlank(baseName)){
            return ResultInfoUtil.error(ExceptionEnum.NAME_EXIST);
        }
        baseService.insert(base);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer id){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        BasePO base = baseService.selectByPrimaryKey(id,companyId);
        return ResultInfoUtil.success(base);
    }

    @GetMapping("/select_all")
    public ResultInfo selectAll(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<BasePO> bases = baseService.selectAll(companyId);
        return ResultInfoUtil.success(bases);
    }

    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody BasePO base){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        base.setCompanyId(companyId);
        //名字查重
        String baseName = baseService.checkName(companyId, base.getId(), base.getBaseName());
        if(StringUtils.isNotBlank(baseName)){
            return ResultInfoUtil.error(ExceptionEnum.NAME_EXIST);
        }
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(base);
        baseService.updateByPrimaryKey(base);
        return ResultInfoUtil.success();
    }

    @PostMapping("/bat_insert_or_update")
    public ResultInfo batInsertOrUpdate(@RequestBody List<BasePO> bases){
        baseService.batInsertOrUpdate(bases);
        return ResultInfoUtil.success();
    }

    //批量新增
    @PostMapping("/bat_insert")
    public ResultInfo batInsert(@RequestBody List<BasePO> bases){
        baseService.batInsert(bases);
        return ResultInfoUtil.success();
    }
    //批量编辑
    @PostMapping("/bat_update")
    public ResultInfo batUpdate(@RequestBody List<BasePO> bases){
        baseService.batUpdate(bases);
        return ResultInfoUtil.success();
    }

    //排序
    @PostMapping("/base_sort")
    public ResultInfo baseSort(@RequestBody List<BasePO> bases){
        baseService.baseSort(bases);
        return ResultInfoUtil.success();
    }


    /**
     * 查询所有开启的基地
     * @return
     */
    @GetMapping("/select_open_all")
    public ResultInfo selectOpenAll(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<BasePO> bases = baseService.selectOpenAll(companyId);
        return ResultInfoUtil.success(bases);
    }


}
