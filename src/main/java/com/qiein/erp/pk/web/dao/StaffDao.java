package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.StaffInsertPO;
import com.qiein.erp.pk.web.entity.po.StaffPO;
import com.qiein.erp.pk.web.entity.po.StaffRoleInsertPO;
import com.qiein.erp.pk.web.entity.po.StaffVenueInsertPO;
import com.qiein.erp.pk.web.entity.vo.StaffRoleTypeVO;
import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工相关
 * author:xiangliang
 */
public interface StaffDao {

    /**
     * 根据ID 公司ID  获取员工
     *
     * @param id
     * @param companyId
     * @return
     */
    StaffPO getByIdAndCid(@Param("id") int id, @Param("companyId") int companyId);

    /**
     * 根据小组获取员工
     */
    List<StaffSelectVO> selectStaffByGroupId(@Param("groupId") String groupId, @Param("companyId") Integer companyId);

    /**
     * 根据小组获取员工对应场景管
     */
    List<StaffSelectVO> findVenueByGroupId(@Param("groupId") String groupId, @Param("companyId") Integer companyId);

    /**
     * 查询员工是否已添加到erp
     */
    List<Integer> checkHave(@Param("staffIds") String staffIds);

    /**
     * 插入员工表
     */
    void insertToStaff(@Param("list") List<StaffInsertPO> list);

    /**
     * 删除员工关联场馆
     */
    void deleteVenue(@Param("staffIds") String staffIds);

    /**
     * 删除员工关联角色
     */
    void deleteRole(@Param("staffIds") String staffIds);

    /**
     * 新增员工关联场馆
     */
    void insertVenue(@Param("list") List<StaffVenueInsertPO> list);

    /**
     * 删除员工关联角色
     */
    void insertRole(@Param("list") List<StaffRoleInsertPO> list);

    /**
     * 生产者页面
     */
    List<StaffRoleTypeVO> selectProducer(@Param("companyId") Integer companyId, @Param("roleId") Integer roleId);

    /**
     * 修改生产者等级
     *
     * @param roleId
     * @param staffId
     * @param roleLevel
     * @param companyId
     */
    void editRoleLevel(@Param("roleId") Integer roleId, @Param("staffId") Integer staffId, @Param("roleLevel") Integer roleLevel, @Param("companyId") Integer companyId);

    /**
     * 角色下拉框
     */
    List<StaffSelectVO> staffSelect(@Param("companyId") Integer companyId, @Param("roleId") String roleId);

}
