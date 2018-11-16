package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.SceneScheduleDao;
import com.qiein.erp.pk.web.entity.dto.SceneScheduleDTO;
import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
import com.qiein.erp.pk.web.entity.po.ScenePO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.service.SceneScheduleService;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
@Service
public class SceneScheduleServiceImpl implements SceneScheduleService {

    @Autowired
    private SceneScheduleDao sceneScheduleDao;
    @Autowired
    private SceneService sceneService;


    @Override
    public ShootScheduleDTO selectSceneScheduleByDate(Integer companyId, Integer venueId, Integer dateTime) {


        //查询场馆 和 拍摄间 和 拍摄景  venueId = null 查所有
        List<VenueRoomScenePO> venueRoomScenePOS = sceneService.findVenueRoomScene(companyId,venueId);
        ShootScheduleDTO result = new ShootScheduleDTO();
        //设置拍摄间/房间 拍摄景
        result.setVenueRoomScenePOS(venueRoomScenePOS);

        Map<String, Integer> startAndEndTime = getStartAndEndTime(dateTime);
        //查询场馆下面的拍摄景
        Integer startTime = startAndEndTime.get("start");
        Integer endTime = startAndEndTime.get("end");
        //1.先查询拍摄景的档期     2018年11月11日
        //便利其中的数据
        List<SceneSchedulePO> sceneSchedulePOS = sceneScheduleDao.selectSceneScheduleByDate(companyId, venueId, startTime, endTime);

        List<SceneScheduleDTO> data = new ArrayList<>();
        //封装数据
        for(VenueRoomScenePO venueRoomScenePO : venueRoomScenePOS){
            Integer poVenueId = venueRoomScenePO.getVenueId();
            Integer poRoomId = venueRoomScenePO.getRoomId();
            List<ScenePO> scenes = venueRoomScenePO.getScenes();
            for(ScenePO scene : scenes ){//每一个拍摄景都要封装一个list
                Integer sceneId = scene.getId();
                SceneScheduleDTO sceneScheduleDTO = new SceneScheduleDTO();
                sceneScheduleDTO.setVenueId(poVenueId);
                sceneScheduleDTO.setRoomId(poRoomId);
                sceneScheduleDTO.setSceneId(sceneId);
                for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS){
                    Integer venueId1 = sceneSchedulePO.getVenueId();
                    Integer shootId = sceneSchedulePO.getShootId();
                    Integer sceneId1 = sceneSchedulePO.getSceneId();
                    if(poVenueId.equals(venueId1) && poRoomId.equals(shootId) && sceneId.equals(sceneId1) ){
                        sceneScheduleDTO.getSceneSchedulePOS().add(sceneSchedulePO);//将数据封装到集合中
                    }
                }
                data.add(sceneScheduleDTO);
            }

        }
        result.setSceneScheduleDTO(data);
        return result;
    }

    @Override
    public void punchIn(Integer companyId, Integer id,Integer statusId) {
        sceneScheduleDao.punchIn(companyId,id,statusId);

    }

    @Override
    public int insert(SceneSchedulePO sceneSchedulePO) {
        return sceneScheduleDao.insert(sceneSchedulePO);
    }

    @Override
    public int updateByPrimaryKey(SceneSchedulePO sceneSchedulePO) {
        return sceneScheduleDao.updateByPrimaryKey(sceneSchedulePO);
    }

    @Override
    public void batSaveOrUpdate(List<SceneSchedulePO> sceneSchedulePOS) {
        sceneScheduleDao.batSaveOrUpdate(sceneSchedulePOS);
    }

    @Override
    public List<SceneSchedulePO> batSave(List<SceneSchedulePO> sceneSchedulePOS) {

       /* for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS){
            //SceneSchedulePO sceneSchedulePO1 = sceneScheduleDao.saveReturnId(sceneSchedulePO);
            sceneScheduleDao.saveReturnId(sceneSchedulePO);
            Integer id = sceneSchedulePO.getId();
            System.out.println();
        }*/
        sceneScheduleDao.batSave(sceneSchedulePOS);

        System.out.println();
        return null;
    }

    //获取开始时间和结束时间
    public Map<String,Integer> getStartAndEndTime(Integer dateTime){

        Map<String,Integer>  hashMap = new HashMap<>();
        Long seconds = dateTime * 1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date startTime = calendar.getTime();
        long start = startTime.getTime()/1000;
        hashMap.put("start",Integer.valueOf(String.valueOf(start)));

        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        Date endTime = calendar.getTime();
        long end = endTime.getTime() / 1000;
        hashMap.put("end",Integer.valueOf(String.valueOf(end)));

        return hashMap;
    }
}
