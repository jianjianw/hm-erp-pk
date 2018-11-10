package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.util.TimeUtil;
import com.qiein.erp.pk.web.dao.ServiceDao;
import com.qiein.erp.pk.web.dao.VenueScheduleDao;
import com.qiein.erp.pk.web.entity.vo.*;
import com.qiein.erp.pk.web.service.VenueScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 场馆档期service
 * author:xiangliang 2018/11/05
 */
@Service
public class VenueScheduleServiceImpl implements VenueScheduleService {
    @Autowired
    private VenueScheduleDao venueScheduleDao;
    @Autowired
    private ServiceDao serviceDao;

    /**
     * 获取场馆档期页面
     *
     * @param monthStr
     * @return
     */
    public VenueScheduleShowVO getScheduleShow(String monthStr, Integer companyId) {
        VenueScheduleShowVO venueScheduleShowVO = new VenueScheduleShowVO();
        List<VenueServiceVO> venueServiceVOS = serviceDao.venueService(companyId);
        //获取该月每天
        List<Integer> everyDayOfMonth = TimeUtil.getMonthEveryDay(TimeUtil.getMonthStartTimeStampByDate(monthStr), TimeUtil.getMonthEndTimeStampByDate(monthStr));
        //给每个档期赋值每一天
        for (VenueServiceVO venueServiceVO : venueServiceVOS) {
            for (ServiceScheduleVO serviceScheduleVO : venueServiceVO.getServiceScheduleVOS()) {
                List<VenueScheduleVO> venueScheduleVOS = new ArrayList<>();
                for (Integer day : everyDayOfMonth) {
                    VenueScheduleVO venueScheduleVO = new VenueScheduleVO();
                    venueScheduleVO.setTime(day);
                    venueScheduleVO.setCount(0);
                    venueScheduleVO.setTargetCount(0);
                    venueScheduleVOS.add(venueScheduleVO);
                }
                serviceScheduleVO.setVenueScheduleVOS(venueScheduleVOS);
            }
        }
        //获取实际数据
        List<OrderVenueScheduleVO> orderVenueScheduleVOS = venueScheduleDao.getVenueSchedule(companyId,TimeUtil.getMonthStartTimeStampByDate(monthStr),TimeUtil.getMonthEndTimeStampByDate(monthStr));
        //把实际值全部赋值 以及去除场馆关闭并且数据为空的list
        for (VenueServiceVO venueServiceVO : venueServiceVOS) {
            int serviceCount = 0;
            for (ServiceScheduleVO serviceScheduleVO : venueServiceVO.getServiceScheduleVOS()) {
                int i = 0;
                for (VenueScheduleVO venueScheduleVO : serviceScheduleVO.getVenueScheduleVOS()) {
                    //赋值 垃圾关林涛
                    for (OrderVenueScheduleVO orderVenueScheduleVO : orderVenueScheduleVOS) {
                        if (venueServiceVO.getVenueId().equals(orderVenueScheduleVO.getVenueId()) && serviceScheduleVO.getServiceId().equals(orderVenueScheduleVO.getServiceId()) && venueScheduleVO.getTime().equals(orderVenueScheduleVO.getVenueDay())) {
                            venueScheduleVO.setTargetCount(orderVenueScheduleVO.getVenueDayLimit());
                            venueScheduleVO.setCount(orderVenueScheduleVO.getCount());
                            i++;
                        }
                    }

                }
                //去除场馆关闭且数据为空的数据
                if (i == 0 && venueServiceVO.getVenueStatus().equals(0)) {
                    serviceScheduleVO.getVenueScheduleVOS().remove(serviceCount);
                } else {
                    serviceCount++;
                }
            }

        }
        //去除场馆关闭且数据为空的数据
        for (VenueServiceVO venueServiceVO : venueServiceVOS) {
            int i = 0;
            if (venueServiceVO.getServiceScheduleVOS().size() == 0 && venueServiceVO.getVenueStatus().equals(0)) {
                venueServiceVOS.remove(i);
            } else {
                i++;
            }
        }
        //辣鸡关林涛要的数据
        List<ServiceScheduleVO> serviceScheduleVOS = new ArrayList<>();
        for (VenueServiceVO venueServiceVO : venueServiceVOS) {
            for(ServiceScheduleVO serviceScheduleVO:venueServiceVO.getServiceScheduleVOS()){
               serviceScheduleVOS.add(serviceScheduleVO);
            }
        }

        venueScheduleShowVO.setVenueServiceVOS(venueServiceVOS);
        venueScheduleShowVO.setServiceScheduleVOS(serviceScheduleVOS);
        return venueScheduleShowVO;
    }
    /**
     * 场馆档期设置页面
     */
    public List<VenueScheduleSetVO> getVenueScheduleSet(Integer companyId){
        return venueScheduleDao.getVenueScheduleSet(companyId);
    }
}
