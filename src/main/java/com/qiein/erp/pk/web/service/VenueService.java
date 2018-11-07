package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.VenueDTO;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;

import java.util.List;
/**
 * 场馆 内景馆 门店
 * author:wang lei
 * date : 2018-11-04
 * */
public interface VenueService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(Venue venue);

    Venue selectByPrimaryKey(Integer id,Integer companyId);

    List<VenueDTO> selectAll(Integer companyId,Integer venueType);

    int updateByPrimaryKey(Venue venue);

    void venueSort(List<Venue> venues);

    /**
     * 内景馆的首页展示
     * @param companyId
     * @return
     */
    List<VenueDTO> showIndex(Integer companyId);

    /**
     * 获取场景馆下拉框
     * @param companyId
     * @return
     */
    List<VenueSelectVO> getVenues(Integer companyId);



}
