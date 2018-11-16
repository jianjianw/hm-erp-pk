package com.qiein.erp.pk.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiein.erp.pk.web.dao.StaffScheduleDao;
import com.qiein.erp.pk.web.entity.po.VenuePO;
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
	public List<VenuePO> venueSelect(int companyId, Integer roleId, String[] venueId, String[] roleLevel) {
		List<VenuePO> Venues=staffScheduleDao.venueSelect(companyId,roleId,venueId,roleLevel);
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
	public List<VenuePO> venueSelectOnly(int companyId) {
		List<VenuePO> Venues= staffScheduleDao.venueSelectOnly(companyId);
		return Venues;
	}
	/**
     * 查询人员休息
     * @return
     */
	@Override
	public StaffScheduleVO selectRest(StaffScheduleVO staffRoleTypeVO) {
		
		return staffScheduleDao.selectRest(staffRoleTypeVO);
	}
	/**
     * 新增人员休息
     * @return
     */
	@Override
	public void insertRest(StaffScheduleVO staffScheduleVO) {
		staffScheduleDao.insertRest(staffScheduleVO);
		
	}
	/**
     * 查询全部摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> staffAll(int companyId, Integer roleId, String venueId, Integer time) {
		List<StaffScheduleVO> StaffScheduleVO=staffScheduleDao.staffAll(companyId,roleId,venueId,time);
		return StaffScheduleVO;
	}
	/**
     * 查询已排班摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> staffPK(int companyId, Integer roleId, String venueId, Integer time) {
		List<StaffScheduleVO> StaffSchedulePK=staffScheduleDao.staffPK(companyId,roleId,venueId,time);
		return StaffSchedulePK;
	}
	/**
     * 查询休息摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> staffRest(int companyId, Integer roleId, String venueId, Integer time) {
		List<StaffScheduleVO> StaffScheduleRests=staffScheduleDao.staffRest(companyId,roleId,venueId,time);
		return StaffScheduleRests;
	}
	/**
     * 查询当月休息摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> selectMonthRest(Integer companyId, int firstDay, int lastDay, Integer roleId,  
			String[] venueId) {
		List<StaffScheduleVO> StaffScheduleRests=staffScheduleDao.selectMonthRest(companyId,firstDay,lastDay,roleId, venueId);
		return StaffScheduleRests;
	}
	/**
     * 新增人员档期
     * @return
     */
	@Override
	public int insertStaffSchedule(StaffScheduleVO staffScheduleVO) {
		
		return staffScheduleDao.insertStaffSchedule(staffScheduleVO);
	}
	/**
     * 查询人员档期
     * @return
     */
	@Override
	public StaffScheduleVO selectByVenueIdAndStaffId(Integer staffId, Integer venueId, 
			Integer time,Integer companyId) {
		StaffScheduleVO staffScheduleVO=staffScheduleDao.selectByVenueIdAndStaffId(staffId,venueId,time,companyId);
		return staffScheduleVO;
	}
	
}
