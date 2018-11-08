package com.qiein.erp.pk.web.service;

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
}
