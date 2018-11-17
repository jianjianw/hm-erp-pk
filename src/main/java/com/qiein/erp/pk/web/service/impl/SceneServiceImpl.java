package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.SceneDao;
import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;
import com.qiein.erp.pk.web.entity.po.ScenePO;
import com.qiein.erp.pk.web.service.RoomService;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneDao sceneDao;
    @Autowired
    private RoomService roomService;

    @Override
    public int deleteByPrimaryKey(Integer id,Integer companyId) {
        return sceneDao.deleteByPrimaryKey(id,companyId);
    }

    @Override
    public int insert(ScenePO scene) {
        return sceneDao.insert(scene);
    }

    @Override
    public ScenePO selectByPrimaryKey(Integer id, Integer companyId) {
        return sceneDao.selectByPrimaryKey(id,companyId);
    }

    @Override
    public List<ScenePO> selectAll(Integer companyId) {
        return sceneDao.selectAll(companyId);
    }

    @Override
    public int updateByPrimaryKey(ScenePO scene) {
        return sceneDao.updateByPrimaryKey(scene);
    }

    @Override
    public List<ScenePO> findSceneByRoomId(Integer companyId, Integer roomId) {
        return sceneDao.findSceneByRoomId(companyId,roomId);
    }

    @Override
    public void sceneSort(List<ScenePO> scenes) {
        sceneDao.sceneSort(scenes);
    }

    @Override
    public List<RoomAndSceneDTO> findRoomAndSceneByVenueId(Integer companyId, Integer venueId) {
        List<RoomAndSceneDTO> roomAndSceneDTOS = sceneDao.findRoomAndSceneByVenueId(companyId,venueId,2);
        return roomAndSceneDTOS;
    }

    @Override
    public void batInsertOrUpdateScene(List<ScenePO> scenes) {

        for(ScenePO scene : scenes ){
            ScenePO scene1 = sceneDao.selectByPrimaryKey(scene.getId(), scene.getCompanyId());
            if(scene1 == null){
                sceneDao.insert(scene);
            }else{
                sceneDao.updateByPrimaryKey(scene);
            }
        }
    }

    @Override
    public List<ScenePO> findSceneByVenueId(Integer companyId, Integer venueId) {
        return sceneDao.findSceneByVenueId(companyId,venueId);
    }

    @Override
    public void batInsertScene(List<ScenePO> scenes) {
        sceneDao.batInsertScene(scenes);
    }

    @Override
    public void batUpdateScene(List<ScenePO> scenes) {
        sceneDao.batUpdateScene(scenes);
    }

    @Override
    public List<VenueRoomScenePO> findVenueRoomScene(Integer companyId, Integer venueId) {
        return sceneDao.findVenueRoomScene(companyId,venueId);
    }

    @Override
    public Integer findSceneCount(Integer companyId, Integer venueId, Integer status) {
        return sceneDao.findSceneCount(companyId,venueId,status);
    }

}
