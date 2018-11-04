package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Venue;

import java.util.List;

public interface VenueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Venue venue);

    Venue selectByPrimaryKey(Integer id);

    List<Venue> selectAll();

    int updateByPrimaryKey(Venue venue);
}