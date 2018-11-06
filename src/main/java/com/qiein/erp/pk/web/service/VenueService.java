package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Venue;

import java.util.List;

public interface VenueService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(Venue venue);

    Venue selectByPrimaryKey(Integer id,Integer companyId);

    List<Venue> selectAll(Integer companyId);

    int updateByPrimaryKey(Venue venue);
}
