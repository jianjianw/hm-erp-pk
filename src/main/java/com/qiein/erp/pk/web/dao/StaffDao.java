package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.vo.StaffSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * author:xiangliang
 */
public interface StaffDao {
    /**
     * 根据小组获取员工
     */
    List<StaffSelectVO> selectStaffByGroupId(@Param("groupId") String groupId,@Param("companyId") Integer companyId);
    /**
     * 根据小组获取员工对应场景管
     */
    List<StaffSelectVO> findVenueByGroupId(@Param("groupId") String groupId,@Param("companyId") Integer companyId);
}
