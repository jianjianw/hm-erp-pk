package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.TimeUtil;
import com.qiein.erp.pk.web.dao.MakeupRoomScheduleDao;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import com.qiein.erp.pk.web.entity.vo.MakeupRoomScheduleVO;
import com.qiein.erp.pk.web.entity.vo.MakeupRoomShowVO;
import com.qiein.erp.pk.web.entity.vo.RoomGroupByServiceIdVO;
import com.qiein.erp.pk.web.entity.vo.ServiceVenueRoomVO;
import com.qiein.erp.pk.web.service.MakeupRoomScheduleService;
import com.qiein.erp.pk.web.service.ServiceService;
import io.swagger.models.auth.In;
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
    public int insert(MakeupRoomSchedulePO record) {
        return makeupRoomScheduleDao.insert(record);
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
            Integer voVenueId = Integer.valueOf(serviceVenueRoomVO.getVenueId());
            Integer serviceId = serviceVenueRoomVO.getServiceId();
            List<RoomGroupByServiceIdVO> makeupRooms = serviceVenueRoomVO.getMakeupRooms();
            for (RoomGroupByServiceIdVO roomGroupByServiceIdVO : makeupRooms){//每个房间
                Integer roomId = null;
                if(roomGroupByServiceIdVO.getRoomId() != null){
                    roomId = Integer.valueOf(roomGroupByServiceIdVO.getRoomId());
                }
                for(Integer datetime : everyDayOfMonth){
                    MakeupRoomScheduleVO  makeupRoomScheduleVO = new MakeupRoomScheduleVO();
                    makeupRoomScheduleVO.setDate(datetime);
                    makeupRoomScheduleVO.setMakeupRoomId(roomId);//房间id
                    makeupRoomScheduleVO.setVenueId(voVenueId);//场馆id
                    makeupRoomScheduleVO.setServiceId(serviceId);//服务id
                    makeupRoomScheduleVO.setMakeupDayLimit(0);
                    calendar.setTimeInMillis(datetime*1000L);
                    if(Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)){
                        makeupRoomScheduleVO.setIsSunday(true);
                    }
                    data.add(makeupRoomScheduleVO);
                }
            }
        }

        //将数据封装到 data 中
       for(MakeupRoomSchedulePO makeupRoomSchedulePO : makeupRoomSchedulePOS){
           Integer poVenueId = makeupRoomSchedulePO.getVenueId();
           Integer poServiceId = makeupRoomSchedulePO.getServiceId();
           Integer poMakeupRoomId = makeupRoomSchedulePO.getMakeupRoomId();
           Integer makeupDayLimit = makeupRoomSchedulePO.getMakeupDayLimit();
           for(MakeupRoomScheduleVO makeupRoomScheduleVO :data){
               Integer voVenueId = makeupRoomScheduleVO.getVenueId();
               Integer voServiceId = makeupRoomScheduleVO.getServiceId();
               Integer voMakeupRoomId = makeupRoomScheduleVO.getMakeupRoomId();
               if((poVenueId.equals(voVenueId)) && (poServiceId.equals(voServiceId)) && poMakeupRoomId.equals(voMakeupRoomId)){
                   makeupRoomScheduleVO.setMakeupDayLimit(makeupDayLimit);//每天限额。
               }
               break;
           }
       }

        MakeupRoomShowVO result = new MakeupRoomShowVO();
        result.setServiceVenueRoomVOS(serviceAndMakeupRooms);
        result.setMakeupRoomScheduleVOS(data);
        return result;
    }


}
