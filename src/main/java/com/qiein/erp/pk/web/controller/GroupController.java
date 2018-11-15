package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.vo.GroupVO;
import com.qiein.erp.pk.web.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门controller
 * author：xiangliang 2018/11/08
 */
@RestController
@RequestMapping("/group")
public class GroupController extends InitController{
    @Autowired
    private GroupService groupService;

    /**
     * 获取部门以及所有小组
     * @return
     */
    @GetMapping("/get_company_all_dept_list")
    public ResultInfo getCompanyAllDeptList() {
        // 获取当前登录账户
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<GroupVO> list = groupService.getCompanyAllDeptList(companyId);
        return ResultInfoUtil.success(list);
    }
}
