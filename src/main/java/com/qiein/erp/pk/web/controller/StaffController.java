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
public class StaffController extends InitController {
    @Autowired
    private StaffService staffService;

    /**
     * 根据groupId获取员工小组列表
     *
     * @param groupId
     * @return
     */
    @GetMapping("/select_staff_by_group_id")
    public ResultInfo selectStaffByGroupId(@RequestParam("groupId") String groupId) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        return ResultInfoUtil.success(staffService.selectStaffByGroupId(groupId, companyId));
    }

    /**
     * 修改员工信息
     *
     * @param staffIds
     * @param venueIds
     * @param roleIds
     * @return
     */
    @GetMapping("/insert_staff")
    public ResultInfo insertStaff(@RequestParam("staffIds") String staffIds, @RequestParam("venueIds") String venueIds, @RequestParam("roleIds") String roleIds) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        staffService.insertStaff(staffIds, venueIds, roleIds, companyId);
        return ResultInfoUtil.success(TipMsgEnum.SAVE_SUCCESS);
    }

    /**
     * 生产者展示页面
     */
    @GetMapping("/get_staff_by_role_id")
    public ResultInfo getStaffByRoleId(@RequestParam("roleId") Integer roleId) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        return ResultInfoUtil.success(staffService.getStaffByRoleId(roleId, companyId));
    }

    /**
     * 修改角色等级
     */
    @GetMapping("/edit_role_level")
    public ResultInfo editRoleLevel(@RequestParam("roleId") Integer roleId, @RequestParam("staffId") Integer staffId, @RequestParam("roleLevel") Integer roleLevel) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        staffService.editRoleLevel(roleId, staffId, roleLevel, companyId);
        return ResultInfoUtil.success();
    }

    /**
     * 角色下拉框
     *
     * @param roleId
     * @return
     */
    @GetMapping("/staff_select")
    public ResultInfo staffSelect(@RequestParam("roleId") String roleId) {
        Integer companyId = getCurrentLoginStaff().getCompanyId();
        return ResultInfoUtil.success(staffService.staffSelect(companyId, roleId));
    }

}
