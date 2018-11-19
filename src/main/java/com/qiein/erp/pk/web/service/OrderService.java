package com.qiein.erp.pk.web.service;

import com.github.pagehelper.PageInfo;
import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.dto.OrderSelectDTO;
import com.qiein.erp.pk.web.entity.po.OrderEditPO;
import com.qiein.erp.pk.web.entity.po.OrderPO;
import com.qiein.erp.pk.web.entity.po.ProcessPO;
import com.qiein.erp.pk.web.entity.vo.OrderProVO;
import com.qiein.erp.pk.web.entity.vo.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单service
 * author:xiangliang
 */
public interface OrderService {
    /**
     * 获取订单总页面
     * @param orderDTO
     * @return
     */
    PageInfo<OrderVO> getOrder(OrderDTO orderDTO);
    /**
     * 根据档期id获取订单页面
     * @param orderDTO
     * @return
     */
    List<OrderVO> selectBySchId(OrderSelectDTO orderDTO);
    /**
     * 新增订单(正常订单)
     * @param orderPO
     */
     void insertOrder(OrderPO orderPO);
    /**
     * 根据订单id 获取流程
     * @param orderId
     * @param companyId
     * @return
     */
    OrderProVO selectByOrdId(Integer orderId, Integer companyId);
    /**
     * 手机端获取数据
     */
    List<OrderProVO> selectForPhone(OrderSelectDTO orderDTO);
    /**
     * 编辑流程
     */
    void editProcess(ProcessPO processPO);
    /**
     * 修改订单
     */
    void updateOrder(OrderEditPO orderEditPO);

    /**
     * 修改备注
     * @param memo
     * @param orderId
     * @param companyId
     */
    void editMemo(String memo,Integer orderId,Integer companyId);
    /**
     * 根据员工搜索
     */
    List<OrderProVO> selectOrderByStaff(Integer companyId,Integer staffId,Integer start,Integer end,String type);
}
