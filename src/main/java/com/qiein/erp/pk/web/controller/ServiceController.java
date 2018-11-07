package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.enums.TipMsgEnum;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.ServiceDTO;
import com.qiein.erp.pk.web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 服务controller
 * author:xiangliang 2018/11/05
 */
@RestController
@RequestMapping("/service")
public class ServiceController extends BaseController{
    @Autowired
    private ServiceService serviceService;

    /**
     * 增加服务
     * @param serviceDTO
     * @return
     */
    @PostMapping("/add_service")
    public ResultInfo addService(@RequestBody ServiceDTO serviceDTO){
        serviceDTO.setCompanyId(1);
        serviceService.addService(serviceDTO);
        return ResultInfoUtil.success(TipMsgEnum.SAVE_SUCCESS);
    }
    /**
     * 修改服务
     */
    @PostMapping("/edit_service")
    public ResultInfo editService(@RequestBody ServiceDTO serviceDTO){
        serviceDTO.setCompanyId(1);
        serviceService.editService(serviceDTO);
        return ResultInfoUtil.success(TipMsgEnum.SAVE_SUCCESS);
    }

    /**
     * 查询服务
     */
    @GetMapping("/select")
    public ResultInfo select(){
        return ResultInfoUtil.success(serviceService.select(1));
    }

}
