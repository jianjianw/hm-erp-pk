package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.vo.GroupVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小组dao
 * author：xiangliang 2018/11/08
 */
public interface GroupDao {
    /**
     * 获取公司所有部门和小组
     *
     * @param companyId
     * @return
     */
    List<GroupVO> getCompanyAllDeptList(@Param("companyId") int companyId);
}
