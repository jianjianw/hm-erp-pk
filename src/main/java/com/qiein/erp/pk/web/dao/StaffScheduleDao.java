package com.qiein.erp.pk.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
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
			@Param("firstTime") Integer firstTime,@Param("endTime") Integer endTime,@Param("roleId") Integer roleId,
			@Param("venueId") String[] venueId,@Param("roleLevel") String[] roleLevel);
	/**
     * 查询场馆
     * @return
     */
	List<Venue> venueSelect(@Param("companyId") Integer companyId,@Param("roleId") Integer roleId,
			@Param("venueId") String[] venueId,@Param("roleLevel") String[] roleLevel);  
	/**
     * 查询角色等级
     * @return
     */
	List<StaffRoleTypeVO> roleLevelSelect(int companyId);
	/**
     * 仅查询场馆
     * @return
     */
	List<Venue> venueSelectOnly(int companyId);
	/**
     * 查询人员休息
     * @return
     */
	StaffScheduleVO selectRest(StaffScheduleVO staffScheduleVO);
	/**
     * 新增人员休息
     * @return
     */
	void insertRest(StaffScheduleVO staffScheduleVO);
	
}