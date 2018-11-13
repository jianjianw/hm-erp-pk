package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.OrderDao;
import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.vo.OrderVO;
import com.qiein.erp.pk.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单service
 * author:xiangliang
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    /**
     * 获取订单总页面
     * @param orderDTO
     * @return
     */
    public List<OrderVO> getOrder(OrderDTO orderDTO){
        return orderDao.selectOrder(orderDTO);
    }
}
