package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.StaffPO;
import com.qiein.erp.pk.web.entity.vo.ProducerShowVO;
import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author:xiangliang
 */
public interface StaffService {
    /**
     * 根据小组id获取员工列表
     *
     * @param groupId
     * @param companyId
     * @return
     */
    List<StaffSelectVO> selectStaffByGroupId(String groupId, Integer companyId);

    /**
     * 编辑员工
     */
    void insertStaff(String staffIds, String venueIds, String roleIds, Integer companyId);

    /**
     * 生产者展示页面
     */
    List<VenueSelectVO> getStaffByRoleId(Integer roleId, Integer companyId);

    /**
     * 修改生产者等级
     *
     * @param roleId
     * @param staffId
     * @param roleLevel
     * @param companyId
     */
    void editRoleLevel(Integer roleId, Integer staffId, Integer roleLevel, Integer companyId);


    /**
     * 根据ID获取员工
     *
     * @return
     */
    StaffPO getById(int id, int companyId);

    /**
     * 角色下拉框
     */
    List<StaffSelectVO> staffSelect(Integer companyId, String roleId);

}
