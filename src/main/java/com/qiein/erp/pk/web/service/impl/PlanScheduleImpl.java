package com.qiein.erp.pk.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiein.erp.pk.web.dao.PlanScheduleDao;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;
import com.qiein.erp.pk.web.service.PlanScheduleService;

@Service
public class PlanScheduleImpl implements PlanScheduleService {

    @Autowired
    private PlanScheduleDao planScheduleDao;
    
    /**
     * 查询人员档期
     * @return
     */
    @Override
	public List<StaffScheduleVO> selectAll(Integer companyId, Integer firstTime, Integer endTime,
			Integer roleId,String[] venueId,String[] roleLevel) {
		List<StaffScheduleVO> staffScheduleVO=planScheduleDao.selectAll(companyId,firstTime,endTime,roleId,venueId,roleLevel);
		return staffScheduleVO;
	}
    /**
     * 查询场馆
     * @return
     */
	@Override
	public List<Venue> venueSelect(int companyId,Integer roleId,String[] venueId,String[] roleLevel) {
		List<Venue> Venues=planScheduleDao.venueSelect(companyId,roleId,venueId,roleLevel);
		return Venues;
	}
	/**
     * 查询角色等级
     * @return
     */
	@Override
	public List<StaffRoleTypeVO> roleLevelSelect(int companyId) {
		List<StaffRoleTypeVO> StaffRoleTypeVOs= planScheduleDao.roleLevelSelect(companyId);
		return StaffRoleTypeVOs;
	}
	/**
     * 仅查询场馆
     * @return
     */
	@Override
	public List<Venue> venueSelectOnly(int companyId) {
		List<Venue> Venues= planScheduleDao.venueSelectOnly(companyId);
		return Venues;
	}
	/**
     * 查询人员休息
     * @return
     */
	@Override
	public StaffScheduleVO selectRest(StaffScheduleVO staffRoleTypeVO) {
		
		return planScheduleDao.selectRest(staffRoleTypeVO);
	}
	/**
     * 新增人员休息
     * @return
     */
	@Override
	public void insertRest(StaffScheduleVO staffScheduleVO) {
		planScheduleDao.insertRest(staffScheduleVO);
		
	}
	/**
     * 查询全部摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> staffAll(int companyId, Integer roleId, String venueId, Integer time) {
		List<StaffScheduleVO> StaffScheduleVO=planScheduleDao.staffAll(companyId,roleId,venueId,time);
		return StaffScheduleVO;
	}
	/**
     * 查询已排班摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> staffPK(int companyId, Integer roleId, String venueId, Integer time) {
		List<StaffScheduleVO> StaffSchedulePK=planScheduleDao.staffPK(companyId,roleId,venueId,time);
		return StaffSchedulePK;
	}
	/**
     * 查询休息摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> staffRest(int companyId, Integer roleId, String venueId, Integer time) {
		List<StaffScheduleVO> StaffScheduleRests=planScheduleDao.staffRest(companyId,roleId,venueId,time);
		return StaffScheduleRests;
	}
	
}