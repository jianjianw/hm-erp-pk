package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.TimeUtil;
import com.qiein.erp.pk.web.dao.MakeupRoomScheduleDao;
import com.qiein.erp.pk.web.entity.dto.MakeupRoomDTO;
import com.qiein.erp.pk.web.entity.dto.MakeupRoomSchDTO;
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

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateTime * 1000L);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        StringBuilder sb = new StringBuilder();
        String dateStr = sb.append(year).append("-").append(month).toString();

        //获取场馆下面的服务和房间
        List<ServiceVenueRoomVO> serviceAndMakeupRooms = serviceService.findServiceAndMakeupRooms(companyId, venueId);
        List<Integer> everyDayOfMonth = TimeUtil.getMonthEveryDay(TimeUtil.getMonthStartTimeStampByDate(dateStr),
                TimeUtil.getMonthEndTimeStampByDate(dateStr));

        Integer startTime = everyDayOfMonth.get(0);
        Integer endTime = everyDayOfMonth.get(everyDayOfMonth.size() - 1);
        //先查询所有化妆间档期
        List<MakeupRoomSchedulePO> makeupRoomSchedulePOS = makeupRoomScheduleDao.selectMakeupRoomScheduleByDate(companyId,
                venueId, startTime, endTime);

        List<MakeupRoomScheduleVO> data = new ArrayList<>();

        for (ServiceVenueRoomVO serviceVenueRoomVO : serviceAndMakeupRooms) {
            Integer voVenueId = serviceVenueRoomVO.getVenueId();
            Integer serviceId = serviceVenueRoomVO.getServiceId();
            String serviceName = serviceVenueRoomVO.getServiceName();
            String venueName = serviceVenueRoomVO.getVenueName();
            List<VenueAndRoomVO> makeupRooms = serviceVenueRoomVO.getMakeupRooms();
            // 如果服务下面没有房间  也要返回数据  对应的房间id没有值
            if (makeupRooms.size() == 0) {
                MakeupRoomScheduleVO makeupRoomScheduleVO = new MakeupRoomScheduleVO();
                makeupRoomScheduleVO.setVenueId(voVenueId);
                makeupRoomScheduleVO.setServiceId(serviceId);
                List<MakeupRoomDTO> makeupRooms1 = makeupRoomScheduleVO.getMakeupRooms();
                for (Integer datetime : everyDayOfMonth) {//服务下面封装一个list
                    MakeupRoomDTO makeupRoomsDTO = new MakeupRoomDTO();
                    makeupRoomsDTO.setDate(datetime);
                    makeupRoomsDTO.setMakeupDayLimit(0);
                    calendar.setTimeInMillis(datetime * 1000L);
                    if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
                        makeupRoomsDTO.setIsSunday(true);
                    }
                    makeupRoomsDTO.setServiceName(serviceName);
                    makeupRoomsDTO.setVenueName(venueName);
                    makeupRooms1.add(makeupRoomsDTO);
                }
                data.add(makeupRoomScheduleVO);//封装服务下面没有放假的数据
                continue;
            }

            for (VenueAndRoomVO venueAndRoomVO : makeupRooms) {//每个房间封装数据
                MakeupRoomScheduleVO makeupRoomScheduleVO = new MakeupRoomScheduleVO();
                makeupRoomScheduleVO.setVenueId(voVenueId);//每个房间场馆id
                makeupRoomScheduleVO.setServiceId(serviceId);//服务id
                Integer roomId = venueAndRoomVO.getRoomId();//房间id
                Integer roomStatus;
                if(venueAndRoomVO.isRoomStatus())
                {roomStatus=1;}
                else{
                    roomStatus=0;
                }
                makeupRoomScheduleVO.setMakeupRoomId(roomId);
                List<MakeupRoomDTO> makeupRoomsDTOs = makeupRoomScheduleVO.getMakeupRooms();
                for (Integer datetime : everyDayOfMonth) {//每个场馆下面的服务，服务下面的化妆间都需要一个list
                    MakeupRoomDTO makeupRoomsDTO = new MakeupRoomDTO();
                    makeupRoomsDTO.setDate(datetime);
                    makeupRoomsDTO.setMakeupDayLimit(0);
                    calendar.setTimeInMillis(datetime * 1000L);
                    if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
                        makeupRoomsDTO.setIsSunday(true);
                    }
                    makeupRoomsDTO.setServiceName(serviceName);
                    makeupRoomsDTO.setRoomStatus(roomStatus);
                    makeupRoomsDTO.setVenueName(venueName);
                    makeupRoomsDTOs.add(makeupRoomsDTO);
                }
                data.add(makeupRoomScheduleVO);//封装每个房间中的数据
            }
        }
        //上面是封装数据时间数据
        //将数据封装到 data 中
       for(MakeupRoomSchedulePO makeupRoomSchedulePO : makeupRoomSchedulePOS){
           Integer poVenueId = makeupRoomSchedulePO.getVenueId();
           Integer poServiceId = makeupRoomSchedulePO.getServiceId();
           Integer poMakeupRoomId = makeupRoomSchedulePO.getMakeupRoomId();
           Integer makeupDay = makeupRoomSchedulePO.getMakeupDay();//化妆间的档期
           Integer orderType = makeupRoomSchedulePO.getOrderType();
           Integer makeupDayLimit = makeupRoomSchedulePO.getMakeupDayLimit();
           Integer countNum = makeupRoomSchedulePO.getCountNum();
           String mealName = makeupRoomSchedulePO.getMealName();
           Integer orderId = makeupRoomSchedulePO.getOrderId();


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
                           makeupRoomDTO.setOrderType(orderType);
                           makeupRoomDTO.setCountNum(countNum);//关联的拍摄流程的个数
                           makeupRoomDTO.setMealName(mealName);
                           makeupRoomDTO.setOrderId(orderId);
                           break;
                       }
                   }
               }
           }
       }

       //查询拍摄流程休息设置
       for(MakeupRoomScheduleVO makeupRoomScheduleVO : data){
           List<MakeupRoomDTO> makeupRooms = makeupRoomScheduleVO.getMakeupRooms();
           for( int i = makeupRooms.size() - 1;i >= 0;i--){
               MakeupRoomDTO makeupRoomDTO = makeupRooms.get(i);
               Integer countNum = makeupRoomDTO.getCountNum();
               Integer roomStatus = makeupRoomDTO.getRoomStatus();
               if((countNum == null || countNum == 0) && (roomStatus == null || roomStatus == 0) ){
                   makeupRooms.remove(i);
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

    @Override
    public void batSaveOrUpdate(List<MakeupRoomSchedulePO> makeupRoomSchedulePOS) {
        makeupRoomScheduleDao.batSaveOrUpdate(makeupRoomSchedulePOS);
    }

    //    @Override
//    public List<VenueAndRoomVO> findMakeupRoomScheduleByServiceId(Integer companyId,Integer venueId, Integer serviceId, Integer date) {
//
//        //查询服务下面的化妆间  和 状态
//        List<VenueAndRoomVO> makeupRooms = serviceService.findMakeupRoomsByServiceId(companyId, venueId, serviceId);
//
//        //封装服务下面的化妆间id
//        List<Integer> roomIds = new ArrayList<>();
//        for (VenueAndRoomVO venueAndRoomVO : makeupRooms) {
//            roomIds.add(venueAndRoomVO.getRoomId());
//        }
//        //查询化妆间的档期
//        List<MakeupRoomSchedulePO> makeupRoomSchedulePOS = makeupRoomScheduleDao.findMakeupRoomScheduleByDateAndRoomIds(companyId, venueId, serviceId, date, roomIds);
//
//        //封装化妆间档期
//        for(VenueAndRoomVO venueAndRoomVO : makeupRooms){
//            Integer venueId1 = venueAndRoomVO.getVenueId();
//            Integer serviceId1 = venueAndRoomVO.getServiceId();
//            Integer roomId = venueAndRoomVO.getRoomId();
//            for(MakeupRoomSchedulePO makeupRoomSchedulePO : makeupRoomSchedulePOS){
//                Integer venueId2 = makeupRoomSchedulePO.getVenueId();
//                Integer serviceId2 = makeupRoomSchedulePO.getServiceId();
//                Integer makeupRoomId = makeupRoomSchedulePO.getMakeupRoomId();
//                if(venueId1.equals(venueId2) && serviceId1.equals(serviceId2) && roomId.equals(makeupRoomId)){
//                    venueAndRoomVO.setMakeupRoomScheduleId(makeupRoomSchedulePO.getId());//封装化妆间档期
//                }
//            }
//        }
//        List<MakeupRoomSchedulePO> batSave = new ArrayList<>();
//        for(VenueAndRoomVO venueAndRoomVO :makeupRooms ){
//            MakeupRoomSchedulePO save = new MakeupRoomSchedulePO();
//            save.setCompanyId(companyId);
//            save.setVenueId(venueId);
//            save.setServiceId(serviceId);
//            save.setMakeupDay(date);
//            save.setMakeupDayLimit(1);
//            save.setMakeupRoomId(venueAndRoomVO.getRoomId());
//            save.setId(venueAndRoomVO.getMakeupRoomScheduleId());//已经存在的档期
//            batSave.add(save);
//        }
//        if(batSave != null && batSave.size()>0){
//            //档期表里面不存在的 insert  存在的只更新companyId,查询和更新的companyId是一致的，所以就只是insert不存在的
//            makeupRoomScheduleDao.batSave(batSave);
//        }
//
//
//        //重新查询所有的化妆间档期  已经将没有档期的插入数据库
//        List<MakeupRoomSchedulePO> makeupRoomSchedules = makeupRoomScheduleDao.findMakeupRoomScheduleByDateAndRoomIds(companyId, venueId, serviceId, date, roomIds);
//        for(VenueAndRoomVO venueAndRoomVO : makeupRooms){
//            Integer venueId1 = venueAndRoomVO.getVenueId();
//            Integer serviceId1 = venueAndRoomVO.getServiceId();
//            Integer roomId = venueAndRoomVO.getRoomId();
//            for(MakeupRoomSchedulePO makeupRoomSchedulePO : makeupRoomSchedules){
//                Integer venueId2 = makeupRoomSchedulePO.getVenueId();
//                Integer serviceId2 = makeupRoomSchedulePO.getServiceId();
//                Integer makeupRoomId = makeupRoomSchedulePO.getMakeupRoomId();
//                if(venueId1.equals(venueId2) && serviceId1.equals(serviceId2) && roomId.equals(makeupRoomId)){
//                    venueAndRoomVO.setMakeupRoomScheduleId(makeupRoomSchedulePO.getId());//封装化妆间档期
//                }
//            }
//        }
//        return makeupRooms;
//    }
    public List<VenueAndRoomVO> findMakeupRoomScheduleByServiceId(Integer companyId, Integer venueId, Integer serviceId, Integer date) {
        //查询服务下面的化妆间  和 状态
        List<VenueAndRoomVO> makeupRooms = serviceService.findMakeupRoomsByServiceId(companyId, venueId, serviceId);

        List<Integer> roomIds = new ArrayList<>();
        //先查询数据
        for(VenueAndRoomVO venueAndRoomVO : makeupRooms){
            roomIds.add(venueAndRoomVO.getRoomId());
        }
        //查询化妆间的档期
        List<MakeupRoomSchedulePO> makeupRoomSchedulePOS = makeupRoomScheduleDao.findMakeupRoomScheduleByDateAndRoomIds(companyId, venueId, null, date, roomIds);
        //如果有档期，封装到makeupRooms中
        for (VenueAndRoomVO venueAndRoomVO : makeupRooms) {
            Integer venueId1 = venueAndRoomVO.getVenueId();
            //Integer serviceId1 = venueAndRoomVO.getServiceId();
            Integer roomId = venueAndRoomVO.getRoomId();
            for (MakeupRoomSchedulePO makeupRoomSchedulePO : makeupRoomSchedulePOS) {
                Integer venueId2 = makeupRoomSchedulePO.getVenueId();
                //Integer serviceId2 = makeupRoomSchedulePO.getServiceId();
                Integer makeupRoomId = makeupRoomSchedulePO.getMakeupRoomId();
                /*if (venueId1.equals(venueId2) && serviceId1.equals(serviceId2) && roomId.equals(makeupRoomId)) {
                    venueAndRoomVO.setMakeupRoomScheduleId(makeupRoomSchedulePO.getId());//封装化妆间档期
                }*/
                if (venueId1.equals(venueId2) && roomId.equals(makeupRoomId)) {
                    venueAndRoomVO.setMakeupRoomScheduleId(makeupRoomSchedulePO.getId());//封装化妆间档期
                }
            }
        }
        List<MakeupRoomSchedulePO> batSave = new ArrayList<>();
        for (VenueAndRoomVO venueAndRoomVO : makeupRooms) {
            MakeupRoomSchedulePO save = new MakeupRoomSchedulePO();
            save.setCompanyId(companyId);
            save.setVenueId(venueId);
            save.setServiceId(serviceId);
            save.setMakeupDay(date);
            save.setMakeupDayLimit(1);
            save.setMakeupRoomId(venueAndRoomVO.getRoomId());
            save.setId(venueAndRoomVO.getMakeupRoomScheduleId());//已经存在的档期
            batSave.add(save);
        }
        if (batSave != null && batSave.size() > 0) {
            //档期表里面不存在的 insert  存在的只更新companyId,查询和更新的companyId是一致的，所以就只是insert不存在的
            makeupRoomScheduleDao.batSave(batSave);
        }

        List<MakeupRoomSchDTO> checkDTO = makeupRoomScheduleDao.checkMakeupRoom(companyId, venueId, null, date);
        for (VenueAndRoomVO venueAndRoomVO : makeupRooms) {
            Integer venueId1 = venueAndRoomVO.getVenueId();
            Integer roomId1 = venueAndRoomVO.getRoomId();
            for (MakeupRoomSchDTO makeupRoomSchDTO : checkDTO) {
                Integer venueId2 = makeupRoomSchDTO.getVenueId();
                Integer roomId2 = makeupRoomSchDTO.getRoomId();
                if (venueId1.equals(venueId2) && roomId1.equals(roomId2)) {
                    venueAndRoomVO.setMakeupRoomScheduleId(makeupRoomSchDTO.getMakeupRoomSchId());
                    if (makeupRoomSchDTO.getCount() == 0) {
                        venueAndRoomVO.setRoomStatus(true);
                    }
                }
            }
        }
        return makeupRooms;
    }

}
