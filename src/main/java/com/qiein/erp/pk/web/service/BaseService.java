package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Base;

import java.util.List;
/**
 * 场地
 * author:wang lei
 * date : 2018-11-04
 * */
public interface BaseService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(Base base);

    Base selectByPrimaryKey(Integer id,Integer companyId);

    List<Base> selectAll(Integer companyId);

    int updateByPrimaryKey(Base base);

    /**
     * 批量编辑场馆
     * @param bases
     */
    void batInsertOrUpdate(List<Base> bases);

}
