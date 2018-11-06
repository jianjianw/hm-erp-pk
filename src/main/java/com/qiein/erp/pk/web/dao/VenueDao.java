package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Venue;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 场馆 内景馆 门店
 * author:wang lei
 * date : 2018-11-04
 * */
public interface VenueDao {
    int deleteByPrimaryKey(@Param("id")Integer id,@Param("companyId") Integer companyId);

    int insert(Venue venue);

    Venue selectByPrimaryKey(@Param("id")Integer id,@Param("companyId") Integer companyId);

    List<Venue> selectAll(@Param("companyId") Integer companyId, @Param("venueType")Integer venueType);

    int updateByPrimaryKey(Venue venue);
}