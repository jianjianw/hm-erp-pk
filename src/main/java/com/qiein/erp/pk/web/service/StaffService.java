package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.vo.ProducerShowVO;
import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;

import java.util.List;
/**
 * author:xiangliang
 */
public interface StaffService {
    /**
     * 根据小组id获取员工列表
     * @param groupId
     * @param companyId
     * @return
     */
    List<StaffSelectVO> selectStaffByGroupId(String groupId,Integer companyId);
    /**
     * 编辑员工
     */
    void insertStaff(String staffIds,String venueIds,String roleIds,Integer companyId);
    /**
     * 生产者展示页面
     */
    ProducerShowVO getStaffByRoleId(Integer roleId,Integer companyId);

    /**
     * 修改生产者等级
     * @param roleId
     * @param staffId
     * @param roleLevel
     * @param companyId
     */
    void editRoleLevel(Integer roleId,Integer staffId,Integer roleLevel,Integer companyId);
}
