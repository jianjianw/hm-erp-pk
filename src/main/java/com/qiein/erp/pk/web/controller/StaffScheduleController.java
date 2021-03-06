package com.qiein.erp.pk.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.util.StringUtil;
import com.qiein.erp.pk.util.TimeUtil;
import com.qiein.erp.pk.web.entity.po.VenuePO;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;
import com.qiein.erp.pk.web.entity.vo.TempStaffVO;
import com.qiein.erp.pk.web.service.StaffScheduleService;

import retrofit2.http.POST;

/**
 * 摄影师人员排空
 * author：HJF 2018/11/10
 */
@RestController
@RequestMapping("/StaffSchedule")
public class StaffScheduleController extends InitController {

    @Autowired
    private StaffScheduleService staffScheduleService;
    /**
     * 更新人员状态
     * @return
     */
    @PostMapping("/update_staff_status")
    public ResultInfo updateStaffStatus(@RequestBody StaffScheduleVO staffSchedule){
		Integer companyId=getCurrentLoginStaff().getCompanyId();
		//放入公司id
		staffSchedule.setCompanyId(companyId);
		staffScheduleService.updateStaffStatus(staffSchedule);
        return ResultInfoUtil.success("成功");
    }
    
//    /**
//     * 查询摄影师档期--订单界面下拉框
//     * @return
//     */
//    @GetMapping("/select_box")
//    public ResultInfo selectBox(@RequestParam(value="roleId") Integer roleId,@RequestParam("venueId")String venueId,
//    		@RequestParam("time")Integer time){
//    	//校验参数
//    	if(StringUtil.isEmpty(venueId)){
//    		return ResultInfoUtil.error(9999,"缺少场馆id");
//    	}
//		Integer companyId=getCurrentLoginStaff().getCompanyId();
//    	 //获取全部摄影师
//         List<StaffScheduleVO> StaffScheduleVOAlls= staffScheduleService.staffAll(companyId,roleId,venueId,time);
//         //获取已排班摄影师
//         List<StaffScheduleVO> StaffScheduleVOPKs= staffScheduleService.staffPK(companyId,roleId,venueId,time);
//         if(StaffScheduleVOAlls !=null && StaffScheduleVOPKs!=null){
//        	 for (StaffScheduleVO StaffScheduleVOAll : StaffScheduleVOAlls) {
//            	 for (StaffScheduleVO StaffScheduleVOPK : StaffScheduleVOPKs) {
//         			if(StaffScheduleVOAll.getVenueId().equals(StaffScheduleVOPK.getVenueId()) &&
//						StaffScheduleVOAll.getStaffId().equals(StaffScheduleVOPK.getStaffId())){
//         				StaffScheduleVOAll.setId(StaffScheduleVOPK.getId());
//         				StaffScheduleVOAll.setStatus(1);
//         				StaffScheduleVOAll.setCount(StaffScheduleVOPK.getCount());
//         			}
//         		}
//    		}
//         }
//
//        //获取休息摄影师
//        List<StaffScheduleVO> StaffScheduleVORests= staffScheduleService.staffRest(companyId,roleId,venueId,time);
//        if(StaffScheduleVORests!=null && StaffScheduleVOAlls !=null){
//        	for (StaffScheduleVO StaffScheduleVOAll : StaffScheduleVOAlls) {
//        		for (StaffScheduleVO StaffScheduleVORest : StaffScheduleVORests) {
//					if(StaffScheduleVOAll.getVenueId().equals(StaffScheduleVORest.getVenueId())&&
//							StaffScheduleVOAll.getStaffId().equals(StaffScheduleVORest.getStaffId())){
//						StaffScheduleVOAll.setId(StaffScheduleVORest.getId());
//						StaffScheduleVOAll.setStatus(StaffScheduleVORest.getStaffStatus());
//					}
//				}
//        	}
//        }
//        return ResultInfoUtil.success(StaffScheduleVOAlls);
//    }
	/**
	 * 查询摄影师档期--订单界面下拉框
	 * @return
	 */
	@GetMapping("/select_box")
	public ResultInfo selectBox(@RequestParam(value="roleId") Integer roleId,@RequestParam("venueId")String venueId,
								@RequestParam("time")Integer time){
		return ResultInfoUtil.success(staffScheduleService.staffSelect(getCurrentLoginStaff().getCompanyId(),roleId,time));
	}
    /**
     * 新增人员档期，返回id和员工
     * @return
     */
    @GetMapping("/insert_staff_schedule")
    public ResultInfo insertStaffSchedule(@RequestParam(value = "staffId") Integer staffId,
                                          @RequestParam(value = "venueId") Integer venueId, @RequestParam(value = "time") Integer time) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        StaffScheduleVO staffScheduleVO = staffScheduleService.selectByVenueIdAndStaffId(staffId, venueId, time, companyId);
        if (staffScheduleVO != null) {
            return ResultInfoUtil.success(staffScheduleVO);
        }
        //新增这条记录
        StaffScheduleVO staffScheduleVOt = new StaffScheduleVO(venueId, 1, 1, staffId, time, companyId);
        staffScheduleService.insertStaffSchedule(staffScheduleVOt);
        //int scheduleId=staffScheduleVOt.getId();
        return ResultInfoUtil.success(staffScheduleVOt);
    }

    /**
     * 查询场馆
     *
     * @return
     */
    @GetMapping("/venue_select")
    public ResultInfo venueSelect(@RequestParam(value = "roleId") Integer roleId,
                                  @RequestParam(value = "venueId", required = false) String[] venueId, @RequestParam(value = "roleLevel", required = false) String[] roleLevel) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        List<VenuePO> Venues = staffScheduleService.venueSelect(companyId, roleId, venueId, roleLevel);
        return ResultInfoUtil.success(Venues);
    }
    /**
     * 仅查询场馆
     * @return
     */
    @GetMapping("/venue_select_only")
    public ResultInfo venueSelectOnly() {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        List<VenuePO> Venues = staffScheduleService.venueSelectOnly(companyId);
        return ResultInfoUtil.success(Venues);
    }
    /**
     * 查询角色等级
     * @return
     */
    @GetMapping("/role_level_select")
    public ResultInfo roleLevelSelect() {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        List<StaffRoleTypeVO> StaffRoleTypeVOs = staffScheduleService.roleLevelSelect(companyId);
        return ResultInfoUtil.success(StaffRoleTypeVOs);
    }
    /**
     * 人员休息
     * @return
     */
    @PostMapping("/set_rest")
    public ResultInfo setRest(@RequestBody StaffScheduleVO staffScheduleVO) {
        System.out.println(JSONObject.toJSONString(staffScheduleVO));
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        staffScheduleVO.setCompanyId(companyId);
        staffScheduleVO.setStaffDayLimit(1);
        StaffScheduleVO staffScheduleVOtemp = staffScheduleService.selectRest(staffScheduleVO);
        if (staffScheduleVOtemp == null) {
            staffScheduleService.insertRest(staffScheduleVO);
            return ResultInfoUtil.success("设置成功");
        }
        //更新状态
        if (staffScheduleVOtemp != null) {
            staffScheduleVO.setId(staffScheduleVOtemp.getId());
            staffScheduleService.updateStaffStatus(staffScheduleVO);
            return ResultInfoUtil.success("状态已更新");
        }

        return ResultInfoUtil.success(staffScheduleVOtemp);
    }
    /**
     * 查询人员档期
     */
    @GetMapping("/select_all")
    public ResultInfo selectAll(@RequestParam("roleId") Integer roleId, @RequestParam("month") String month,
                                @RequestParam(value = "venueId", required = false) String[] venueId, @RequestParam(value = "roleLevel", required = false) String[] roleLevel) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        //获取时间时间戳
        int firstDay = TimeUtil.getMonthStartTimeStampByDate(month);
        int lastDay = TimeUtil.getMonthEndTimeStampByDate(month);
        List<StaffScheduleVO> staffScheduleVOs = staffScheduleService.selectAll(companyId, firstDay, lastDay, roleId, venueId, roleLevel);
        // 最终用返回
        List<Map<String, Object>> newmaps = new ArrayList<>();
        TempStaffVO tempStaff = null;
        for (StaffScheduleVO staffScheduleVO : staffScheduleVOs) {
            tempStaff = new TempStaffVO();
            tempStaff.setCount(staffScheduleVO.getCount());
            tempStaff.setMealName(staffScheduleVO.getMealName());
            tempStaff.setStaffStatus(staffScheduleVO.getStaffStatus());
            tempStaff.setId(staffScheduleVO.getId());
            tempStaff.setServieceId(staffScheduleVO.getServieceId());
            tempStaff.setServiceName(staffScheduleVO.getServiceName());
            tempStaff.setPhotoId(staffScheduleVO.getPhotoId());
            tempStaff.setPhotoName(staffScheduleVO.getPhotoName());
            tempStaff.setStaffDay(staffScheduleVO.getStaffDay());
            tempStaff.setOrderId(staffScheduleVO.getOrderId());
            Map<String, Object> row = new HashMap<>();
            row.put("id", staffScheduleVO.getId());
            row.put("venueId", staffScheduleVO.getVenueId());
            row.put("venueName", staffScheduleVO.getVenueName());
            row.put("staffId", staffScheduleVO.getStaffId());
            row.put("nickName", staffScheduleVO.getNickName());
            row.put("staffStatus", staffScheduleVO.getStaffStatus());
            row.put("roleId", staffScheduleVO.getRoleId());
            row.put("roleName", staffScheduleVO.getRoleName());
            row.put("roleLevel", staffScheduleVO.getRoleLevel());
            row.put(String.valueOf(staffScheduleVO.getTime()), tempStaff);
            //row.put(staffScheduleVOs.get("time"), map6.get("count"));
            //合计
            int count = staffScheduleVO.getCount();
            boolean flag = false;
            for (Map<String, Object> newmap : newmaps) {
                if (newmap.get("venueId").equals(row.get("venueId")) && newmap.get("staffId").equals(row.get("staffId"))) {
                    newmap.put(String.valueOf(staffScheduleVO.getTime()), tempStaff);
                    Integer total = (Integer) newmap.get("total");
                    newmap.put("total", total + count);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                row.put("total", count);
                newmaps.add(row);
            }
        }
        //把有档期其他日子休息的摄影师放入
        List<StaffScheduleVO> staffMonthRest = staffScheduleService.selectMonthRest(companyId, firstDay, lastDay, roleId, venueId);
        TempStaffVO temp = null;
        if (staffMonthRest != null && staffMonthRest.size() > 0) {
            for (Map<String, Object> map : newmaps) {
                for (StaffScheduleVO staffScheduleVO : staffMonthRest) {
                    if (map.get("venueId").equals(staffScheduleVO.getVenueId()) &&
                            map.get("staffId").equals(staffScheduleVO.getStaffId())) {
                        temp = new TempStaffVO();
                        temp.setId(staffScheduleVO.getId());
                        temp.setStaffStatus(staffScheduleVO.getStaffStatus());
                        map.put(String.valueOf(staffScheduleVO.getTime()), temp);
                    }
                }
            }
        }
        //没档期休息的摄影师放入
        List<Map<String, Object>> staffDataOperation = dataOperation(staffMonthRest);
        if (staffDataOperation != null && staffDataOperation.size() > 0) {
            for (Map<String, Object> map : newmaps) {
                Iterator<Map<String, Object>> iterator = staffDataOperation.iterator();
                while (iterator.hasNext()) {
                    Map<String, Object> staffData = iterator.next();
                    if (map.get("staffId").equals(staffData.get("staffId"))) {
                        iterator.remove();
                    }
                }
            }
            newmaps.addAll(staffDataOperation);
        }

        return ResultInfoUtil.success(newmaps);
    }

    public List<Map<String, Object>> dataOperation(List<StaffScheduleVO> staffScheduleVOs) {

        // 最终用返回
        List<Map<String, Object>> newmaps = new ArrayList<>();
        TempStaffVO tempStaff = null;
        for (StaffScheduleVO staffScheduleVO : staffScheduleVOs) {
            tempStaff = new TempStaffVO();
            tempStaff.setCount(staffScheduleVO.getCount());
            tempStaff.setMealName(staffScheduleVO.getMealName());
            tempStaff.setStaffStatus(staffScheduleVO.getStaffStatus());
            tempStaff.setId(staffScheduleVO.getId());
            Map<String, Object> row = new HashMap<>();
            row.put("id", staffScheduleVO.getId());
            row.put("venueId", staffScheduleVO.getVenueId());
            row.put("venueName", staffScheduleVO.getVenueName());
            row.put("staffId", staffScheduleVO.getStaffId());
            row.put("nickName", staffScheduleVO.getNickName());
            row.put("staffStatus", staffScheduleVO.getStaffStatus());
            row.put("roleId", staffScheduleVO.getRoleId());
            row.put("roleName", staffScheduleVO.getRoleName());
            row.put("roleLevel", staffScheduleVO.getRoleLevel());
            row.put(String.valueOf(staffScheduleVO.getTime()), tempStaff);
            //row.put(staffScheduleVOs.get("time"), map6.get("count"));
            //合计
            int count = staffScheduleVO.getCount();
            boolean flag = false;
            for (Map<String, Object> newmap : newmaps) {
                if (newmap.get("venueId").equals(row.get("venueId")) && newmap.get("staffId").equals(row.get("staffId"))) {
                    newmap.put(String.valueOf(staffScheduleVO.getTime()), tempStaff);
                    Integer total = (Integer) newmap.get("total");
                    newmap.put("total", total + count);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                row.put("total", count);
                newmaps.add(row);
            }
        }
        return newmaps;
    }
}
