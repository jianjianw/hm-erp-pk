package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.TimeUtil;
import com.qiein.erp.pk.web.dao.MakeupRoomScheduleDao;
import com.qiein.erp.pk.web.entity.dto.MakeupRoomDTO;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import com.qiein.erp.pk.web.entity.vo.*;
import com.qiein.erp.pk.web.service.MakeupRoomScheduleService;
import com.qiein.erp.pk.web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MakeupRoomScheduleServiceImpl implements MakeupRoomScheduleService {

    @Autowired
    private MakeupRoomScheduleDao makeupRoomScheduleDao;

    @Autowired
    private ServiceService serviceService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return makeupRoomScheduleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MakeupRoomSchedulePO makeupRoomSchedulePO) {
        return makeupRoomScheduleDao.insert(makeupRoomSchedulePO);
    }

    @Override
    public MakeupRoomSchedulePO selectByPrimaryKey(Integer id) {
        return makeupRoomScheduleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<MakeupRoomSchedulePO> selectAll() {
        return makeupRoomScheduleDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(MakeupRoomSchedulePO makeupRoomSchedulePO) {
        return makeupRoomScheduleDao.updateByPrimaryKey(makeupRoomSchedulePO);
    }

    @Override
    public MakeupRoomShowVO selectMakeupRoomSchedule(Integer companyId, Integer venueId, Integer dateTime) {

        Calendar calendar =Calendar.getInstance();
        calendar.setTimeInMillis(dateTime*1000L);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        StringBuilder sb = new StringBuilder();
        String dateStr = sb.append(year).append("-").append(month).toString();

        //获取场馆下面的服务和房间
        List<ServiceVenueRoomVO> serviceAndMakeupRooms = serviceService.findServiceAndMakeupRooms(companyId, venueId);
        List<Integer> everyDayOfMonth = TimeUtil.getMonthEveryDay(TimeUtil.getMonthStartTimeStampByDate(dateStr), TimeUtil.getMonthEndTimeStampByDate(dateStr));

        Integer startTime = everyDayOfMonth.get(0);
        Integer endTime = everyDayOfMonth.get(everyDayOfMonth.size() - 1);
        //先查询所有化妆间档期
        List<MakeupRoomSchedulePO> makeupRoomSchedulePOS = makeupRoomScheduleDao.selectMakeupRoomScheduleByDate(companyId,
                                                                                        venueId, startTime, endTime);

        List<MakeupRoomScheduleVO> data = new ArrayList<>();

        for (ServiceVenueRoomVO serviceVenueRoomVO : serviceAndMakeupRooms){
            Integer voVenueId = serviceVenueRoomVO.getVenueId();
            Integer serviceId = serviceVenueRoomVO.getServiceId();
            List<VenueAndRoomVO> makeupRooms = serviceVenueRoomVO.getMakeupRooms();
            // 如果服务下面没有房间  也要返回数据  对应的房间id没有值
            if(makeupRooms.size() == 0){
                MakeupRoomScheduleVO  makeupRoomScheduleVO =  new MakeupRoomScheduleVO();
                makeupRoomScheduleVO.setVenueId(voVenueId);
                makeupRoomScheduleVO.setServiceId(serviceId);
                List<MakeupRoomDTO> makeupRooms1 = makeupRoomScheduleVO.getMakeupRooms();
                for(Integer datetime : everyDayOfMonth){//服务下面封装一个list
                    MakeupRoomDTO makeupRoomsDTO = new MakeupRoomDTO();
                    makeupRoomsDTO.setDate(datetime);
                    makeupRoomsDTO.setMakeupDayLimit(0);
                    calendar.setTimeInMillis(datetime*1000L);
                    if(Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)){
                        makeupRoomsDTO.setIsSunday(true);
                    }
                    makeupRooms1.add(makeupRoomsDTO);
                }
                data.add(makeupRoomScheduleVO);//封装服务下面没有放假的数据
            }

            for (VenueAndRoomVO venueAndRoomVO : makeupRooms){//每个房间封装数据
                MakeupRoomScheduleVO  makeupRoomScheduleVO =  new MakeupRoomScheduleVO();
                makeupRoomScheduleVO.setVenueId(voVenueId);//每个房间场馆id
                makeupRoomScheduleVO.setServiceId(serviceId);//服务id
                Integer roomId = null;
                if(venueAndRoomVO.getRoomId() != null){
                    roomId = Integer.valueOf(venueAndRoomVO.getRoomId());//房间id
                }
                makeupRoomScheduleVO.setMakeupRoomId(roomId);
                List<MakeupRoomDTO> makeupRoomsDTOs = makeupRoomScheduleVO.getMakeupRooms();
                for(Integer datetime : everyDayOfMonth){//每个场馆下面的服务，服务下面的化妆间都需要一个list
                    MakeupRoomDTO makeupRoomsDTO = new MakeupRoomDTO();
                    makeupRoomsDTO.setDate(datetime);
                    makeupRoomsDTO.setMakeupDayLimit(0);
                    calendar.setTimeInMillis(datetime*1000L);
                    if(Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)){
                        makeupRoomsDTO.setIsSunday(true);
                    }
                    makeupRoomsDTOs.add(makeupRoomsDTO);
                }
                data.add(makeupRoomScheduleVO);//封装每个房间中的数据
            }
        }

        //将数据封装到 data 中  应该再加一层
       for(MakeupRoomSchedulePO makeupRoomSchedulePO : makeupRoomSchedulePOS){
           Integer poVenueId = makeupRoomSchedulePO.getVenueId();
           Integer poServiceId = makeupRoomSchedulePO.getServiceId();
           Integer poMakeupRoomId = makeupRoomSchedulePO.getMakeupRoomId();
           Integer makeupDay = makeupRoomSchedulePO.getMakeupDay();//化妆间的档期

           Integer makeupDayLimit = makeupRoomSchedulePO.getMakeupDayLimit();

           for(MakeupRoomScheduleVO makeupRoomScheduleVO :data){
               Integer voVenueId = makeupRoomScheduleVO.getVenueId();
               Integer voServiceId = makeupRoomScheduleVO.getServiceId();
               Integer voMakeupRoomId = makeupRoomScheduleVO.getMakeupRoomId();
               if((poVenueId.equals(voVenueId)) && (poServiceId.equals(voServiceId)) && poMakeupRoomId.equals(voMakeupRoomId)){
                   List<MakeupRoomDTO> makeupRooms = makeupRoomScheduleVO.getMakeupRooms();
                   for(MakeupRoomDTO makeupRoomDTO : makeupRooms){
                       //档期中的时间  如果 和list中的日期相等
                       if(makeupDay.equals(makeupRoomDTO.getDate())){
                           makeupRoomDTO.setMakeupDayLimit(makeupDayLimit);//每天限额。
                           makeupRoomDTO.setScheduleId(makeupRoomSchedulePO.getId());
                           break;
                       }
                   }
               }
           }
       }

        MakeupRoomShowVO result = new MakeupRoomShowVO();
        result.setServiceVenueRoomVOS(serviceAndMakeupRooms);
        result.setMakeupRoomScheduleVOS(data);
        return result;
    }

    @Override
    public void updateLimitByPrimaryKey(MakeupRoomSchedulePO makeupRoomSchedulePO) {
        makeupRoomScheduleDao.updateLimitByPrimaryKey(makeupRoomSchedulePO);
    }


}
