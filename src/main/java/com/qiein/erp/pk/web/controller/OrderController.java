package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.enums.TipMsgEnum;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.dto.OrderSelectDTO;
import com.qiein.erp.pk.web.entity.po.OrderEditPO;
import com.qiein.erp.pk.web.entity.po.ProcessPO;
import com.qiein.erp.pk.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单controller
 * author:xiangliang
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 获取订单总页面
     * @param orderDTO
     * @return
     */
    @PostMapping("/get_order")
    public ResultInfo getOrder(@RequestBody OrderDTO orderDTO){
        Integer companyId=1;
        orderDTO.setCompanyId(companyId);
        return ResultInfoUtil.success(orderService.getOrder(orderDTO));
    }
    /**
     * 根据档期id获取订单页面
     * @param orderDTO
     * @return
     */
    @PostMapping("/select_by_sch_id")
    public ResultInfo selectBySchId(@RequestBody OrderSelectDTO orderDTO){
        Integer companyId=1;
        orderDTO.setCompanyId(companyId);
        return ResultInfoUtil.success(orderService.selectBySchId(orderDTO));
    }
    /**
     * 新增订单
     */
//    @PostMapping("/insert_order")
//    public ResultInfo insertOrder(@RequestBody O)
    /**
     * 根据订单id获取流程
     */
    @GetMapping("/select_by_ord_id")
    public  ResultInfo selectByOrdId(Integer orderId){
        Integer companyId=1;
        return ResultInfoUtil.success(orderService.selectByOrdId(orderId,companyId));
    }

    /**
     * 编辑流程
     * @param processPO
     * @return
     */
    @PostMapping("/edit_process")
    public ResultInfo editProcess(@RequestBody ProcessPO processPO){
        Integer companyId=1;
        processPO.setCompanyId(companyId);
        orderService.editProcess(processPO);
        return ResultInfoUtil.success(TipMsgEnum.SAVE_SUCCESS);
    }
    /**
     * 编辑主信息
     */
    @PostMapping("/edit_order")
    public ResultInfo editOrder(@RequestBody OrderEditPO orderEditPO){
        Integer companyId=1;
        orderEditPO.setCompanyId(companyId);
        orderService.updateOrder(orderEditPO);
        return ResultInfoUtil.success(TipMsgEnum.SAVE_SUCCESS);
    }
}