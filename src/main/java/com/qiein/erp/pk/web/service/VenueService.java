package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Venue;

import java.util.List;

public interface VenueService {

    int deleteByPrimaryKey(Integer id);

    int insert(Venue venue);

    Venue selectByPrimaryKey(Integer id);

    List<Venue> selectAll();

    int updateByPrimaryKey(Venue venue);
}
