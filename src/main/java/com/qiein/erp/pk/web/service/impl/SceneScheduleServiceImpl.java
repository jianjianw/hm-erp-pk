package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.dao.SceneScheduleDao;
import com.qiein.erp.pk.web.entity.dto.SceneDTO;
import com.qiein.erp.pk.web.entity.dto.SceneScheduleDTO;
import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
import com.qiein.erp.pk.web.entity.po.ScenePO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.entity.vo.SceneScheduleVO;
import com.qiein.erp.pk.web.service.SceneScheduleService;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    public Integer saveReturnId(SceneSchedulePO sceneSchedulePO) {
        return sceneScheduleDao.saveReturnId(sceneSchedulePO);
    }

    @Override
    public List<SceneScheduleVO> batSave(List<SceneSchedulePO> sceneSchedulePOS) {

        sceneScheduleDao.batSave(sceneSchedulePOS);
        List<SceneScheduleVO> sceneScheduleVOS = new ArrayList<>();
        //封装id 和 时间返回
        for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS){
            SceneScheduleVO sceneScheduleVO = new SceneScheduleVO();
            sceneScheduleVO.setId(sceneSchedulePO.getId());
            sceneScheduleVO.setShootId(sceneSchedulePO.getShootId());
            sceneScheduleVO.setSceneId(sceneSchedulePO.getSceneId());
            sceneScheduleVO.setSceneName(sceneSchedulePO.getSceneName());
            sceneScheduleVO.setStartTime(sceneSchedulePO.getStartTime());
            sceneScheduleVO.setEndTime(sceneSchedulePO.getEndTime());
            sceneScheduleVOS.add(sceneScheduleVO);
        }
        return sceneScheduleVOS;
    }

    @Override
    public List<SceneSchedulePO> selectSceneScheduleBySceneIdAndDate(SceneDTO sceneDTO){

        Map<String, Integer> startAndEndTime = getStartAndEndTime(sceneDTO.getDate());
        sceneDTO.setStartTime(startAndEndTime.get("start"));//当天最小时间
        sceneDTO.setEndTime(startAndEndTime.get("end"));//当天最大时间
        //获得拍摄景档期
        List<SceneSchedulePO> sceneSchedulePOS = sceneScheduleDao.selectSceneScheduleBySceneIdAndDate(sceneDTO);

        List<SceneSchedulePO> result = new ArrayList<>();
        //获取开始时间 和 结束时间 集合
        Map<Integer, Integer> timeMap = getTimeMap(sceneDTO.getDate());
        Set<Map.Entry<Integer, Integer>> entries = timeMap.entrySet();
        //每个时间段都返回一条数据，如果该档期有 就将Select 设为false
        for(Map.Entry<Integer, Integer> entry : entries){
            Integer start = entry.getKey();
            Integer end = entry.getValue();
            SceneSchedulePO sceneSchedule = new SceneSchedulePO();
            sceneSchedule.setStartTime(start);
            sceneSchedule.setEndTime(end);
            sceneSchedule.setStartTime(Integer.valueOf(String.valueOf(start)));
            //遍历查询到的档期
            for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS){
                if(start.equals(sceneSchedulePO.getStartTime())){
                    sceneSchedule.setSelect(false);//已存在，不可选
                }
            }
            result.add(sceneSchedule);//封装拍摄景档期的所有档期
        }
        //返回封装好得数据
        return  result;
    }

    @Override
    public List<SceneSchedulePO> selectSceneScheduleBySceneIdAndDateTime(SceneDTO sceneDTO) {
        List<SceneSchedulePO> result = sceneScheduleDao.selectSceneScheduleBySceneIdAndDate(sceneDTO);//保存的时候先要查询  时间段
        return  result;
    }

    @Override
    public ResultInfo batSaveSelect(List<SceneSchedulePO> sceneSchedulePOS) {

         for(SceneSchedulePO sceneSchedulePO : sceneSchedulePOS){
            SceneDTO sceneDTO = new SceneDTO();
            sceneDTO.setCompanyId(sceneSchedulePO.getCompanyId());
            sceneDTO.setVenueId(sceneSchedulePO.getVenueId());
            sceneDTO.setShootId(sceneSchedulePO.getShootId());
            sceneDTO.setSceneId(sceneSchedulePO.getSceneId());
            sceneDTO.setStartTime(sceneSchedulePO.getStartTime());
            sceneDTO.setEndTime(sceneSchedulePO.getEndTime());
            //防止重复  先查
            List<SceneSchedulePO> sceneSchedule = selectSceneScheduleBySceneIdAndDateTime(sceneDTO);
            if(sceneSchedule != null && sceneSchedule.size() > 0 ){
                return ResultInfoUtil.error(409,sceneSchedulePO.getSceneName()+"档期已存在");
            }
            sceneScheduleDao.saveReturnId(sceneSchedulePO);
        }

        return ResultInfoUtil.success(sceneSchedulePOS);
    }

    @Override
    public List<SceneSchedulePO> findSceneScheduleByIds(Integer companyId, List<Integer> ids) {
        List<SceneSchedulePO> sceneSchedulePOS = sceneScheduleDao.findSceneScheduleByIds(companyId,ids);
        return sceneSchedulePOS;
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


    //获取开始时间集合List
    public List<Long> getTimeList(Integer second){
        Long seconds = second * 1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);//传递进来的参数
        Date time1 = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sdf1.format(time1);
        String[] split = format1.split("-");
        calendar.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]),9,0);
        Integer end = 24;
        List<Long> times = new ArrayList<>();
        for(int i = 0;i < end; i++){
            Date time2 = calendar.getTime();
            long time3 = time2.getTime()/1000;
            //long time3 = time2.getTime();
            times.add(time3);
            calendar.add(Calendar.MINUTE,30);
        }
        return times;
    }

    //获取开始时间  和 结束时间 集合
    public Map<Integer,Integer> getTimeMap(Integer second){
        Long seconds = second * 1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);//传递进来的参数
        Date time1 = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sdf1.format(time1);
        String[] split = format1.split("-");
        calendar.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]),9,0);
        Integer end = 24;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,String> timeStr = new LinkedHashMap<>();
        Map<Integer,Integer> times = new LinkedHashMap<>();
        for(int i = 0;i < end; i++){
            Date time2 = calendar.getTime();
            Integer startTime = Integer.valueOf(String.valueOf(time2.getTime()/1000));
            calendar.add(Calendar.MINUTE,30);

            Date time3 = calendar.getTime();
            Integer endTime = Integer.valueOf(String.valueOf(time3.getTime() / 1000));
            times.put(startTime,endTime);

            String startStr = sdf.format(time2);
            String endStr = sdf.format(time3);
            timeStr.put(startStr,endStr);
        }

        return times;
    }



}
