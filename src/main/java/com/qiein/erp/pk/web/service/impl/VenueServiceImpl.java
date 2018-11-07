package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.VenueDao;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;
import com.qiein.erp.pk.web.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 场馆 内景馆  门店
 * author:wang lei
 * date : 2018-11-04
 * */
@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueDao venueDao;

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
    /**
     * 获取场景馆下拉框
     * @param companyId
     * @return
     */
    public List<VenueSelectVO> getVenues(Integer companyId){
        return venueDao.getVenues(companyId);
    }
}
