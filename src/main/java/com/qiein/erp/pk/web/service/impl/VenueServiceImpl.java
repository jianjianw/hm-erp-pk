package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.VenueDao;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueDao venueDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return venueDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Venue venue) {
        return venueDao.insert(venue);
    }

    @Override
    public Venue selectByPrimaryKey(Integer id) {
        return venueDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Venue> selectAll(int companyId) {
        return venueDao.selectAll(companyId);
    }

    @Override
    public int updateByPrimaryKey(Venue venue) {
        return venueDao.updateByPrimaryKey(venue);
    }
}
