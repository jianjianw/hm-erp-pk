package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;

import java.util.List;

/**
 * 拍摄景批量更新
 * wang lei
 * 2018-11-18
 */
public class SceneRequestDTO {

    List<SceneSchedulePO> sceneSchedulePOS;
    List<Integer> deleteIds;


    public List<SceneSchedulePO> getSceneSchedulePOS() {
        return sceneSchedulePOS;
    }

    public void setSceneSchedulePOS(List<SceneSchedulePO> sceneSchedulePOS) {
        this.sceneSchedulePOS = sceneSchedulePOS;
    }

    public List<Integer> getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(List<Integer> deleteIds) {
        this.deleteIds = deleteIds;
    }
}
