package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.GroupDao;
import com.qiein.erp.pk.web.entity.vo.GroupVO;
import com.qiein.erp.pk.web.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小组controller
 * author：xiangliang 2018/11/08
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    /**
     * @param companyId
     * @return
     */
    // @Cacheable(value = "dept", key = "'dept'+':'+#companyId")
    public List<GroupVO> getCompanyAllDeptList(int companyId) {
        return groupDao.getCompanyAllDeptList(companyId);
    }
}
