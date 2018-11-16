package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.VenuePO;
import com.qiein.erp.pk.web.entity.vo.VenueSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 场馆 内景馆 门店
 * author:wang lei
 * date : 2018-11-04
 * */
public interface VenueDao {
    int deleteByPrimaryKey(@Param("id")Integer id,@Param("companyId") Integer companyId);

    int insert(VenuePO venue);

    VenuePO selectByPrimaryKey(@Param("id")Integer id, @Param("companyId") Integer companyId);

    List<VenuePO> selectAll(@Param("companyId") Integer companyId, @Param("venueType")Integer venueType);

    int updateByPrimaryKey(VenuePO venue);

    void venueSort(List<VenuePO> venues);
    /**
     * 获取场景馆下拉框
     * @param companyId
     * @return
     */
    List<VenueSelectVO> getVenues(Integer companyId);

    /**
     * 场馆名字查重
     * @return
     */
    String checkName(VenuePO venuePO);

    /**
     * 场馆手机查重
     * @return
     */
    String checkPhone(VenuePO venuePO);

}