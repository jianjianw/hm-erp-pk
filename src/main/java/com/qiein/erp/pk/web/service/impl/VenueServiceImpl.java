package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.RoomConstant;
import com.qiein.erp.pk.web.dao.VenueDao;
import com.qiein.erp.pk.web.entity.dto.VenueDTO;
import com.qiein.erp.pk.web.entity.po.BasePO;
import com.qiein.erp.pk.web.entity.po.RoomPO;
import com.qiein.erp.pk.web.entity.po.ScenePO;
import com.qiein.erp.pk.web.entity.po.VenuePO;
import com.qiein.erp.pk.web.entity.vo.VenueSortVO;
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
    public int insert(VenuePO venue) {
        return venueDao.insert(venue);
    }

    @Override
    public VenuePO selectByPrimaryKey(Integer id, Integer companyId) {
        return venueDao.selectByPrimaryKey(id,companyId);
    }

    @Override
    public List<VenueDTO> selectAll(Integer companyId,Integer venueType) {
        //查询分店
        List<VenuePO> venues = venueDao.selectAll(companyId, venueType);
        //查询基地
        List<BasePO> bases = baseService.selectAll(companyId);

        List<VenueDTO> result = new ArrayList<>();
        try {
            for (VenuePO venue : venues){
                VenueDTO venueDTO = new VenueDTO();
                BeanUtils.copyProperties(venueDTO, venue);
                for(BasePO base : bases){
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
    public int updateByPrimaryKey(VenuePO venue) {
        return venueDao.updateByPrimaryKey(venue);
    }

    @Override
    public void venueSort(List<VenuePO> venues) {
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
            Integer makeupRoomCount = roomService.findRoomCount(companyId, venue.getId(), 1, 1);
            if(makeupRoomCount.equals(0)){
                venue.setMakeupRoomNums("");
            }else{
                venue.setMakeupRoomNums(String.valueOf(makeupRoomCount));
            }

            //拍摄间的个数
            Integer shootRoomCount = roomService.findRoomCount(companyId, venue.getId(), 2, 1);
            //查询场馆下面的拍摄景
            Integer sceneCount = sceneService.findSceneCount(companyId, venue.getId(), 1);

            StringBuilder sb = new StringBuilder();
            //有拍摄间才能有拍摄景
            if(shootRoomCount.equals(0)){
                venue.setShootRoomNums("");
            }else{
                venue.setShootRoomNums(sb.append(shootRoomCount).append("/").append(sceneCount).toString());
            }
        }

        return venueDTOS;
    }

    @Override
    public String checkName(VenuePO venuePO) {
        return venueDao.checkName(venuePO);
    }

    @Override
    public String checkPhone(VenuePO venuePO) {
        return venueDao.checkPhone(venuePO);
    }

    @Override
    public List<VenueSortVO> findBaseAndVenue(Integer companyId, Integer venueType) {
        return venueDao.findBaseAndVenue(companyId,venueType);
    }


}
