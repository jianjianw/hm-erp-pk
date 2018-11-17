package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;
import com.qiein.erp.pk.web.entity.po.ScenePO;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
public interface SceneService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(ScenePO scene);

    ScenePO selectByPrimaryKey(Integer id, Integer companyId);

    List<ScenePO> selectAll(Integer companyId);

    int updateByPrimaryKey(ScenePO scene);

    //根据房间id查询房间下面的拍摄景
    List<ScenePO> findSceneByRoomId(Integer companyId, Integer roomId);

    /**
     * 场景排序，修改优先级
     * @param scenes
     */
    void sceneSort(List<ScenePO> scenes);

    /**
     * 查询场馆下面的房间和拍摄景
     * @param companyId
     * @param venueId
     * @return
     */
    List<RoomAndSceneDTO> findRoomAndSceneByVenueId(Integer companyId, Integer venueId);

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
    List<ScenePO> findSceneByVenueId(Integer companyId, Integer venueId);

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
     * 查询 场馆 拍摄间  拍摄景
     * @param companyId
     * @param venueId
     * @return
     */
    List<VenueRoomScenePO> findVenueRoomScene(Integer companyId, Integer venueId);

    /**
     * 查询场馆下面的拍摄景
     * @param companyId
     * @param venueId
     * @param status
     * @return
     */
    Integer findSceneCount(Integer companyId, Integer venueId,Integer status);
}
