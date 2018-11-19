package com.qiein.erp.pk.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.util.StringUtil;
import com.qiein.erp.pk.web.dao.OrderDao;
import com.qiein.erp.pk.web.entity.dto.OrderDTO;
import com.qiein.erp.pk.web.entity.dto.OrderSelectDTO;
import com.qiein.erp.pk.web.entity.po.OrderEditPO;
import com.qiein.erp.pk.web.entity.po.OrderPO;
import com.qiein.erp.pk.web.entity.po.ProcessPO;
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
     *
     * @param orderDTO
     * @return
     */
    public PageInfo<OrderVO> getOrder(OrderDTO orderDTO) {
        PageHelper.startPage(orderDTO.getPageNum(),orderDTO.getPageSize());
        return new PageInfo<>(orderDao.selectOrder(orderDTO));
    }

    /**
     * 根据档期id获取订单页面
     *
     * @param orderDTO
     * @return
     */
    public List<OrderVO> selectBySchId(OrderSelectDTO orderDTO) {
        return orderDao.selectBySchId(orderDTO);
    }

    /**
     * 新增订单(正常订单)
     *
     * @param orderPO
     */
    public void insertOrder(OrderPO orderPO) {
        if (orderPO.getOrderId() == null) {
            //新增订单
            orderDao.insertOrder(orderPO);
            //编辑订单编号
            orderDao.insertOrderNum(StringUtil.to26Jinzhi(orderPO.getOrderId()), orderPO.getOrderId());
        }
        orderDao.insertPro(orderPO);
        //给流程添加档期（除了拍摄间）
        orderDao.insertShootSch(orderPO);
        //给流程添加拍摄间档期
        List<String> list = new ArrayList<>();
        if (StringUtil.isNotEmpty(orderPO.getShootRoomSchIds())) {
            for (String shootRoomId : orderPO.getShootRoomSchIds().split(CommonConstant.STR_SEPARATOR)) {
                list.add(shootRoomId);
            }
            orderDao.insertSceneSch(orderPO.getProId(), list, orderPO.getCompanyId());
        }

    }

    /**
     * 根据订单id 获取流程
     *
     * @param orderId
     * @param companyId
     * @return
     */
    public OrderProVO selectByOrdId(Integer orderId, Integer companyId) {
        return orderDao.selectByOrdId(orderId, companyId);
    }
    /**
     * 手机端获取数据
     */
    public List<OrderProVO> selectForPhone(OrderSelectDTO orderDTO){
        return orderDao.selectForPhone(orderDTO);
    }
    /**
     * 编辑流程
     */
    public void editProcess(ProcessPO processPO) {
        if(processPO.getProId()==null){
            OrderPO orderPO=new OrderPO();
            orderPO.setOrderId(processPO.getOrderId());
            orderPO.setOrderType(processPO.getOrderType());
            orderPO.setCompanyId(processPO.getCompanyId());
            orderDao.insertPro(orderPO);
            processPO.setProId(orderPO.getProId());
            orderDao.insertShootSch(orderPO);

        }
        //编辑流程档期档期（除了拍摄间）
        orderDao.updateProcessShootSch(processPO);
        //删除流程关于拍摄间的档期 用于编辑
        orderDao.deleteSceneSch(processPO.getProId(), processPO.getCompanyId());
        //给流程添加拍摄间档期
        List<String> list = new ArrayList<>();
        if (StringUtil.isNotEmpty(processPO.getShootRoomSchId())) {
            for (String shootRoomId : processPO.getShootRoomSchId().split(CommonConstant.STR_SEPARATOR)) {
                list.add(shootRoomId);
            }
            orderDao.insertSceneSch(processPO.getProId(), list, processPO.getCompanyId());
        }
    }

    /**
     * 修改订单
     */
    public void updateOrder(OrderEditPO orderEditPO) {
        orderDao.updateOrder(orderEditPO);
    }
    /**
     * 修改备注
     * @param memo
     * @param orderId
     * @param companyId
     */
    public void editMemo(String memo,Integer orderId,Integer companyId){
        orderDao.editMemo(memo,orderId,companyId);
    }
    /**
     * 根据员工搜索
     */
    public List<OrderProVO> selectOrderByStaff(Integer companyId,Integer staffId,Integer start,Integer end,String type){
        return orderDao.selectOrderByStaff(companyId,staffId,start,end,type);
    }
}
