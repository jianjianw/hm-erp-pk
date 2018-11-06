package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Scene;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
public interface SceneDao {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    int insert(Scene scene);

    Scene selectByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    List<Scene> selectAll( @Param("companyId")Integer companyId);

    int updateByPrimaryKey(Scene scene);

    /**
     * 根据房间id 查找拍摄场景
     * @param companyId
     * @param roomId
     * @return
     */
    List<Scene> findSceneByRoomId(@Param("companyId") Integer companyId, @Param("roomId") Integer roomId);

    void sceneSort(List<Scene> scenes);
}