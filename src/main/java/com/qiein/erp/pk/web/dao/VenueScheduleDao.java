package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.VenueScheduleSetDTO;
import com.qiein.erp.pk.web.entity.po.VenueScheduleInsertPO;
import com.qiein.erp.pk.web.entity.vo.OrderVenueScheduleVO;
import com.qiein.erp.pk.web.entity.vo.VenueSchSelectVO;
import com.qiein.erp.pk.web.entity.vo.VenueScheduleSetVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 场馆档期dao
 * author:xiangliang 2018/11/05
 */
public interface VenueScheduleDao {
    /**
     * 获取每天的档期数
     * @param companyId
     * @return
     */
    List<OrderVenueScheduleVO> getVenueSchedule(@Param("companyId") Integer companyId,@Param("start")Integer start,@Param("end")Integer end);
//    List<OrderVenueScheduleVO> getCount();
    /**
     * 场馆档期设置页面
     */
    List<VenueScheduleSetVO> getVenueScheduleSet(@Param("companyId") Integer companyId);


    /**
     * 获取已存在场馆档期
     */
    List<VenueScheduleInsertPO> getVenueScheduleSetWasIn(VenueScheduleSetDTO venueScheduleSetDTO);
    /**
     * 插入存在档期
     */
    void insertSet(@Param("list")List<VenueScheduleInsertPO> list);

    /**
     * 场馆档期下拉框
     */
    List<VenueSchSelectVO> venueSchSelect(@Param("venueTime")Integer venueTime,@Param("companyId")Integer companyId);

    /**
     * 编辑单个档期
     * @param schId
     * @param target
     */
    void editVenueSch(@Param("schId")Integer schId,@Param("target")Integer target);


}
