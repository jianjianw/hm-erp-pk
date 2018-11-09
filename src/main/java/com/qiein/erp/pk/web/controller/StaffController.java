package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.enums.TipMsgEnum;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工controller
 * author：xiangliang 2018/11/08
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    /**
     * 根据groupId获取员工小组列表
     * @param groupId
     * @return
     */
    @GetMapping("/select_staff_by_group_id")
    public ResultInfo selectStaffByGroupId(@RequestParam("groupId")String groupId){
        Integer companyId=1;
        return ResultInfoUtil.success(staffService.selectStaffByGroupId(groupId,companyId));
    }

    @GetMapping("/insert_staff")
    public ResultInfo insertStaff(@RequestParam("staffIds")String staffIds,@RequestParam("venueIds")String venueIds,@RequestParam("roleIds")String roleIds){
        Integer companyId=1;
        staffService.insertStaff(staffIds,venueIds,roleIds,companyId);
        return ResultInfoUtil.success(TipMsgEnum.SAVE_SUCCESS);
    }
}
