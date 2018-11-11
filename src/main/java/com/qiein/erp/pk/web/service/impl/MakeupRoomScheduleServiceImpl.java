package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.web.dao.MakeupRoomScheduleDao;
import com.qiein.erp.pk.web.entity.po.MakeupRoomSchedulePO;
import com.qiein.erp.pk.web.entity.vo.ServiceVenueRoomVO;
import com.qiein.erp.pk.web.service.MakeupRoomScheduleService;
import com.qiein.erp.pk.web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Object selectMakeupRoomSchedule(Integer companyId,Integer venueId,Integer dateTime) {


        //获取场馆下面的服务和房间
        List<ServiceVenueRoomVO> serviceAndMakeupRooms = serviceService.findServiceAndMakeupRooms(companyId, venueId);

        Integer startTime = null;
        Integer endTime = null;
        //先查询所有化妆间档期
        makeupRoomScheduleDao.selectMakeupRoomScheduleByDate(companyId,venueId,startTime,endTime);



        //查询所有日期

        //将化妆间档期封装到要返回的日期中


        //返回一个对象

        //ok




        return null;
    }
}
