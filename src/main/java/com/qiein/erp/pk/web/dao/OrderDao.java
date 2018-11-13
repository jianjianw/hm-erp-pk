package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.vo.OrderVO;

import java.util.List;

/**
 * 订单dao
 * author:xiangliang
 */
public interface OrderDao {
    /**
     * 获取订单总页面
     * @param orderDTO
     * @return
     */
    List<OrderVO> selectOrder(OrderDTO orderDTO);
}
