package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.VenueDao;
import com.qiein.erp.pk.web.entity.dto.VenueDTO;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.RoomService;
import com.qiein.erp.pk.web.service.VenueService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/**
 * 场馆 内景馆  门店
 * author:wang lei
 * date : 2018-11-04
 * */
@Service
public class VenueServiceImpl implements VenueService {
    private static Logger logger = LoggerFactory.getLogger(VenueServiceImpl.class);


    @Autowired
    private VenueDao venueDao;
    @Autowired
    private RoomService roomService;

    @Override
    public int deleteByPrimaryKey(Integer id,Integer companyId) {
        return venueDao.deleteByPrimaryKey(id,companyId);
    }

    @Override
    public int insert(Venue venue) {
        return venueDao.insert(venue);
    }

    @Override
    public Venue selectByPrimaryKey(Integer id,Integer companyId) {
        return venueDao.selectByPrimaryKey(id,companyId);
    }

    @Override
    public List<Venue> selectAll(Integer companyId,Integer venueType) {
        return venueDao.selectAll(companyId,venueType);
    }

    @Override
    public int updateByPrimaryKey(Venue venue) {
        return venueDao.updateByPrimaryKey(venue);
    }

    @Override
    public void venueSort(List<Venue> venues) {
        venueDao.venueSort(venues);
    }

    @Override
    public List<VenueDTO> showIndex(Integer companyId) {

        //查询所有内景馆
        List<Venue> venues = venueDao.selectAll(companyId, 1);
        List<VenueDTO> venueDTOS = new ArrayList<>();
        try {
            BeanUtils.copyProperties(venueDTOS, venues);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
       // List<Integer> venueIds = new ArrayList<>();
        for(VenueDTO venue :venueDTOS){
            List<Room> rooms = roomService.findRoomByVenueId(companyId,venue.getId(),1);
            if(rooms == null && rooms.size()> 0 ){
                venue.setMakeupRoomNums(String.valueOf(rooms.size()));
            }

        }
        //查询内景馆下面的

        //要查询场馆下面的化妆间


        //查询场馆下面的拍摄间
        List<Room> rooms1 = roomService.selectAll(companyId, 2);

        //查询拍摄间下面的场景，场景只关联了拍摄间

        return null;
    }
}
