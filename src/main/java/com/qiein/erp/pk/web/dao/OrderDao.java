package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.dto.OrderSelectDTO;
import com.qiein.erp.pk.web.entity.po.OrderPO;
import com.qiein.erp.pk.web.entity.vo.OrderProVO;
import com.qiein.erp.pk.web.entity.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

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
    /**
     * 根据档期id获取订单页面
     * @param orderDTO
     * @return
     */
    List<OrderVO> selectBySchId(OrderSelectDTO orderDTO);

    /**
     * 新增订单
     * @param orderPO
     */
    void insertOrder(OrderPO orderPO);
    /**
     * 编辑订单编号
     */
    void insertOrderNum(@Param("orderNum")String orderNum, @Param("id")Integer id);
    /**
     * 新增流程
     */
    void insertPro(OrderPO orderPO);
    /**
     * 给流程添加档期（除拍摄间外）
     */
    void insertShootSch(OrderPO orderPO);
    /**
     * 给流程添加档期（拍摄间）
     */
    void insertSceneSch(@Param("proId") Integer proId,@Param("list") List<String> list,@Param("companyId") Integer companyId);

    /**
     * 根据订单id 获取流程
     * @param orderId
     * @param companyId
     * @return
     */
    OrderProVO selectByOrdId(@Param("orderId")Integer orderId,@Param("companyId") Integer companyId);
}
