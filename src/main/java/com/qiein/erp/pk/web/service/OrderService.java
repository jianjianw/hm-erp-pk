package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.vo.OrderVO;

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
    List<OrderVO> getOrder(OrderDTO orderDTO);
}
