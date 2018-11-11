package com.qiein.erp.pk.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.vo.StaffScheduleVO;
import com.qiein.erp.pk.web.service.StaffScheduleService;

/**
 * 摄影师人员排空
 * author：HJF 2018/11/10
 */
@RestController
@RequestMapping("/StaffSchedule")
public class StaffScheduleController {
	
    @Autowired
    private StaffScheduleService staffScheduleService;

    /**
     * 查询人员档期
     */
    @GetMapping("/select_all")
    public ResultInfo selectAll(@RequestParam("roleId") Integer roleId,@RequestParam("firstTime") Integer firstTime,@RequestParam("endTime") Integer endTime){
        Integer companyId=1;
        List<StaffScheduleVO> staffScheduleVOs=staffScheduleService.selectAll(companyId,firstTime,endTime,roleId);
        // 最终用返回
        List<Map<String, Object>> newmaps = new ArrayList<>();

  		for (StaffScheduleVO staffScheduleVO : staffScheduleVOs) {
  			Map<String, Object> row = new HashMap<>();
  			row.put("venueId", staffScheduleVO.getVenueId());
  			row.put("venueName", staffScheduleVO.getVenueName());
  			row.put("staffId", staffScheduleVO.getStaffId());
  			row.put("nickName", staffScheduleVO.getNickName());
  			row.put("staffStatus", staffScheduleVO.getStaffStatus());
  			row.put("roleId", staffScheduleVO.getRoleId());
  			row.put("roleName", staffScheduleVO.getRoleName());
  			row.put("roleLevel", staffScheduleVO.getRoleLevel());
  			row.put(String.valueOf(staffScheduleVO.getTime()), 1);
  			
  			//row.put(staffScheduleVOs.get("time"), map6.get("count"));
  			//合计
  			int count=1;
  			boolean flag = false;
  			for (Map<String, Object> newmap : newmaps) {
  				if (newmap.get("venueId").equals(row.get("venueId")) &&newmap.get("staffId").equals(row.get("staffId"))) {
  					newmap.put(String.valueOf(staffScheduleVO.getTime()), 1);
  					Integer total = (Integer)newmap.get("total");
  					newmap.put("total", total + count);
  					flag = true;
  					break;
  				}
  			}
  			if (!flag) {
  				row.put("total",count);
  				newmaps.add(row);
  			}
  		}		
        return ResultInfoUtil.success(newmaps);
    }

    
}
