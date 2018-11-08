package com.qiein.erp.pk.web.entity.vo;

import com.qiein.erp.pk.web.entity.po.GroupPO;

import java.util.List;

/**
 * 小组vo
 */
public class GroupVO extends GroupPO {

    private static final long serialVersionUID = 2506540159059357216L;
    /**
     * 小组集合
     */
    private List<GroupPO> groupList;


    public List<GroupPO> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupPO> groupList) {
        this.groupList = groupList;
    }
}
