package com.qiein.erp.pk.web.service;

import java.util.List;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;


public interface StaffScheduleService {
	
	/**
     * 查询人员档期
     * @return
     */
	List<StaffScheduleVO> selectAll(Integer companyId, Integer firstTime, Integer endTime,Integer roleId,
			String[] venueId,String[] roleLevel);
	/**
     * 查询场馆
     * @return
     */
	List<Venue> venueSelect(int companyId,Integer roleId,String[] venueId,String[] roleLevel);
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

	

    
}
