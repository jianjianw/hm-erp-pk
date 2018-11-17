package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.VenueDTO;
import com.qiein.erp.pk.web.entity.po.VenuePO;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;
import com.qiein.erp.pk.web.entity.vo.VenueSortVO;

import java.util.List;
/**
 * 场馆 内景馆 门店
 * author:wang lei
 * date : 2018-11-04
 * */
public interface VenueService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(VenuePO venue);

    VenuePO selectByPrimaryKey(Integer id, Integer companyId);

    List<VenueDTO> selectAll(Integer companyId,Integer venueType);

    int updateByPrimaryKey(VenuePO venue);

    void venueSort(List<VenuePO> venues);

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

    /**
     * 场馆名字查重
     */
    public String checkName(VenuePO venuePO);

    /**
     * 场馆手机查重
     */
    public String checkPhone(VenuePO venuePO);


    /**
     * 查询所有基地 和 基地下面的场馆
     * @param companyId
     * @return
     */
    List<VenueSortVO> findBaseAndVenue(Integer companyId, Integer venueType);
}
