package com.qiein.erp.pk.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiein.erp.pk.web.dao.StaffScheduleDao;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
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
	public List<StaffScheduleVO> selectAll(Integer companyId, Integer firstTime, Integer endTime,
			Integer roleId,String[] venueId,String[] roleLevel) {
		List<StaffScheduleVO> staffScheduleVO=staffScheduleDao.selectAll(companyId,firstTime,endTime,roleId,venueId,roleLevel);
		return staffScheduleVO;
	}
    /**
     * 查询场馆
     * @return
     */
	@Override
	public List<Venue> venueSelect(int companyId,Integer roleId,String[] venueId,String[] roleLevel) {
		List<Venue> Venues=staffScheduleDao.venueSelect(companyId,roleId,venueId,roleLevel);
		return Venues;
	}
	/**
     * 查询角色等级
     * @return
     */
	@Override
	public List<StaffRoleTypeVO> roleLevelSelect(int companyId) {
		List<StaffRoleTypeVO> StaffRoleTypeVOs= staffScheduleDao.roleLevelSelect(companyId);
		return StaffRoleTypeVOs;
	}
	/**
     * 仅查询场馆
     * @return
     */
	@Override
	public List<Venue> venueSelectOnly(int companyId) {
		List<Venue> Venues= staffScheduleDao.venueSelectOnly(companyId);
		return Venues;
	}
	
}
