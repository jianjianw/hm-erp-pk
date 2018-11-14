package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.util.StringUtil;
import com.qiein.erp.pk.web.dao.OrderDao;
import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.dto.OrderSelectDTO;
import com.qiein.erp.pk.web.entity.po.OrderPO;
import com.qiein.erp.pk.web.entity.vo.OrderProVO;
import com.qiein.erp.pk.web.entity.vo.OrderVO;
import com.qiein.erp.pk.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    /**
     * 根据档期id获取订单页面
     * @param orderDTO
     * @return
     */
    public List<OrderVO> selectBySchId(OrderSelectDTO orderDTO){
        return orderDao.selectBySchId(orderDTO);
    }

    /**
     * 新增订单(正常订单)
     * @param orderPO
     */
    public void insertOrder(OrderPO orderPO){
        //新增订单
        orderDao.insertOrder(orderPO);
        //编辑订单编号
        orderDao.insertOrderNum(StringUtil.to26Jinzhi(orderPO.getOrderId()),orderPO.getOrderId());
        //给流程添加档期（除了拍摄间）
        orderDao.insertShootSch(orderPO);
        //给流程添加拍摄间档期
        List<String> list=new ArrayList<>();
        for(String shootRoomId:orderPO.getShootRoomSchIds().split(CommonConstant.STR_SEPARATOR)){
            list.add(shootRoomId);
        }
        orderDao.insertSceneSch(orderPO.getProId(),list,orderPO.getCompanyId());
    }
    /**
     * 根据订单id 获取流程
     * @param orderId
     * @param companyId
     * @return
     */
    public OrderProVO selectByOrdId(Integer orderId, Integer companyId){
        return orderDao.selectByOrdId(orderId,companyId);
    }
}
