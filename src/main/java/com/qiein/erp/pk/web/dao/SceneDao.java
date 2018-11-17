package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;
import com.qiein.erp.pk.web.entity.po.ScenePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
public interface SceneDao {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    int insert(ScenePO scene);

    ScenePO selectByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    List<ScenePO> selectAll(@Param("companyId")Integer companyId);

    int updateByPrimaryKey(ScenePO scene);

    /**
     * 根据房间id 查找拍摄场景
     * @param companyId
     * @param roomId
     * @return
     */
    List<ScenePO> findSceneByRoomId(@Param("companyId") Integer companyId, @Param("roomId") Integer roomId);

    void sceneSort(List<ScenePO> scenes);
    /**
     * 获取场馆下面的拍摄间和拍摄景
     * @param companyId
     * @param venueId
     * @param roomType
     * @return
     */
    List<RoomAndSceneDTO> findRoomAndSceneByVenueId(@Param("companyId") Integer companyId,
                                             @Param("venueId") Integer venueId,
                                             @Param("roomType") Integer roomType);

    /**
     * 批量编辑拍摄景
     * @param scenes
     */
    void batInsertOrUpdateScene(List<ScenePO> scenes);

    /**
     * 查询场馆下面的拍摄景
     * @param companyId
     * @param venueId
     * @return
     */
    List<ScenePO> findSceneByVenueId(@Param("companyId") Integer companyId, @Param("venueId")Integer venueId);

    /**
     * 批量新增
     * @param scenes
     */
    void batInsertScene(List<ScenePO> scenes);

    /**
     * 批量编辑
     * @param scenes
     */
    void batUpdateScene(List<ScenePO> scenes);

    /**
     * 查询场馆 房间 拍摄景
     * @param companyId
     * @param venueId
     * @return
     */
    List<VenueRoomScenePO> findVenueRoomScene(@Param("companyId") Integer companyId, @Param("venueId")Integer venueId);

    /**
     * 查询场馆下面的拍摄景
     * @param companyId
     * @param venueId
     * @param status
     * @return
     */
    Integer findSceneCount(@Param("companyId") Integer companyId,
                           @Param("venueId") Integer venueId,
                           @Param("status") Integer status);
}