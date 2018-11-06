package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Scene;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
public interface SceneService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(Scene scene);

    Scene selectByPrimaryKey(Integer id,Integer companyId);

    List<Scene> selectAll(Integer companyId);

    int updateByPrimaryKey(Scene scene);

    //根据房间id查询房间下面的拍摄景
    List<Scene> findSceneByRoomId(Integer companyId, Integer roomId);

    /**
     * 场景排序，修改优先级
     * @param scenes
     */
    void sceneSort(List<Scene> scenes);
}
