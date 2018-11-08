package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.web.dao.StaffDao;
import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;
import com.qiein.erp.pk.web.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:xiangliang
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    /**
     * 根据小组id获取员工列表
     *
     * @param groupId
     * @param companyId
     * @return
     */
    public List<StaffSelectVO> selectStaffByGroupId(String groupId, Integer companyId) {
        List<StaffSelectVO> list = staffDao.selectStaffByGroupId(groupId, companyId);
        List<StaffSelectVO> venueList = staffDao.findVenueByGroupId(groupId, companyId);
        for (StaffSelectVO staffSelectVO : list) {
            String roleNames = CommonConstant.NULL_STR;
            for (String roleId : staffSelectVO.getRoleIds().split(CommonConstant.STR_SEPARATOR)) {
                if (!roleId.trim().equals(CommonConstant.NULL_STR)) {
                    roleNames += findRoleName(roleId) + CommonConstant.STR_SEPARATOR;
                }
            }
            if (!roleNames.equals(CommonConstant.NULL_STR)) {
                roleNames = roleNames.substring(0, roleNames.length() - 1);
            }
            staffSelectVO.setRoleNames(roleNames);
            for (StaffSelectVO staffSelectVO1 : venueList) {
                if (staffSelectVO.getId().equals(staffSelectVO1.getId())) {
                    staffSelectVO.setVenueIds(staffSelectVO1.getVenueIds());
                    staffSelectVO.setVenueNames(staffSelectVO1.getVenueNames());
                }
            }
        }

        return list;
    }

    private String findRoleName(String roleId) {
        String roleName = CommonConstant.NULL_STR;
        switch (Integer.parseInt(roleId)) {
            case 1:
                roleName = "摄像师";
                break;
            case 2:
                roleName = "化妆师";
                break;
            default:
                break;
        }
        return roleName;
    }
}
