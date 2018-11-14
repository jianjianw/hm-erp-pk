package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.VenueDao;
import com.qiein.erp.pk.web.entity.dto.RoomAndSceneDTO;
import com.qiein.erp.pk.web.entity.dto.VenueDTO;
import com.qiein.erp.pk.web.entity.po.Base;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.BaseService;
import com.qiein.erp.pk.web.service.RoomService;
import com.qiein.erp.pk.web.service.SceneService;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;
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
    @Autowired
    private BaseService baseService;
    @Autowired
    private SceneService sceneService;

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
    public List<VenueDTO> selectAll(Integer companyId,Integer venueType) {
        //查询分店
        List<Venue> venues = venueDao.selectAll(companyId, venueType);
        //查询基地
        List<Base> bases = baseService.selectAll(companyId);

        List<VenueDTO> result = new ArrayList<>();
        try {
            for (Venue venue : venues){
                VenueDTO venueDTO = new VenueDTO();
                BeanUtils.copyProperties(venueDTO, venue);
                for(Base base : bases){
                    if(base.getId().equals(venueDTO.getBaseId())){
                        venueDTO.setBaseName(base.getBaseName());
                        break;
                    }
                }
                result.add(venueDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    @Override
    public int updateByPrimaryKey(Venue venue) {
        return venueDao.updateByPrimaryKey(venue);
    }

    @Override
    public void venueSort(List<Venue> venues) {
        venueDao.venueSort(venues);
    }
    /**
     * 获取场景馆下拉框
     * @param companyId
     * @return
     */
    public List<VenueSelectVO> getVenues(Integer companyId){
        return venueDao.getVenues(companyId);
    }

    @Override
    public List<VenueDTO> showIndex(Integer companyId) {

        //查询所有内景馆
        List<VenueDTO> venueDTOS = selectAll(companyId, 1);
        //封装拍摄间和化妆间的个数
        for(VenueDTO venue :venueDTOS){

            //化妆间的个数
            List<Room> makeupRooms = roomService.findRoomByVenueId(companyId,venue.getId(),1);
            if(makeupRooms != null && makeupRooms.size()> 0 ){
                venue.setMakeupRoomNums(String.valueOf(makeupRooms.size()));
            }
            //拍摄间的个数
            StringBuilder sb = new StringBuilder();
            List<Room> shootRooms = roomService.findRoomByVenueId(companyId,venue.getId(),2);
            if(shootRooms != null && shootRooms.size()> 0 ){
                int size = shootRooms.size();
                sb.append(String.valueOf(size));
            }
            //查询拍摄间下面的拍摄景
            List<Scene> scenes = sceneService.findSceneByVenueId(companyId, venue.getId());
            if(scenes != null && scenes.size()>0){
                int size = scenes.size();
                sb.append("/").append(String.valueOf(size));
                venue.setShootRoomNums(sb.toString());
            }

        }

        return venueDTOS;
    }
}
