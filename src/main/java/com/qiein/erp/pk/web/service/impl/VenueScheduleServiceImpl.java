package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.util.TimeUtil;
import com.qiein.erp.pk.web.dao.ServiceDao;
import com.qiein.erp.pk.web.dao.VenueScheduleDao;
import com.qiein.erp.pk.web.entity.dto.VenueScheduleSetDTO;
import com.qiein.erp.pk.web.entity.po.VenueScheduleInsertPO;
import com.qiein.erp.pk.web.entity.vo.*;
import com.qiein.erp.pk.web.service.VenueScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
                    Date date = new Date(day*1000);
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    int i=c.get(Calendar.DAY_OF_WEEK);
                    if(i==1){
                        venueScheduleVO.setSunday(true);
                    }
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
                            venueScheduleVO.setScheduleId(orderVenueScheduleVO.getId());
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
    /**
     * 档期设置
     */
    public void VenueScheduleSet(VenueScheduleSetDTO venueScheduleSetDTO){
        List<Integer> dayList=TimeUtil.getMonthEveryDay(venueScheduleSetDTO.getStart(),venueScheduleSetDTO.getEnd());
        List<Integer> week=new ArrayList<>();
        List<VenueScheduleInsertPO> venueScheduleInsertPOS=new ArrayList<>();
        List<VenueScheduleInsertPO> checkPO=venueScheduleDao.getVenueScheduleSetWasIn(venueScheduleSetDTO);
        for(String day:venueScheduleSetDTO.getWeek().split(CommonConstant.STR_SEPARATOR)){
            week.add(Integer.parseInt(day));
        }
        for(Integer day:dayList){
            if(checkWeek(week,day)){
                VenueScheduleInsertPO venueScheduleInsertPO=new VenueScheduleInsertPO();
                venueScheduleInsertPO.setVenueId(venueScheduleSetDTO.getVenueId());
                venueScheduleInsertPO.setServiceId(venueScheduleSetDTO.getServiceId());
                venueScheduleInsertPO.setVenueDay(day);
                venueScheduleInsertPO.setVenueDayLimit(venueScheduleSetDTO.getTarget());
                venueScheduleInsertPO.setCompanyId(venueScheduleSetDTO.getCompanyId());
                for(VenueScheduleInsertPO venueScheduleInsertPO1:checkPO){
                    if(day.equals(venueScheduleInsertPO1.getVenueDay())){
                        venueScheduleInsertPO.setId(venueScheduleInsertPO1.getId());
                    }
                }
                venueScheduleInsertPOS.add(venueScheduleInsertPO);
            }
        }
        venueScheduleDao.insertSet(venueScheduleInsertPOS);

    }
    //校验星期几
    public boolean checkWeek(List<Integer> week,Integer time){
        Date date = new Date(time*1000);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i=c.get(Calendar.DAY_OF_WEEK);
        for(Integer weekDay:week){
            if(i==weekDay){
                return true;
            }
        }
        return false;
    }
}
