package com.qiein.erp.pk.web.service.impl;

import java.util.List;

import com.qiein.erp.pk.web.entity.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiein.erp.pk.web.dao.PlanScheduleDao;
import com.qiein.erp.pk.web.entity.po.VenuePO;
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
	public List<VenuePO> venueSelect(int companyId, Integer roleId, String[] venueId, String[] roleLevel) {
		List<VenuePO> Venues=planScheduleDao.venueSelect(companyId,roleId,venueId,roleLevel);
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
	public List<VenuePO> venueSelectOnly(int companyId) {
		List<VenuePO> Venues= planScheduleDao.venueSelectOnly(companyId);
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
	public List<VenueStaffScheduleVO> staffAll(int companyId, Integer roleId, String venueId, Integer time) {
		List<VenueStaffScheduleVO> StaffScheduleVO=planScheduleDao.staffAll(companyId,roleId,venueId,time);
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
	/**
     * 查询当月主界面休息摄影师
     * @return
     */
	@Override
	public List<StaffScheduleVO> selectMonthRest(Integer companyId, int firstDay, int lastDay, Integer roleId,
			String[] venueId) {
		List<StaffScheduleVO> StaffScheduleRests=planScheduleDao.selectMonthRest(companyId,firstDay,lastDay,roleId, venueId);
		return StaffScheduleRests;
	}
	/**
     * 查询摄影师返回id
     * @return
     */
	@Override
	public StaffScheduleVO selectByVenueIdAndStaffId(Integer staffId, Integer venueId, Integer time,
			Integer companyId) {
		StaffScheduleVO staffScheduleVO=planScheduleDao.selectByVenueIdAndStaffId(staffId,venueId,time,companyId);
		return staffScheduleVO;
	}
	/**
     * 插入摄影师返回id
     * @return
     */
	@Override
	public void insertStaffSchedule(StaffScheduleVO staffScheduleVOt) {
		planScheduleDao.insertStaffSchedule(staffScheduleVOt);
	}
	/**
     * 更新人员状态
     * @return
     */
	@Override
	public void updateStaffStatus(StaffScheduleVO staffSchedule) {
		planScheduleDao.updateStaffStatus(staffSchedule);
	}
	/**
	 * 人员下拉框
	 */
	public List<StaffSelectForOrderVO> staffSelect(Integer companyId, Integer roleId,
												   Integer time){
		List<StaffSelectForOrderVO> staffSelectForOrderVOS=planScheduleDao.staffSelect(companyId,roleId,time);
		for(StaffSelectForOrderVO staffSelectForOrderVO:staffSelectForOrderVOS){
			for(StaffSelectForOrderInVO staffSelectForOrderInVO:staffSelectForOrderVO.getStaffSelectForOrderInVOS()){
				if(staffSelectForOrderInVO.getCount()!=0&&staffSelectForOrderInVO.getStatus()==1){
					staffSelectForOrderInVO.setStatus(0);
				}
				if(staffSelectForOrderInVO.getStatus()==null){
					staffSelectForOrderInVO.setStatus(1);
				}
			}
		}
		return staffSelectForOrderVOS;
	}
	
}
