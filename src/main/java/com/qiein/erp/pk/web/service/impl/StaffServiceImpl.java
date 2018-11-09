package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.web.dao.StaffDao;
import com.qiein.erp.pk.web.dao.VenueDao;
import com.qiein.erp.pk.web.entity.po.StaffInsertPO;
import com.qiein.erp.pk.web.entity.po.StaffRoleInsertPO;
import com.qiein.erp.pk.web.entity.po.StaffVenueInsertPO;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.ProducerShowVO;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;
import com.qiein.erp.pk.web.service.StaffService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:xiangliang
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private VenueDao venueDao;

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

    /**
     * 编辑员工
     */
    public void insertStaff(String staffIds, String venueIds, String roleIds, Integer companyId) {
        //查询员工是否已添加到erp
//        List<Integer> check=staffDao.checkHave(staffIds);
        //添加员工
        List<StaffInsertPO> staffInsertPOS = new ArrayList<>();
        for (String staffId : staffIds.split(CommonConstant.STR_SEPARATOR)) {
            StaffInsertPO staffInsertPO = new StaffInsertPO();
            staffInsertPO.setStaffId(Integer.parseInt(staffId));
            staffInsertPO.setCompanyId(companyId);
            staffInsertPO.setStatus(true);
            staffInsertPOS.add(staffInsertPO);
        }
        //修改员工
        staffDao.insertToStaff(staffInsertPOS);
        //删除员工对应场馆和角色
        staffDao.deleteRole(staffIds);
        staffDao.deleteVenue(staffIds);
        //添加员工对应场馆
        List<StaffVenueInsertPO> list = new ArrayList<>();
        for (StaffInsertPO staffInsertPO : staffInsertPOS) {
            for (String venueId : venueIds.split(CommonConstant.STR_SEPARATOR)) {
                StaffVenueInsertPO staffVenueInsertPO = new StaffVenueInsertPO();
                staffVenueInsertPO.setCompanyId(companyId);
                staffVenueInsertPO.setStaffId(staffInsertPO.getStaffId());
                staffVenueInsertPO.setVenueId(Integer.parseInt(venueId));
                list.add(staffVenueInsertPO);
            }
        }
        staffDao.insertVenue(list);
        //添加员工对应角色
        List<StaffRoleInsertPO> staffRoleInsertPOS = new ArrayList<>();
        for (StaffInsertPO staffInsertPO : staffInsertPOS) {
            for (String roleId : roleIds.split(CommonConstant.STR_SEPARATOR)) {
                StaffRoleInsertPO staffVenueInsertPO = new StaffRoleInsertPO();
                staffVenueInsertPO.setCompanyId(companyId);
                staffVenueInsertPO.setStaffId(staffInsertPO.getStaffId());
                staffVenueInsertPO.setRoleId(Integer.parseInt(roleId));
                staffRoleInsertPOS.add(staffVenueInsertPO);
            }
        }
        staffDao.insertRole(staffRoleInsertPOS);
    }

    /**
     * 生产者展示页面
     */
    public List<VenueSelectVO> getStaffByRoleId(Integer roleId, Integer companyId) {
        List<VenueSelectVO> list = venueDao.getVenues(companyId);
        List<StaffRoleTypeVO> staffRoleTypeVOS = staffDao.selectProducer(companyId, roleId);
        for (VenueSelectVO venueSelectVO : list) {
            for (Venue venue : venueSelectVO.getVenues()) {
                List<StaffRoleTypeVO> staffRoleTypeVOS1 = new ArrayList<>();
                for (StaffRoleTypeVO staffRoleTypeVO : staffRoleTypeVOS) {

                    if (venue.getId().equals(staffRoleTypeVO.getVenueId())) {
                        staffRoleTypeVOS1.add(staffRoleTypeVO);
                    }
                }
                venue.setList(staffRoleTypeVOS1);
            }
        }
        return list;
    }

    /**
     * 修改生产者等级
     *
     * @param roleId
     * @param staffId
     * @param roleLevel
     * @param companyId
     */
    public void editRoleLevel(Integer roleId, Integer staffId, Integer roleLevel, Integer companyId) {
        staffDao.editRoleLevel(roleId, staffId, roleLevel, companyId);
    }
}
