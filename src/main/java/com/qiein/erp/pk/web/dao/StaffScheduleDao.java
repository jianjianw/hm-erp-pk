package com.qiein.erp.pk.web.dao;

import java.util.List;

import com.qiein.erp.pk.web.entity.vo.StaffSelectForOrderVO;
import org.apache.ibatis.annotations.Param;

import com.qiein.erp.pk.web.entity.po.VenuePO;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;
import com.qiein.erp.pk.web.entity.vo.VenueStaffScheduleVO;
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
	List<VenuePO> venueSelect(@Param("companyId") Integer companyId, @Param("roleId") Integer roleId,
                              @Param("venueId") String[] venueId, @Param("roleLevel") String[] roleLevel);
	/**
     * 查询角色等级
     * @return
     */
	List<StaffRoleTypeVO> roleLevelSelect(int companyId);
	/**
     * 仅查询场馆
     * @return
     */
	List<VenuePO> venueSelectOnly(int companyId);
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
	/**
     * 查询全部摄影师
     * @return
     */
	List<VenueStaffScheduleVO> staffAll(@Param("companyId")Integer companyId, @Param("roleId")Integer roleId, 
			@Param("venueId")String venueId,@Param("time")Integer time);
	/**
     * 查询已排班摄影师
     * @return
     */
	List<StaffScheduleVO> staffPK(@Param("companyId")Integer companyId, @Param("roleId")Integer roleId, 
			@Param("venueId")String venueId,@Param("time")Integer time);
	/**
     * 查询休息摄影师
     * @return
     */
	List<StaffScheduleVO> staffRest(@Param("companyId")Integer companyId, @Param("roleId")Integer roleId, 
			@Param("venueId")String venueId,@Param("time")Integer time);
	/**
     * 查询当月摄影师休息
     * @return
     */
	List<StaffScheduleVO> selectMonthRest(@Param("companyId") Integer companyId,
			@Param("firstTime") Integer firstTime,@Param("endTime") Integer endTime,@Param("roleId") Integer roleId,
			@Param("venueId") String[] venueId);
	/**
     *新增人员档期
     * @return
     */
	int insertStaffSchedule(StaffScheduleVO staffScheduleVO);
	/**
     *查询人员档期
     * @return
     */
	StaffScheduleVO selectByVenueIdAndStaffId(@Param("staffId")Integer staffId, @Param("venueId")Integer venueId, 
			@Param("time")Integer time,@Param("companyId")Integer companyId);
	/**
     *更新人员状态
     * @return
     */
	void updateStaffStatus(StaffScheduleVO staffSchedule);
	/**
	 * 人员下拉框
	 */
	List<StaffSelectForOrderVO> staffSelect(@Param("companyId")Integer companyId, @Param("roleId")Integer roleId,
											@Param("time")Integer time,@Param("staff")String staff);
	
}