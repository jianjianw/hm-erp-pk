package com.qiein.erp.pk.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiein.erp.pk.web.dao.StaffScheduleDao;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;
import com.qiein.erp.pk.web.service.StaffScheduleService;

@Service
public class StaffScheduleImpl implements StaffScheduleService {

    @Autowired
    private StaffScheduleDao staffScheduleDao;

	
    
    /**
     * 查询人员档期
     * @return
     */
    @Override
	public List<StaffScheduleVO> selectAll(Integer companyId, Integer firstTime, Integer endTime,Integer roleId) {
		List<StaffScheduleVO> staffScheduleVO=staffScheduleDao.selectAll(companyId,firstTime,endTime,roleId);
		return staffScheduleVO;
	}
	
}
