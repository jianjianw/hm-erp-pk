package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.vo.GroupVO;

import java.util.List;

/**
 * 小组service
 * author：xiangliang 2018/11/08
 */
public interface GroupService {
    /**
     * 获取公司所有部门和小组
     *
     * @param companyId 公司id
     * @return
     */
    List<GroupVO> getCompanyAllDeptList(int companyId);
}
