package com.qiein.erp.pk.web.service;

import java.util.List;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;


public interface StaffScheduleService {
	
	/**
     * 查询人员档期
     * @return
     */
	List<StaffScheduleVO> selectAll(Integer companyId, Integer firstTime, Integer endTime,Integer roleId);
	/**
     * 查询场馆
     * @return
     */
	List<Venue> venueSelect(int companyId);

	

    
}
