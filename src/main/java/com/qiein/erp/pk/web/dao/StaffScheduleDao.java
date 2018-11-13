package com.qiein.erp.pk.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;
/**
 * 摄影师排空
 * @author Han
 *
 */
public interface StaffScheduleDao {

    /**
     * 查询所有套餐
     * @return
     */
	List<StaffScheduleVO> selectAll(@Param("companyId") Integer companyId,
			@Param("firstTime") Integer firstTime,@Param("endTime") Integer endTime,@Param("roleId") Integer roleId);
	/**
     * 查询场馆
     * @return
     */
	List<Venue> venueSelect(@Param("companyId") Integer companyId);
	
}