package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
import com.qiein.erp.pk.web.entity.dto.TimeStampScheduleDTO;
import com.qiein.erp.pk.web.entity.dto.VenueScheduleDTO;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.service.SceneService;
import com.qiein.erp.pk.web.service.SceneScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 拍摄景档期   (拍摄间档期)
 * wang lei
 * 2018-11-9
 */
@RestController
@RequestMapping("/scene_room_schedule")
public class SceneScheduleController {

    @Autowired
    private SceneScheduleService sceneScheduleService;

    @Autowired
    private SceneService sceneService;
    @GetMapping("/select_scene_schedule_by_date")
    public ResultInfo selectShootSchedule(Integer companyId, Integer venueId,Integer dateTime){

        Map<String, Integer> startAndEndTime = getStartAndEndTime(dateTime);
        //查询场馆下面的拍摄景
        List<Scene> scenes = sceneService.findSceneByVenueId(companyId, venueId);
        ShootScheduleDTO result = new ShootScheduleDTO();
        //设置拍摄景
        result.setScenes(scenes);
        Integer startTime = startAndEndTime.get("start");
        Integer endTime = startAndEndTime.get("end");
        //查询所有的档期
        List<SceneSchedulePO> sceneSchedulePOS = sceneScheduleService.selectScheduleByDateTime(companyId, venueId,startTime,endTime);

        //封装时间戳
        List<TimeStampScheduleDTO> timeStampList = new ArrayList<>();
        List<Long> timeList = getTimeList(dateTime);
        for(Long time : timeList){
            String str = String.valueOf(time);
            TimeStampScheduleDTO timeStampScheduleDTO = new TimeStampScheduleDTO();
            timeStampScheduleDTO.setTimeStamp(Integer.parseInt(str));
            timeStampList.add(timeStampScheduleDTO);
        }

        for(TimeStampScheduleDTO timeStamp : timeStampList){
            Integer timeStamp1 = timeStamp.getTimeStamp();
            for (SceneSchedulePO schedule : sceneSchedulePOS){
                Integer beginTime1 = schedule.getStartTime();
                if(timeStamp1.equals(beginTime1)){
                    VenueScheduleDTO venueScheduleDTO = new VenueScheduleDTO();
                    venueScheduleDTO.setSceneId(schedule.getSceneId()); //拍摄景
                    venueScheduleDTO.setShootRoomId(schedule.getShootId()); //拍摄间id
                    venueScheduleDTO.setCameramanId(schedule.getStaffVO().getId()); //摄影师id  //关联人员表
                    venueScheduleDTO.setCameramanName(schedule.getStaffVO().getNickName()); //摄影师name
                    timeStamp.getVenueSchedule().add(venueScheduleDTO);
                }
            }
        }
        result.setTimeStampScheduleDTOS(timeStampList);
        return ResultInfoUtil.success(result);
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

        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        Date endTime = calendar.getTime();
        long end = endTime.getTime() / 1000;
        hashMap.put("end",Integer.valueOf(String.valueOf(end)));

        return hashMap;
    }

    //获取开始时间集合
    public List<Long> getTimeList(Integer second){
        Long seconds = second * 1000L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);//传递进来的参数
        Date time1 = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = sdf1.format(time1);
        String[] split = format1.split("-");
        calendar.set(Integer.valueOf(split[0]),Integer.valueOf(split[1])-1,Integer.valueOf(split[2]),9,0);
        //Integer begin=9;
        Integer end = 18;
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
}
