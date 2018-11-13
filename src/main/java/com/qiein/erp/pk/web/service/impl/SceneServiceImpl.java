package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.SceneDao;
import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;
import com.qiein.erp.pk.web.entity.po.Scene;
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
    public int insert(Scene scene) {
        return sceneDao.insert(scene);
    }

    @Override
    public Scene selectByPrimaryKey(Integer id,Integer companyId) {
        return sceneDao.selectByPrimaryKey(id,companyId);
    }

    @Override
    public List<Scene> selectAll(Integer companyId) {
        return sceneDao.selectAll(companyId);
    }

    @Override
    public int updateByPrimaryKey(Scene scene) {
        return sceneDao.updateByPrimaryKey(scene);
    }

    @Override
    public List<Scene> findSceneByRoomId(Integer companyId, Integer roomId) {
        return sceneDao.findSceneByRoomId(companyId,roomId);
    }

    @Override
    public void sceneSort(List<Scene> scenes) {
        sceneDao.sceneSort(scenes);
    }

    @Override
    public List<RoomAndSceneDTO> findRoomAndSceneByVenueId(Integer companyId, Integer venueId) {
        List<RoomAndSceneDTO> roomAndSceneDTOS = sceneDao.findRoomAndSceneByVenueId(companyId,venueId,2);
        return roomAndSceneDTOS;
    }

    @Override
    public void batInsertOrUpdateScene(List<Scene> scenes) {

        for(Scene scene : scenes ){
            Integer id = scene.getId();
            Scene scene1 = sceneDao.selectByPrimaryKey(scene.getId(), scene.getCompanyId());
            if(scene1 == null){
                sceneDao.insert(scene);
            }else{
                sceneDao.updateByPrimaryKey(scene);
            }
        }
    }

    @Override
    public List<Scene> findSceneByVenueId(Integer companyId, Integer venueId) {
        return sceneDao.findSceneByVenueId(companyId,venueId);
    }

    @Override
    public void batInsertScene(List<Scene> scenes) {
        sceneDao.batInsertScene(scenes);
    }

    @Override
    public void batUpdateScene(List<Scene> scenes) {
        sceneDao.batUpdateScene(scenes);
    }

    @Override
    public List<VenueRoomScenePO> findVenueRoomScene(Integer companyId, Integer venueId) {
        return sceneDao.findVenueRoomScene(companyId,venueId);
    }

}
